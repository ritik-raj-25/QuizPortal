package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Result;

public class ResultDAO {

    private static final String URL = "jdbc:derby://localhost:1527/QuizAppDB";
    private static final String USER_NAME = "team1";
    private static final String PASSWORD = "team1";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static int saveResult(Result r) {
        int status = 0;
        String query = "INSERT INTO Result (quizId, takerId, creatorId, score) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, r.getQuizId());
            ps.setInt(2, r.getTakerId());
            ps.setInt(3, r.getCreatorId());
            ps.setInt(4, r.getScore());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static Result getResultById(int resultId) {
        Result result = null;
        String query = "SELECT r.resultId, r.quizId, r.takerId, r.creatorId, r.score, r.dateTaken, "
                + "t.userName AS takerName, c.userName AS creatorName "
                + "FROM Result r "
                + "JOIN users t ON r.takerId = t.userId "
                + "JOIN users c ON r.creatorId = c.userId "
                + "WHERE r.resultId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, resultId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new Result();
                result.setResultId(rs.getInt("resultId"));
                result.setQuizId(rs.getInt("quizId"));
                result.setTakerId(rs.getInt("takerId"));
                result.setCreatorId(rs.getInt("creatorId"));
                result.setScore(rs.getInt("score"));
                result.setDateTaken(rs.getTimestamp("dateTaken"));
                result.setTakerName(rs.getString("takerName"));
                result.setCreatorName(rs.getString("creatorName"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public static List<Result> getResultsByQuizId(int quizId) {
        List<Result> results = new ArrayList<>();
        String query = "SELECT r.resultId, r.quizId, r.takerId, r.creatorId, r.score, r.dateTaken, "
                + "t.userName AS takerName, c.userName AS creatorName "
                + "FROM Result r "
                + "JOIN users t ON r.takerId = t.userId "
                + "JOIN users c ON r.creatorId = c.userId "
                + "WHERE r.quizId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Result result = new Result();
                result.setResultId(rs.getInt("resultId"));
                result.setQuizId(rs.getInt("quizId"));
                result.setTakerId(rs.getInt("takerId"));
                result.setCreatorId(rs.getInt("creatorId"));
                result.setScore(rs.getInt("score"));
                result.setDateTaken(rs.getTimestamp("dateTaken"));
                result.setTakerName(rs.getString("takerName"));
                result.setCreatorName(rs.getString("creatorName"));
                results.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return results;
    }
    
    public static List<Result> getResultsByTakerId(int takerId) {
        List<Result> results = new ArrayList<>();
        String query = "SELECT r.resultId, r.quizId, r.takerId, r.creatorId, r.score, r.dateTaken, "
                + "t.userName AS takerName, c.userName AS creatorName "
                + "FROM Result r "
                + "JOIN users t ON r.takerId = t.userId "
                + "JOIN users c ON r.creatorId = c.userId "
                + "WHERE r.takerId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, takerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Result result = new Result();
                result.setResultId(rs.getInt("resultId"));
                result.setQuizId(rs.getInt("quizId"));
                result.setTakerId(rs.getInt("takerId"));
                result.setCreatorId(rs.getInt("creatorId"));
                result.setScore(rs.getInt("score"));
                result.setDateTaken(rs.getTimestamp("dateTaken"));
                result.setTakerName(rs.getString("takerName"));
                result.setCreatorName(rs.getString("creatorName"));
                results.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return results;
    }

    public static int deleteResult(int resultId) {
        int status = 0;
        String query = "DELETE FROM Result WHERE resultId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, resultId);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}