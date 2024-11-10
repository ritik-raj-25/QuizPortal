package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import dao.QuizDAO;
import model.Quiz;

import java.io.IOException;
import java.util.List;

public class TakerQuizListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Quiz> quizList = QuizDAO.getQuizzes(); 
        
        request.setAttribute("quizList", quizList);
        
        request.getRequestDispatcher("TakerQuizList.jsp").forward(request, response);
    }
}
