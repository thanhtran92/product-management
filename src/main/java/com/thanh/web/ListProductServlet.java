package com.thanh.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.ProductDAO;
import com.thanh.dao.impl.ProductDAOImpl;

@WebServlet(urlPatterns = "/list-product.do")
public class ListProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO = new ProductDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("productList", productDAO.getAllProducts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/product-list.jsp");
        dispatcher.forward(request, response);
    }
}
