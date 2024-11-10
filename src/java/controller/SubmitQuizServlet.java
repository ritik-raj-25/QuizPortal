package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import dao.QuestionDAO;
import model.Question;
import java.io.IOException;
import java.util.List;

public class SubmitQuizServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        
        List<Question> questions = QuestionDAO.getQuestionsByQuizId(quizId);

        int score = 0;
        
        for (Question question : questions) {
            String selectedAnswer = request.getParameter("question" + question.getQuestionId());
            
            if (selectedAnswer != null && selectedAnswer.equals(question.getCorrectAnswer())) {
                score++;
            }
        }

        request.setAttribute("score", score);
        
        request.getRequestDispatcher("QuizResult.jsp").forward(request, response);
    }
}
