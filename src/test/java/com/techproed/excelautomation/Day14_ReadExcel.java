package com.techproed.excelautomation;

import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14_ReadExcel {


    @Test
    public void readExcel() throws IOException {
        String path = "./src/test/java/resources/Capitals.xlsx";

        //Open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //Open the workbook using fileInputStream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0); // index of sheet starts at 0

        //Go to first row
        Row firstRow = sheet.getRow(0); //index of row starts at 0

        //Go to first cell on that first row and print
        Cell firstCell = firstRow.getCell(0); //

        System.out.println(firstCell);

        Cell row1Cell2 = sheet.getRow(0).getCell(1);
        System.out.println(row1Cell2);

        //Go to 2nd row first cell and assert if the data equal to USA
        Cell row2cell1 = sheet.getRow(1).getCell(0); //row2cell1 is cell, so we have to convert it to String
        boolean isEqual = row2cell1.toString().equals("USA");
        System.out.println(row2cell1);
        Assert.assertTrue(isEqual);


        //Go to 3rd row 2nd cell-chain the raw and cell
        Cell row3Cell2=sheet.getRow(2).getCell(1);
        System.out.println(row3Cell2);

        //Find the number of row
        int lastRowNumber = sheet.getLastRowNum()+1; //index starts at 0;
        System.out.println("Total number of rows : "+lastRowNumber);

        //Find the number used rows
        int usedNumberofRow = sheet.getPhysicalNumberOfRows();
        System.out.println(usedNumberofRow); // index start at 1


        //Print country, capital key value pairs as map object
        Map<String, String> worldCapitals = new HashMap<>();
        int countryColumn = 0;
        int capitalColumn = 1;

        /* Starting row number  : 1- cause row is Header
        * Ending Row Number     : lastRowNumber - sheet.getLastRowNumber()+1;
        * USA       sheet.getRow(1).getCell(0);
        * France    sheet.getRow(2).getCell(0);
        * England   sheet.getRow(3).getCell(0);
        *
        * D.C       sheet.getRow(1).getCell(1);
        * Paris     sheet.getRow(2).getCell(2);
        * London    sheet.getRow(3).getCell(3);
        * */

        for(int rowNumber = 1; rowNumber<lastRowNumber; rowNumber++){
            String countries = sheet.getRow(rowNumber).getCell(countryColumn).toString();
            String capitals = sheet.getRow(rowNumber).getCell(capitalColumn).toString();
            worldCapitals.put(countries,capitals);
            System.out.println("COUNTRIES : " + countries);
            System.out.println("CAPITALS : " + capitals);

        }

        System.out.println(worldCapitals);

    }
        @Test
        public void excelUtilDemo() {
            //Using some of the ExcelUtil methods
            //We use Util classes to do faster and accurate automatation script

            String path = "./src/test/java/resources/Capitals.xlsx";
            String sheetName = "capitals_sheet";
            ExcelUtil excelUtil = new ExcelUtil(path, sheetName);
            System.out.println("TOTAL COLUMN : " + excelUtil.columnCount());

            //getDataList()
            System.out.println(excelUtil.getDataList());

            //Find the number of column in Capitals
            System.out.println(excelUtil.columnCount()); //2

            //Find the number of row in Capitals sheet
            System.out.println(excelUtil.rowCount()); //11

            //find  the data in row 9,1
            System.out.println(excelUtil.getCellData(9,1));

            //find name of columns
            System.out.println(excelUtil.getColumnsNames());

        }



}
