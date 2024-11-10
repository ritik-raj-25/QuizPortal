<html>
<head>
    <title>Quiz Result</title>
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
            max-width: 600px;
            margin: 0 auto;
            padding: 2rem;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 1.5rem;
            font-size: 2rem;
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
        p {
            font-size: 1.2rem;
            color: #666;
            margin-bottom: 2rem;
        }
        .btn-container {
            display: flex;
            flex-direction: column;
            gap: 1rem;
            width: 100%;
            max-width: 300px; /* Add max-width for consistent button width */
            margin: 0 auto; /* Center the button container */
        }
        button, .button-link {
            background-color: #3498db;
            color: white;
            padding: 1rem;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-weight: 500;
            text-transform: uppercase;
            letter-spacing: 0.5px;
            width: 100%;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            box-sizing: border-box; 
        }
        button:hover, .button-link:hover {
            background-color: #2980b9;
        }
        .button-link {
            background-color: #e67e22;
        }
        .button-link:hover {
            background-color: #d35400;
        }
        form {
            margin: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Quiz Completed</h2>
        <p>Your Score: ${score}</p>
        <div class="btn-container">
            <a href="index.html" class="button-link">Go to Home Page</a>
            <form action="TakerQuizListServlet" method="GET">
                <button type="submit">Give Another Quiz</button>
            </form>
        </div>
    </div>
</body>
</html>