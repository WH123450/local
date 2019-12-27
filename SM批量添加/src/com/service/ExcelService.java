package com.service;

import java.io.InputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * @Author : qipin
 * @DATE : 2019/12/24 0024 9:29
 */
public interface ExcelService {
    List getDataListByExcel(InputStream in, String fileName) throws Exception;

    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception;
}
