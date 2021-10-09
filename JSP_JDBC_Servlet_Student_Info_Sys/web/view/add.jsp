<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add to | Student information management system</title>
    <style>
        .header{ width: 400px;height: 70px;font-family: "JetBrains Mono", serif;
            font-size: 40px;text-align: center;line-height: 70px;
            margin: 50px auto 10px;}
    </style>
</head>
<body bgcolor="beige">
    <div class="header">Add student information</div>
    <form action="${pageContext.request.contextPath}/addServlet" method="post" name="addForm">
        <table width="400px" align="center" border="1" cellspacing="0">
            <tr>
                <td>No</td>
                <td><input type="text" name="id" placeholder="Please enter student number"></td>
            </tr>
            <tr>
                <td>full name:</td>
                <td><input type="text" name="name" placeholder="Please enter name"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="sex">male
                    <input type="radio" name="sex">female
                </td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="text" name="age" placeholder="Please enter age"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" placeholder="Please enter the address"></td>
            </tr>
            <tr>
                <td>Major:</td>
                <td><input type="text" name="major" placeholder="Please enter major"></td>
            </tr>
            <tr>
                <td>introduce oneself to:</td>
                <td><textarea name="info" cols="20" rows="5"></textarea></td>
            </tr>
            <tr align="center">
                <td><input type="reset" value="Reset"></td>
                <td><input type="submit" value="confirm"></td>
            </tr>
        </table>
    </form>
</body>
</html>