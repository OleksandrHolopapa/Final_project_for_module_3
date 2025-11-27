<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Boat</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/boatStyle.css">
</head>
<body>
<h1 class="greeting">${message} ${username}!</h1>

<div class="button-container">
    <a href="${pageContext.request.contextPath}/success" class="continue-btn">${choice}</a>
</div>
</body>
</html>