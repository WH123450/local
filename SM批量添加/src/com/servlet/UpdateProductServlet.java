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
@WebServlet(name = "UpdateProductServlet",value = "/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer id=Integer.parseInt(request.getParameter("id"));
        Double chinese=Double.parseDouble(request.getParameter("chinese"));
        Double math=Double.parseDouble(request.getParameter("math"));
        Double english=Double.parseDouble(request.getParameter("english"));
        Product product=new Product();

        product.setId(id);
        //System.out.println(id);
        product.setChinese(chinese);
        product.setMath(math);
        product.setEnglish(english);

        ProductService productService=new ProductServiceImpl();
        int result=productService.updateProduct(product);
        if(result>0){
            request.getRequestDispatcher("/ShowAllServlet").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/fail.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
