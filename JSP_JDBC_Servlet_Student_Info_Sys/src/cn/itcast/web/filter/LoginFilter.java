package cn.itcast.web.filter;

import cn.itcast.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //0. Forced transformation
        HttpServletRequest request = (HttpServletRequest) req;
        //1. Get the request path of resources
        String uri = request.getRequestURI();
        //2. Judge whether the resources related to login are included. Note: pay attention to exclude resources such as css/js / images / captcha
        if(uri.contains("/index.jsp") || uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/images/") || uri.contains("/checkCodeServlet")){
            chain.doFilter(req, resp);
        }else {
            //No, you need to verify whether the user is logged in
            //3. Get user from session
            User user = (User)request.getSession().getAttribute("user");
            if(user != null){
                //It's logged in and released
                chain.doFilter(req,resp);
            }else{
                //No sign in. Jump to login page
                request.setAttribute("login_msg","You are not logged in! Please log in first");
                //Data transfer, use forwarding
                request.getRequestDispatcher("/index.jsp").forward(request,resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}