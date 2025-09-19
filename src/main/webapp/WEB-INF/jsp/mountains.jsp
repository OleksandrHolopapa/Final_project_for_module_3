<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mountains</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/indexStyle.css">
    <style>
        body {
            background: linear-gradient(rgba(0, 0, 0, 0.25), rgba(0, 0, 0, 0.25)),
                        url('${pageContext.request.contextPath}/resources/images/mountains.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }
        .continue-btn {
            background-color: transparent;
            border: 2px solid white;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: block;
            font-size: 16px;
            margin: 10px auto;
            cursor: pointer;
            width: 66.66%;
            border-radius: 5px;
            transition: all 0.3s ease;
        }
        .continue-btn:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }
    </style>
</head>
<body>
    <h1 class="greeting">${Message}</h1>
    
    <div class="button-container">
        <button class="continue-btn">${rightAnswer}</button>
        <button class="continue-btn" onclick="window.location.href='${pageContext.request.contextPath}/fail?answer=${wrongAnswer}'">${wrongAnswer}</button>
    </div>
</body>
</html>
