<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in | Student information management system</title>
    <style>
        body{ background-image: url("${pageContext.request.contextPath}/images/login.jpg");}
        .header{ width: 700px;height: 100px;font-size: 55px;font-family: "JetBrains Mono", serif;
                 margin: 90px auto 0px;text-align: center;line-height: 100px;}
        .content{ width: 500px;height: 300px;background: rgba(122,197,205,0.6);
                  margin: 30px auto 0px;padding-top: 30px;}
        .content table .input{ width: 250px;height: 40px;border:1px solid #ccc;
                               outline: none;margin: 10px auto;}
        .checkcode{ width: 140px;height: 40px;border:1px solid #ccc;outline: none;
                    margin: 10px 4px 7px auto;}
        .codeImg{
            width: 110px;height: 40px;position: absolute;top: 388px;
        }
        .button{ width: 70px;height: 35px;margin-top: 10px;}
        .submit{ width: 70px;height: 35px;margin-top: 10px;margin-left: 140px;}
        .error{ width: 200px;height: 50px;margin: 0 auto;text-align: center;
                line-height: 50px;color: red;}
    </style>
    <script type="text/javascript">
        window.onload = function(){
            //Click to switch the verification code
            document.getElementById("codeImg").onclick = function(){
                this.src = "${pageContext.request.contextPath}/checkCodeServlet?t="+new Date().getTime();
            }
        }
    </script>
</head>
<body>
    <div class="header">Student information management system</div>
    <div class="content">
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <table align="center">
            <tr>
                <td>user name:</td>
                <td><input class="input" type="text" name="username" id="username" placeholder="enter one user name"></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input class="input" type="password" name="password" id="password" placeholder="Please input a password"></td>
            </tr>
            <tr>
                <td>Verification Code:</td>
                <td>
                    <input class="checkcode" type="text" name="checkCode" id="checkCode" placeholder="Please enter the verification code">
                    <img id="codeImg" class="codeImg" src="${pageContext.request.contextPath}/checkCodeServlet" alt="Verification Code">
                </td>
            </tr>
            <tr>
                <td><input class="button" type="reset" value="Reset"></td>
                <td><input id="loginBtn" class="submit" type="submit" value="Sign in"></td>
            </tr>
        </table>
        </form>
        <div class="error">
            <%= request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
            <%= request.getAttribute("login_msg") == null ? "" : request.getAttribute("login_msg")%>
            <%= request.getAttribute("code_error") == null ? "" : request.getAttribute("code_error")%>
        </div>
    </div>
</body>
</html>