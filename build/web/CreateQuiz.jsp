<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.QuizDAO, dao.QuestionDAO, model.Quiz, model.Question" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Quiz</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 2rem;
            background: linear-gradient(135deg, #f5f7fa 0%, #e4e8eb 100%);
            line-height: 1.6;
        }

        .quiz-container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 2rem;
            font-size: 2rem;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
        }

        h3 {
            color: #2c3e50;
            margin-top: 2rem;
            padding-top: 2rem;
            border-top: 2px solid #eee;
        }

        .form-section {
            margin-bottom: 2rem;
            padding: 1.5rem;
            background-color: #f8f9fa;
            border-radius: 8px;
        }

        .question-section {
            margin-bottom: 2rem;
            padding: 1.5rem;
            background-color: #fff;
            border: 1px solid #eee;
            border-radius: 8px;
        }

        .form-group {
            margin-bottom: 1.2rem;
        }

        label {
            display: block;
            color: #2c3e50;
            font-weight: 500;
            margin-bottom: 0.5rem;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 0.8rem;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1rem;
            transition: border-color 0.3s ease;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
            min-height: 80px;
        }

        input:focus,
        textarea:focus {
            outline: none;
            border-color: #3498db;
            box-shadow: 0 0 0 2px rgba(52, 152, 219, 0.2);
        }

        .options-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 1rem;
        }

        button {
            background-color: #3498db;
            color: white;
            padding: 1rem 2rem;
            border: none;
            border-radius: 5px;
            font-size: 1.1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
            margin-top: 2rem;
        }

        button:hover {
            background-color: #2980b9;
        }

        @media (max-width: 768px) {
            .options-grid {
                grid-template-columns: 1fr;
            }

            body {
                padding: 1rem;
            }

            .quiz-container {
                padding: 1rem;
            }
        }
    </style>
</head>
<body>
    <div class="quiz-container">
        <h2>Create a New Quiz</h2>
        <form action="CreateQuizServlet" method="POST">
            <!-- Quiz Details Section -->
            <div class="form-section">
                <div class="form-group">
                    <label for="quizId">Quiz ID:</label>
                    <input type="text" id="quizId" name="quizId" required>
                </div>
                <div class="form-group">
                    <label for="quizTitle">Quiz Title:</label>
                    <input type="text" id="quizTitle" name="quizTitle" required>
                </div>
                <div class="form-group">
                    <label for="quizDescription">Quiz Description:</label>
                    <textarea id="quizDescription" name="quizDescription" required></textarea>
                </div>
            </div>

            <!-- Question 1 -->
            <div class="question-section">
                <h3>Question 1</h3>
                <div class="form-group">
                    <label for="questionId1">Question ID:</label>
                    <input type="text" id="questionId1" name="questionId1" required>
                </div>
                <div class="form-group">
                    <label for="question1">Question Text:</label>
                    <textarea id="question1" name="question1" required></textarea>
                </div>
                <div class="options-grid">
                    <div class="form-group">
                        <label for="optionA1">Option A:</label>
                        <input type="text" id="optionA1" name="optionA1" required>
                    </div>
                    <div class="form-group">
                        <label for="optionB1">Option B:</label>
                        <input type="text" id="optionB1" name="optionB1" required>
                    </div>
                    <div class="form-group">
                        <label for="optionC1">Option C:</label>
                        <input type="text" id="optionC1" name="optionC1" required>
                    </div>
                    <div class="form-group">
                        <label for="optionD1">Option D:</label>
                        <input type="text" id="optionD1" name="optionD1" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="correctAnswer1">Correct Answer (A/B/C/D):</label>
                    <input type="text" id="correctAnswer1" name="correctAnswer1" required>
                </div>
            </div>

            <!-- Question 2 -->
            <div class="question-section">
                <h3>Question 2</h3>
                <div class="form-group">
                    <label for="questionId2">Question ID:</label>
                    <input type="text" id="questionId2" name="questionId2" required>
                </div>
                <div class="form-group">
                    <label for="question2">Question Text:</label>
                    <textarea id="question2" name="question2" required></textarea>
                </div>
                <div class="options-grid">
                    <div class="form-group">
                        <label for="optionA2">Option A:</label>
                        <input type="text" id="optionA2" name="optionA2" required>
                    </div>
                    <div class="form-group">
                        <label for="optionB2">Option B:</label>
                        <input type="text" id="optionB2" name="optionB2" required>
                    </div>
                    <div class="form-group">
                        <label for="optionC2">Option C:</label>
                        <input type="text" id="optionC2" name="optionC2" required>
                    </div>
                    <div class="form-group">
                        <label for="optionD2">Option D:</label>
                        <input type="text" id="optionD2" name="optionD2" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="correctAnswer2">Correct Answer (A/B/C/D):</label>
                    <input type="text" id="correctAnswer2" name="correctAnswer2" required>
                </div>
            </div>

            <button type="submit">Create Quiz</button>
        </form>
    </div>
</body>
</html>