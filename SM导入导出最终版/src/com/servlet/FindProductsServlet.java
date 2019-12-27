package com.servlet;

import com.domain.Product;
import com.domain.Student;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 王会
 */
@WebServlet(name = "FindProductsServlet",value = ("/FindProductsServlet"))
public class FindProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        ProductService productService=new ProductServiceImpl();
        Product product=productService.findProduct(id);
        if (product==null)
        request.getRequestDispatcher("response1.jsp").forward(request,response);
        else{
        request.setAttribute("product",product);
        request.getRequestDispatcher("/squery.jsp").forward(request,response);}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
