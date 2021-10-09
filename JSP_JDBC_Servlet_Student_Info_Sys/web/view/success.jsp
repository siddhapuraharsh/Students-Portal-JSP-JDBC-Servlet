<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The operation was successful</title>
</head>
<body>
    <div style="text-align: center">
        <span style="color: green; font-size: 20px">${requestScope.success}</span>
        <a href="${pageContext.request.contextPath}/queryServlet">Click me to return to the home page</a>
    </div>
</body>
</html>