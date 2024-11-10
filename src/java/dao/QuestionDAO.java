package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Question;

public class QuestionDAO {
    private static final String URL = "jdbc:derby://localhost:1527/QuizAppDB";
    private static final String USER_NAME = "team1";
    private static final String PASSWORD = "team1";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch(SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static int saveQuestion(Question q) {
        int status = 0;
        String query = "INSERT INTO Question (questionId, quizId, questionText, options, correctAnswer) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, q.getQuestionId());
            ps.setInt(2, q.getQuizId());
            ps.setString(3, q.getQuestionText());
            ps.setString(4, String.join(",", q.getOptions()));  
            ps.setString(5, q.getCorrectAnswer());
            status = ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updateQuestion(Question q) {
        int status = 0;
        String query = "UPDATE Question SET questionText = ?, options = ?, correctAnswer = ? WHERE questionId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, q.getQuestionText());
            ps.setString(2, String.join(",", q.getOptions()));  // Joining the options with commas
            ps.setString(3, q.getCorrectAnswer());
            ps.setInt(4, q.getQuestionId());
            status = ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static Question getQuestionById(int questionId) {
        Question q = new Question();
        String query = "SELECT questionId, quizId, questionText, options, correctAnswer FROM Question WHERE questionId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, questionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                q.setQuestionId(rs.getInt(1));
                q.setQuizId(rs.getInt(2));
                q.setQuestionText(rs.getString(3));
                String optionsStr = rs.getString(4);
                q.setOptions(List.of(optionsStr.split(","))); 
                q.setCorrectAnswer(rs.getString(5));
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return q;
    }

    public static int deleteQuestion(int questionId) {
        int status = 0;
        String query = "DELETE FROM Question WHERE questionId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, questionId);
            status = ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<Question> getQuestionsByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT questionId, quizId, questionText, options, correctAnswer FROM Question WHERE quizId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                q.setQuizId(rs.getInt("quizId"));
                q.setQuestionText(rs.getString("questionText"));
                String optionsStr = rs.getString("options");
                q.setOptions(List.of(optionsStr.split(",")));  
                q.setCorrectAnswer(rs.getString("correctAnswer"));
                questions.add(q);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return questions;
    }
}
