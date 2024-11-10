package controller;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import dao.QuizDAO;
import dao.QuestionDAO;
import model.Quiz;
import model.Question;

public class CreateQuizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId")); 
        String quizTitle = request.getParameter("quizTitle");
        String quizDescription = request.getParameter("quizDescription");
        int userId = (int)request.getSession().getAttribute("userId");  

        
        Quiz quiz = new Quiz();
        quiz.setQuizId(quizId);  
        quiz.setQuizTitle(quizTitle);
        quiz.setQuizDescription(quizDescription);
        quiz.setCreatorId(userId);

       
        QuizDAO.saveQuiz(quiz);

        
        int questionCount = 1;
        while (request.getParameter("question" + questionCount) != null) {
            String questionText = request.getParameter("question" + questionCount);
            
            int questionId = Integer.parseInt(request.getParameter("questionId" + questionCount)); 

           
            List<String> options = new ArrayList<>();
            options.add(request.getParameter("optionA" + questionCount));
            options.add(request.getParameter("optionB" + questionCount));
            options.add(request.getParameter("optionC" + questionCount));
            options.add(request.getParameter("optionD" + questionCount));

            String correctAnswer = request.getParameter("correctAnswer" + questionCount);

            
            Question question = new Question();
            question.setQuizId(quizId); 
            question.setQuestionId(questionId); 
            question.setQuestionText(questionText);
            question.setOptions(options);  
            question.setCorrectAnswer(correctAnswer);

            
            QuestionDAO.saveQuestion(question);

            questionCount++;
        }

       
        response.sendRedirect("QuizCreatedSuccess.jsp"); 
    }
}
