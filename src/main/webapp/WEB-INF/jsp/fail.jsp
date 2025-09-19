<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Невірна відповідь</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)),
                        url('${pageContext.request.contextPath}/resources/images/fail.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            background-repeat: no-repeat;
            color: white;
        }
        .message-container {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 30px;
            border-radius: 10px;
            max-width: 600px;
            margin: 0 auto;
        }
        .message {
            font-size: 28px;
            color: #ff6b6b;
            margin-bottom: 30px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
        .button-container {
            display: flex;
            gap: 20px;
            justify-content: center;
            margin-top: 20px;
        }
        .action-btn {
            padding: 12px 25px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            transition: all 0.3s ease;
            text-decoration: none;
            display: inline-block;
        }
        .try-again {
            background-color: #4CAF50;
            color: white;
        }
        .finish-quest {
            background-color: #f44336;
            color: white;
        }
        .action-btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
    <div class="message-container">
        <div class="message">
            На жаль, ви помилилися. Ваша відповідь: ${param.answer}
        </div>
        <div class="button-container">
            <a href="${pageContext.request.contextPath}/mountains" class="action-btn try-again">Try Again</a>
            <a href="http://localhost:8080" class="action-btn finish-quest">Finish the quest</a>
        </div>
    </div>
</body>
</html>
