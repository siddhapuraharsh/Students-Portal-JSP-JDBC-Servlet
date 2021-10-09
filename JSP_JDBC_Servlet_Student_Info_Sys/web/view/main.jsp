<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>home page | Student information management system</title>
    <style>
        .header{ width: 400px;height: 70px;font-family: "JetBrains Mono", serif;
            font-size: 40px;text-align: center;line-height: 70px;
            margin: 50px auto 10px;}
        .add{ display: block;width: 55px;height: 35px;background-color: pink;
              border: 1px solid red;position: absolute;left: 1180px;top: 80px;
              text-decoration: none;text-align: center;line-height: 35px;}
    </style>
</head>
<body bgcolor="beige">
    <div class="header">Student information management</div>
    <a class="add" href="${pageContext.request.contextPath}/view/add.jsp">add to</a>
    <table width="1000px" align="center" border="1" cellspacing="0">
        <tr>
            <th>number</th><th>full name</th><th>Gender</th><th>Age</th>
            <th>address</th><th>major</th><th>introduce oneself to</th><th>operation</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="stu" varStatus="s">
            <c:if test="${s.count % 2 == 0}">
            <tr align="center" bgcolor="pink">
                <td>${stu.id}</td><td>${stu.name}</td><td>${stu.sex}</td><td>${stu.age}</td>
                <td>${stu.address}</td><td>${stu.major}</td><td>${stu.info}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/view/query.jsp">see</a>
                    <a href="${pageContext.request.contextPath}/view/update.jsp">modify</a>
                    <a href="${pageContext.request.contextPath}/view/delete.jsp">delete</a>
                </td>
            </tr>
            </c:if>
            <c:if test="${s.count % 2 != 0}">
            <tr align="center" bgcolor="skyblue">
                <td>${stu.id}</td><td>${stu.name}</td><td>${stu.sex}</td><td>${stu.age}</td>
                <td>${stu.address}</td><td>${stu.major}</td><td>${stu.info}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/view/query.jsp">see</a>
                    <a href="${pageContext.request.contextPath}/view/update.jsp">modify</a>
                    <a href="${pageContext.request.contextPath}/view/delete.jsp">delete</a>
                </td>
            </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>