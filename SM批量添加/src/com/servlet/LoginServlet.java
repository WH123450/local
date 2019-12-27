package com.servlet;

import com.domain.Student;
import com.domain.User;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = ("/LoginServlet"))
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String id=request.getParameter("id");
        if (id.equals("teacher")==true)//老师
        {
            User user = new User(username,userpassword);
            //user.setUsername(username);
            //user.setPassword(userpassword);
            ProductService productService=new ProductServiceImpl();

            Boolean i= productService.findProduct1(username, userpassword);
            if(i){
                response.sendRedirect("/ShowAllServlet");
            }
            else{
                response.sendRedirect("fail.jsp");
            }
        }
        else//学生
        {
            Student stu = new Student(username,userpassword);
            //user.setUsername(username);
            //user.setPassword(userpassword);
            ProductService productService=new ProductServiceImpl();
            Boolean j= productService.findProduct2(username, userpassword);
            if(j){
                response.sendRedirect("squery.jsp");
            }
            else{
                response.sendRedirect("fail.jsp");
            }
        }


        /*User user = new User(username,userpassword);

        ProductService productService=new ProductServiceImpl();

        Boolean i= productService.findProduct1(username, userpassword);
        if(i){
           response.sendRedirect("/ShowAllServlet");
        }
        else{
            response.sendRedirect("fail.jsp");
        }


         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
