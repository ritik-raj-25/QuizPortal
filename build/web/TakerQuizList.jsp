<%@ page import="java.util.List, model.Quiz" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Available Quizzes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 2rem;
            background: linear-gradient(135deg, #f5f7fa 0%, #e4e8eb 100%);
            line-height: 1.6;
            min-height: 100vh;
        }

        .container {
            max-width: 900px;
            margin: 0 auto;
            padding: 2rem;
        }

        h2 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 2.5rem;
            font-size: 2.2rem;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
            position: relative;
        }

        h2::after {
            content: '';
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
            width: 100px;
            height: 3px;
            background: linear-gradient(to right, #3498db, #2980b9);
            border-radius: 2px;
        }

        .quiz-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 2rem;
            padding: 1rem;
        }

        .quiz-card {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            overflow: hidden;
        }

        .quiz-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }

        .quiz-content {
            padding: 1.5rem;
        }

        h3 {
            color: #2c3e50;
            margin: 0 0 1rem 0;
            font-size: 1.4rem;
            line-height: 1.3;
        }

        p {
            color: #666;
            margin: 0 0 1.5rem 0;
            font-size: 1rem;
            line-height: 1.6;
        }

        .quiz-card form {
            margin-top: auto;
        }

        button {
            background-color: #3498db;
            color: white;
            width: 100%;
            padding: 1rem;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-weight: 500;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        button:hover {
            background-color: #2980b9;
        }

 
        .empty-state {
            text-align: center;
            padding: 3rem;
            color: #666;
            background-color: white;
            border-radius: 10px;
            margin: 2rem auto;
            max-width: 500px;
        }

        @media (max-width: 768px) {
            body {
                padding: 1rem;
            }

            .container {
                padding: 1rem;
            }

            .quiz-grid {
                grid-template-columns: 1fr;
                gap: 1.5rem;
            }

            h2 {
                font-size: 1.8rem;
            }
        }

        
        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .quiz-card {
            animation: fadeInUp 0.5s ease-out forwards;
        }

        .quiz-card:nth-child(2) {
            animation-delay: 0.1s;
        }

        .quiz-card:nth-child(3) {
            animation-delay: 0.2s;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Available Quizzes</h2>
        
        <div class="quiz-grid">
            <c:choose>
                <c:when test="${not empty quizList}">
                    <c:forEach var="quiz" items="${quizList}">
                        <div class="quiz-card">
                            <div class="quiz-content">
                                <h3>${quiz.quizTitle}</h3>
                                <p>${quiz.quizDescription}</p>
                                <form action="StartQuizServlet" method="POST">
                                    <input type="hidden" name="quizId" value="${quiz.quizId}">
                                    <button type="submit">Start Quiz</button>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="empty-state">
                        <h3>No Quizzes Available</h3>
                        <p>Check back later for new quizzes!</p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>