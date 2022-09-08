package com.eplusing.demo1200.base.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {
    public static void main(String[] args) throws IOException {
        writeExcel();
    }
    public static void writeExcel() throws IOException {
        // 创建Excel文件
        File excelFile = new File("target.xlsx");
        // 创建Excel工作薄
        Workbook workbook = new XSSFWorkbook();
        // 创建Excel表单
        Sheet sheet = workbook.createSheet();

        //设置列宽，宽度为256的整数倍
        sheet.setColumnWidth(0, 3200);
        sheet.setColumnWidth(1, 3200);
        sheet.setColumnWidth(2, 3200);

        //创建表头行
        Row row = sheet.createRow(0);
        Cell cell;
        cell = row.createCell(0, CellType.STRING);
        cell.setCellStyle(getCellStyle(workbook));
        cell.setCellValue("userName");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellStyle(getCellStyle(workbook));
        cell.setCellValue("userId");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellStyle(getCellStyle(workbook));
        cell.setCellValue("age");

        //创建表体行
        for (int i = 0; i < 10; i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("王小二" + i);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("100" + i);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(10 + i);
        }

        FileOutputStream os = null;
        try {
            //把Excel工作薄写入到Excel文件
            os = new FileOutputStream(excelFile);
            workbook.write(os);
            os.flush();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
            } finally {
                if (null != os) {
                    os.close();
                }
            }
        }
    }

    public static CellStyle getCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(Boolean.TRUE);
        cellStyle.setFont(font);
        return cellStyle;
    }
}
