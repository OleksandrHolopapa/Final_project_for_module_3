<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Beginning</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/indexStyle.css">
</head>
<body>
    <h1 class="greeting">Well, here we are, Traveler! Are you ready to continue your journey alone?</h1>
    
    <div class="button-container">
        <a href="${pageContext.request.contextPath}/mountains" class="continue-btn">Continue the journey yourself</a>
        <div class="history-toggle" onclick="toggleHistory()">A bit of history</div>
    </div>
    
    <div class="history-content-wrapper">
        <div class="history-content" id="historyContent">
            <%@ include file="/resources/txt/intro.txt" %>
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