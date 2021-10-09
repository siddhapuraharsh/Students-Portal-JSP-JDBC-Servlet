package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. Set the code
        request.setCharacterEncoding("UTF-8");
        //2. Get request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //3. Get the generated verification code first
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //Delete captcha in session field
        session.removeAttribute("checkCode_session");
        //4. Encapsulate the User object
        UserDao dao = new UserDao();
        User loginUser = dao.login(new User(username,password));
        //5. Judge whether the verification code is correct
        if(checkCode == null || !checkCode_session.equalsIgnoreCase(checkCode)){
            //Verification code error
            request.setAttribute("code_error","Verification code error!");
            //Forward to home page with error message
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            //The verification code is correct
            //Determine whether the user name and password are correct
            if(loginUser == null){
                //Login failed
                //Store information to request
                request.setAttribute("login_error","Wrong user name or password!");
                //Forward to home page with error message
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else{
                //Login successful
                //Store the data in the session domain filter
                request.getSession().setAttribute("user",loginUser);
                //Redirect to student information management system page
                response.sendRedirect(request.getContextPath()+"/queryServlet");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}