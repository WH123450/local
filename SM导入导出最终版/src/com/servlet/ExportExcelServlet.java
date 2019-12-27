package com.servlet;

import com.domain.Product;
import com.service.impl.ProductServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.RichTextString;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExportExcelServlet",value = "/ExportExcelServle")
public class ExportExcelServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel");//响应正文的MIME类型，表示Excel
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> list = new ArrayList<Product>();
        list = productService.showAll();
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("成绩表一");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("语文");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("数学");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("英语");
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue("班级");
        cell.setCellStyle(style);

		/*// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List list = CreateSimpleExcelToDisk.getStudent();*/
        ServletOutputStream out = response.getOutputStream();//响应输出流对象
        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            Product stu = (Product) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(stu.getId());//订单编号
            row.createCell(1).setCellValue(stu.getName());//商品名称
            row.createCell(2).setCellValue(stu.getChinese());//客户姓名
            row.createCell(3).setCellValue(stu.getMath());//联系电话
            row.createCell(4).setCellValue(stu.getEnglish());//付款否
            row.createCell(5).setCellValue(stu.getClasses());//订单状态
        }
        // 第六步，将文件存到指定位置
        try
        {
            wb.write(out);                              //将响应流输入到Excel表格中
            response.addHeader("Content-Disposition", "attachment;filename=demo.xls");//文件临时保存在demo.xls中
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
