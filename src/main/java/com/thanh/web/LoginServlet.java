package com.thanh.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.UserDAO;
import com.thanh.dao.impl.UserDAOImpl;
import com.thanh.model.User;
import com.thanh.web.utils.WebUtils;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String encryptedPassword = WebUtils.encryptPassword(password);
        User user = userDAO.findByUsernameAndPassword(username, encryptedPassword);

        if (user == null) {
            request.setAttribute("errorMessage", "Invalid login credentials.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
            dispatcher.forward(request, response);
        } else {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("search-product");
        }
    }

}
