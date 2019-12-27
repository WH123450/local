package com.servlet;

import com.domain.Product;
import com.service.impl.ProductServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

/**
 * @Author : 王会
 * @DATE : 2019/12/24 0024 10:29
 */
@WebServlet(name = "fileServlet", value = "/uploadFile")
public class fileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        byte[] junk = new byte[1024];
        int bytesRead = 0;

        ServletInputStream is = req.getInputStream();

        // shou首先除去Http Head
        bytesRead = is.readLine(junk, 0, junk.length);
        bytesRead = is.readLine(junk, 0, junk.length);
        bytesRead = is.readLine(junk, 0, junk.length);
        bytesRead = is.readLine(junk, 0, junk.length);

        HSSFWorkbook wb = new HSSFWorkbook(is);//用于操作Excel的组件，Excel的文档对象
        HSSFSheet sheet = wb.getSheetAt(0);//Excel的表单，用sheet返回行对象，用行对象得到cell对象
        ProductServiceImpl productService = new ProductServiceImpl();
        for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {

            //创建一个行对象
            HSSFRow row = sheet.getRow(j);
            //把一行里的每一个字段遍历出来
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < row.getLastCellNum(); i++) {
                //创建一个行里的一个字段的对象，也就是获取到的一个单元格中的值
                HSSFCell cell = row.getCell(i);
                if (cell.getCellType() == CELL_TYPE_NUMERIC) {
                    dataList.add((int) cell.getNumericCellValue() + "");
                }
                if (cell.getCellType() == CELL_TYPE_STRING) {
                    dataList.add(cell.getStringCellValue());
                }
            }
            Product product = new Product();
            product.setId(Integer.parseInt(dataList.get(0) + ""));
            product.setName(dataList.get(1) + "");
            product.setChinese(Float.parseFloat(dataList.get(2) + ""));
            product.setMath(Float.parseFloat(dataList.get(3) + ""));
            product.setEnglish(Float.parseFloat(dataList.get(4) + ""));
            product.setClasses(dataList.get(5) + "");
            productService.addProduct(product);
        }
        req.getRequestDispatcher("/ShowAllServlet").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
