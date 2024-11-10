<%@ page import="java.util.List, model.Question, model.Quiz" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Take Quiz</title>
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

        form {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 2rem;
        }

        h3 {
            color: #2c3e50;
            margin: 1.5rem 0 0.5rem 0;
            font-size: 1.4rem;
            line-height: 1.3;
        }

        label {
            color: #666;
            font-size: 1rem;
            display: block;
            margin-bottom: 1rem;
        }

        input[type="radio"] {
            margin-right: 10px;
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

        @media (max-width: 768px) {
            body {
                padding: 1rem;
            }

            .container {
                padding: 1rem;
            }

            h2 {
                font-size: 1.8rem;
            }

            h3 {
                font-size: 1.2rem;
            }

            button {
                padding: 0.8rem;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Take Quiz</h2>
        <%
            int quizId = Integer.parseInt(request.getParameter("quizId"));
        %>
        <form action="SubmitQuizServlet" method="POST">
            <input type="hidden" name="quizId" value="<%=quizId%>"> 
            <c:forEach var="question" items="${questions}">
                <h3>${question.questionText}</h3>
                <label><input type="radio" name="question${question.questionId}" value="A"> ${question.options.get(0)}</label>
                <label><input type="radio" name="question${question.questionId}" value="B"> ${question.options.get(1)}</label>
                <label><input type="radio" name="question${question.questionId}" value="C"> ${question.options.get(2)}</label>
                <label><input type="radio" name="question${question.questionId}" value="D"> ${question.options.get(3)}</label>
            </c:forEach>
            <button type="submit">Submit Quiz</button>
        </form>
    </div>
</body>
</html>
