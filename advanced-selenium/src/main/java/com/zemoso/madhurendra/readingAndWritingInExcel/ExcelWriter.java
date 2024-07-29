package com.zemoso.madhurendra.readingAndWritingInExcel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {

    public static void main(String[] args) {
        String excelFilePath = "/home/madhurendra.tiwari/Downloads/LeetCode Learnings - Interns.xlsx";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet2");
        // Sheet sheet = workbook.getSheetAt(0);

        // Create a row and put some cells in it.
        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("Hello 1");

        Cell cell2 = row.createCell(1);
        cell2.setCellValue("World 1");

        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream(excelFilePath);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

