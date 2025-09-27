<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forest</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/forestStyle.css">
</head>
<body>
<h1 class="greeting">${username}${message}</h1>
<div class="container">
    <div class="button-container">
        <button class="continue-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/river'">
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