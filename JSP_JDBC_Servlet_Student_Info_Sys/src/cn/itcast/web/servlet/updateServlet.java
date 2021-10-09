package cn.itcast.web.servlet;

import cn.itcast.dao.StudentDao;
import cn.itcast.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set encoding
        request.setCharacterEncoding("utf-8");
        //Get request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String major = request.getParameter("major");
        String info = request.getParameter("info");
        Student stu = new Student(id,name,sex,age,address,major,info);
        //Call the method in StudentDao to modify it
        StudentDao dao = new StudentDao();
        dao.update(stu);
        //Modification succeeded
        //Store information to the request domain and forward to success.jsp page
        request.setAttribute("success","Operation successful!");
        request.getRequestDispatcher("/view/success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}