package cn.itcast.web.servlet;

import cn.itcast.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set encoding
        request.setCharacterEncoding("utf-8");
        //Get request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        //Call the delete method of StudentDao
        StudentDao dao = new StudentDao();
        dao.delete(id);
        //Deletion succeeded
        //Store information to the request domain and forward to success.jsp page
        request.setAttribute("success","Operation successful!");
        request.getRequestDispatcher("/view/success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}