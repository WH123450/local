package com.servlet;

import com.domain.Product;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 王会
 */
@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double chinese = Double.parseDouble(request.getParameter("chinese"));
        double math = Double.parseDouble(request.getParameter("math"));
        double english = Double.parseDouble(request.getParameter("english"));
        String classes = request.getParameter("classes");
        Product product = new Product(id, name, chinese, math, english, classes);
        ProductService productService = new ProductServiceImpl();
        int result = productService.addProduct(product);
        if (result > 0) {
            request.getRequestDispatcher("/ShowAllServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
