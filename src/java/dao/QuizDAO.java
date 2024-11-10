package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Quiz;

public class QuizDAO {
    private static final String URL = "jdbc:derby://localhost:1527/QuizAppDB";
    private static final String USER_NAME = "team1";
    private static final String PASSWORD = "team1";

    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch(SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static int saveQuiz(Quiz q) {
        int status = 0;
        String query = "INSERT INTO Quiz (quizId, creatorId, quizTitle, quizDescription) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, q.getQuizId());
            ps.setInt(2, q.getCreatorId());
            ps.setString(3, q.getQuizTitle());
            ps.setString(4, q.getQuizDescription());
            status = ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int updateQuiz(Quiz q) {
        int status = 0;
        String query = "UPDATE Quiz SET quizTitle = ?, quizDescription = ? WHERE quizId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, q.getQuizTitle());
            ps.setString(2, q.getQuizDescription());
            ps.setInt(3, q.getQuizId());
            status = ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static Quiz getQuizById(int quizId) {
        Quiz q = null;
        String query = "SELECT quizId, creatorId, quizTitle, quizDescription, dateCreated FROM Quiz WHERE quizId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                q = new Quiz();
                q.setQuizId(rs.getInt(1));
                q.setCreatorId(rs.getInt(2));
                q.setQuizTitle(rs.getString(3));
                q.setQuizDescription(rs.getString(4));
                q.setDateCreated(rs.getTimestamp(5));
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return q;
    }

    public static int deleteQuiz(int quizId) {
        int status = 0;
        String query = "DELETE FROM Quiz WHERE quizId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, quizId);
            status = ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<Quiz> getQuizzesByCreatorId(int creatorId) {
        List<Quiz> quizzes = new ArrayList<>();
        String query = "SELECT quizId, creatorId, quizTitle, quizDescription, dateCreated FROM Quiz WHERE creatorId = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, creatorId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Quiz q = new Quiz();
                q.setQuizId(rs.getInt("quizId"));
                q.setCreatorId(rs.getInt("creatorId"));
                q.setQuizTitle(rs.getString("quizTitle"));
                q.setQuizDescription(rs.getString("quizDescription"));
                q.setDateCreated(rs.getTimestamp("dateCreated"));
                quizzes.add(q);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return quizzes;
    }
    
    public static List<Quiz> getQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        String query = "SELECT quizId, creatorId, quizTitle, quizDescription, dateCreated FROM Quiz";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Quiz q = new Quiz();
                q.setQuizId(rs.getInt("quizId"));
                q.setCreatorId(rs.getInt("creatorId"));
                q.setQuizTitle(rs.getString("quizTitle"));
                q.setQuizDescription(rs.getString("quizDescription"));
                q.setDateCreated(rs.getTimestamp("dateCreated"));
                quizzes.add(q);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return quizzes;
    }
}
