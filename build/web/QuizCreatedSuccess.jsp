<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Created Successfully</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: linear-gradient(135deg, #f5f7fa 0%, #e4e8eb 100%);
            line-height: 1.6;
        }

        .success-container {
            background-color: white;
            padding: 2.5rem;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 90%;
            position: relative;
            overflow: hidden;
        }

        /* Success checkmark animation */
        .success-container::before {
            content: '?';
            position: absolute;
            top: -15px;
            right: -15px;
            background: #27ae60;
            color: white;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            transform: rotate(15deg);
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 2rem;
            font-size: 1.8rem;
            position: relative;
            padding-bottom: 1rem;
        }

        h2::after {
            content: '';
            position: absolute;
            bottom: 0;
            left: 50%;
            transform: translateX(-50%);
            width: 60px;
            height: 3px;
            background-color: #3498db;
            border-radius: 2px;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            gap: 1rem;
            margin-top: 2rem;
        }

        a {
            display: inline-block;
            padding: 0.8rem 1.5rem;
            border-radius: 5px;
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s ease;
            width: 100%;
            box-sizing: border-box;
        }

        .primary-button {
            background-color: #3498db;
            color: white;
        }

        .primary-button:hover {
            background-color: #2980b9;
            transform: translateY(-2px);
        }

        .secondary-button {
            background-color: #f8f9fa;
            color: #2c3e50;
            border: 2px solid #e9ecef;
        }

        .secondary-button:hover {
            background-color: #e9ecef;
            transform: translateY(-2px);
        }


        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .success-container {
            animation: fadeIn 0.6s ease-out;
        }

        @media (max-width: 480px) {
            .success-container {
                padding: 2rem;
                width: 85%;
            }

            h2 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>
<body>
    <div class="success-container">
        <h2>Your Quiz has been Created Successfully!</h2>
        <div class="button-container">
            <a href="index.html" class="primary-button">Go to Home Page</a>
            <a href="CreateQuiz.jsp" class="secondary-button">Create Another Quiz</a>
        </div>
    </div>
</body>
</html>