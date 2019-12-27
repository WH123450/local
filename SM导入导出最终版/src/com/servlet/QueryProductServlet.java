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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 */
@WebServlet(name = "QueryProductServlet",value = "/QueryProductServlet")
public class QueryProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//设定请求的字符集
        String keyword=request.getParameter("keyword");
        ProductService productService=new ProductServiceImpl();
        List<Product> list = new ArrayList<Product>();
        list=productService.queryProduct(keyword);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/showAll.jsp").forward(request,response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
