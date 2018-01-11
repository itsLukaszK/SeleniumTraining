package test_data;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestDataFromExcel {
    public static String[][] getDataFromExcel(String xlsxFilePath, String sheetName) throws IOException {
        File file = new File(xlsxFilePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        String[][] usernameAndPasswordTable = new String[sheet.getLastRowNum() + 1][2];
        for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                usernameAndPasswordTable[i][j] = row.getCell(j).getStringCellValue();
            }
        }
        return usernameAndPasswordTable;
    }
}
