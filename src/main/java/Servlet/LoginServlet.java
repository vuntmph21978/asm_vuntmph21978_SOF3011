package Servlet;

import Model.User;
import Repository.LoginRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/home","/"})
public class LoginServlet extends HttpServlet {
    LoginRepository loginRepository = new LoginRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri = request.getRequestURI();
    if (uri.contains("/")){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }else if (uri.contains("home")){
        request.getRequestDispatcher("/View/Home/home.jsp").forward(request,response);
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isValid = loginRepository.validate(username, password);
        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/login.jsp");
        }

    }
}
