package ExcelUtility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DProvider {
DataFormatter df= new DataFormatter();

        public void testCaseData(String shareName,String searchName)
        {

        }

        @DataProvider(name = "stockNames")

        public Object[][] getData() throws IOException {
            FileInputStream fis = new FileInputStream("C:\\Automation\\PrabhuStockScreens\\Stocks.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int rowCount=sheet.getPhysicalNumberOfRows();
            XSSFRow rw= sheet.getRow(0);
            int colCount= rw.getLastCellNum();
            Object data[][]=new Object[rowCount-1][colCount];

            for (int i=0;i<rowCount-1;i++)
            {
                rw=sheet.getRow(i+1);
                for (int j=0;j<colCount;j++) {
                    XSSFCell cell= rw.getCell(j);
                    data[i][j]=df.formatCellValue(cell);

                }
            }
        return data;

        }

    }


