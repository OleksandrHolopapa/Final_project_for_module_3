<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/indexStyle.css">
</head>
<body>
<h1 class="greeting">${message}</h1>

<form action="${pageContext.request.contextPath}/travel" method="GET" class="input-form">
    <div class="input-container">
        <input type="text" id="userInput" name="userInput" placeholder="Enter your name here..." class="text-input" required>
    </div>
    <div class="button-container">
        <button type="submit" class="continue-btn">${button}</button>
        <div class="history-toggle" type="button" onclick="toggleHistory()">A bit of history</div>
    </div>
</form>

<div class="history-content-wrapper">
    <div class="history-content" id="historyContent">
        ${intro}
    </div>
</div>

<script>
    function toggleHistory() {
        const content = document.getElementById('historyContent');
        content.classList.toggle('visible');
    }
</script>
</body>
</html>