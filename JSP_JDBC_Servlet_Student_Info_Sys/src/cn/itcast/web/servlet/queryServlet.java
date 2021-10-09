package cn.itcast.web.servlet;

import cn.itcast.dao.StudentDao;
import cn.itcast.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set encoding
        request.setCharacterEncoding("utf-8");
        //1. Call StudentDao method to query
        StudentDao dao = new StudentDao();
        List<Student> list = dao.select();
        //2. Store the query result list collection in the request field
        request.setAttribute("list",list);
        //3. Forward to main.jsp
        request.getRequestDispatcher("/view/main.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}