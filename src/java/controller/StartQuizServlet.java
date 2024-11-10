package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import dao.QuestionDAO;
import model.Question;
import java.io.IOException;
import java.util.List;

public class StartQuizServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        List<Question> questions = QuestionDAO.getQuestionsByQuizId(quizId);
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
    }
}