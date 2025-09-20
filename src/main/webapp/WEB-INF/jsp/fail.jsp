<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fail</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/failStyle.css">
</head>
<body>
<div class="message-container">
    <div class="message">
        ${param.answer}
    </div>
    <div class="button-container">
        <a href="${pageContext.request.contextPath}/mountains" class="action-btn try-again">Try Again</a>
        <a href="http://localhost:8080" class="action-btn finish-quest">Finish the quest</a>
    </div>
</div>
</body>
</html>