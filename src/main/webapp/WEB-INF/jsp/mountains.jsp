<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mountains</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/indexStyle.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mountainsStyle.css">
</head>
<body>
    <div class="container">
        <h1 class="greeting">${message}</h1>
        
        <div class="button-container">
            <button class="continue-btn" 
                    onclick="window.location.href='${pageContext.request.contextPath}/crossroads'">
                ${rightAnswer}
            </button>
            <button class="continue-btn" 
                    onclick="window.location.href='${pageContext.request.contextPath}/fail?answer=${consequencesOfWrongChoices}'">
                ${wrongAnswer}
            </button>
        </div>
    </div>
</body>
</html>