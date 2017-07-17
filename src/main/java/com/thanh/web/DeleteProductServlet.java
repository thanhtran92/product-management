package com.thanh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.thanh.dao.ProductDAO;
import com.thanh.dao.impl.ProductDAOImpl;
import com.thanh.model.Product;

@WebServlet(urlPatterns = "/delete-product")
public class DeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO = new ProductDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idAsStr = request.getParameter("id");
        if (!StringUtils.isNullOrEmpty(idAsStr)) {
            productDAO.deleteProduct(new Product(Integer.parseInt(idAsStr)));
        }
        response.sendRedirect("search-product");
    }

}
