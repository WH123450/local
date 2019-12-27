package com.servlet;

import com.domain.Product;
import com.mysql.jdbc.StringUtils;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 王会
 */
@WebServlet(name = "UpdateProductServlet",value = "/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    public static boolean isNumeric(String str){
        Pattern pattern=Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,IllegalArgumentException  {
        request.setCharacterEncoding("utf-8");


            Integer id=Integer.parseInt(request.getParameter("id"));
            Double chinese=Double.parseDouble(request.getParameter("chinese"));
            Double math=Double.parseDouble(request.getParameter("math"));
            Double english=Double.parseDouble(request.getParameter("english"));


        try{
        if((chinese<0||chinese>100))
        {
            throw new IllegalArgumentException("成绩必须为大于0小于100的数字");
        }
        if(math<0||math>100)
        {
            throw new IllegalArgumentException("成绩必须为大于0小于100的数字");
        }
        if(english<0||english>100)
        {
            throw new IllegalArgumentException("成绩必须为大于0小于100的数字");
        }
        if((isNumeric(request.getParameter("chinese")))) {
            throw new IllegalArgumentException("成绩输入不合法");
        }
            if((isNumeric(request.getParameter("math")))){
                throw new IllegalArgumentException("成绩输入不合法");
            }
                if((isNumeric(request.getParameter("english")))){
                    throw new IllegalArgumentException("成绩输入不合法");
                }
        }catch (IllegalArgumentException e)
        {
            System.out.println("错误类型"+e.toString());
        }


        Product product=new Product();
        product.setId(id);
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
