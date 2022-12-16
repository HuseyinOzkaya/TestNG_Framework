package com.techproed.utilities;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {


    private final static String EXCEL_FILE_NAME = "Test_Excel_File.xlsx";
    private final static String BASE_FILE_PATH = "src/test/resources/data/";
    private final static String SHEET = "Sheet1";

    /**
     * Read a specific cell for getting path of the file
     *
     * @throws IOException
     */
    @Test
    public void test() {
        File file = new File(BASE_FILE_PATH + EXCEL_FILE_NAME);
        String filePath = file.getAbsolutePath();
        System.err.println(filePath);
        ExcelUtil excelUtil = new ExcelUtil(filePath, SHEET);

        // Read specific excel cell
        String readCell = excelUtil.getCellData(0, 1);
        System.err.println(readCell);

        // get pathname of the file which is identified in excel sheet.
        File processFile = new File(BASE_FILE_PATH + readCell);

        // Read all txt files.
        try {
            FileInputStream inputStream = new FileInputStream(processFile);
            String allText = IOUtils.toString(inputStream);
            inputStream.close();
            System.err.println(allText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2(){
        File file = new File(BASE_FILE_PATH + EXCEL_FILE_NAME);
        String filePath = file.getAbsolutePath();
        System.err.println(filePath);
        ExcelUtil excelUtil = new ExcelUtil(filePath, SHEET);
        System.err.println(excelUtil.getEachDataMap());
    }

}



