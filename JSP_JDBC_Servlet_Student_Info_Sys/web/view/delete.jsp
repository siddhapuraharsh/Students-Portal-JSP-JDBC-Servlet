<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete | Student information management system</title>
    <style>
        .header{ width: 400px;height: 70px;font-family: "JetBrains Mono", serif;
            font-size: 40px;text-align: center;line-height: 70px;
            margin: 50px auto 10px;}
    </style>
</head>
<body bgcolor="beige">
    <div class="header">Delete student information</div>
    <form action="${pageContext.request.contextPath}/deleteServlet">
        <table width="300px" align="center" border="1" cellspacing="0">
            <tr>
                <td>No</td>
                <td><input type="text" name="id" placeholder="Please enter student number"></td>
            </tr>
            <tr align="center">
                <td><input type="reset" value="Reset"></td>
                <td><input type="submit" value="confirm"></td>
            </tr>
        </table>
    </form>
</body>
</html>