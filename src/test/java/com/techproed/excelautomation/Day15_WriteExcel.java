package com.techproed.excelautomation;

import com.techproed.utilities.ExcelUtil;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Day15_WriteExcel {

    @Test
    public void writeExcel() throws IOException {

        //Create a new class: WriteExcel
        //Create a new method: writeExcel()
        //Store the path of the file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";
        //Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);

        //accessing the workbook
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0);

        //Go to the first row
        Row firstRow = sheet.getRow(0);

        //Create a cell on the 2nd index or 3rd column on the first row
        //go to first row 2nd index
        //create a cell on 2nd column
        Cell row1Cell3 =  firstRow.createCell(2);

        //Write “POPULATION” on that cell
        row1Cell3.setCellValue("POPULATION");


        //Create a cell on the 2nd row 3th cell(index3), and write 150000
       sheet.getRow(1).createCell(2).setCellValue(15000);;


        //Create a cell on the 3rd row 3th cell(index3), and write 250000
      sheet.getRow(2).createCell(2).setCellValue(250000);


        //Create a cell on the 4th row 3th cell(index3), and write 54000
        Cell row4Cell4 = sheet.getRow(3).createCell(2);
        row4Cell4.setCellValue(54000);


        //Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Close the file
        fileInputStream.close();
        fileOutputStream.close();

        //Close the workbook
        workbook.close();

    }

}
