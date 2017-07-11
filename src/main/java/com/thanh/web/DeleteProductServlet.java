package com.thanh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.ProductDAO;
import com.thanh.dao.impl.ProductDAOImpl;
import com.thanh.model.Product;

@WebServlet(urlPatterns = "/delete-product.do")
public class DeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO = new ProductDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(new Product(id));
        response.sendRedirect("/product-management/list-product.do");
    }

}
