<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Travel</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/travelStyle.css">
</head>
<body>
<h1 class="greeting">${message} ${username}?</h1>
<div class="container">
    <div class="button-container">
        <button class="continue-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/mountains'">
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