package api.utilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	public static String getCellData(String filePath, String sheetName,
            int rowNum, int colNum) {

String data = "";

try {
FileInputStream fis = new FileInputStream(filePath);
XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet sheet = workbook.getSheet(sheetName);

Cell cell = sheet.getRow(rowNum).getCell(colNum);

DataFormatter formatter = new DataFormatter();
data = formatter.formatCellValue(cell);

workbook.close();
fis.close();

} catch (IOException e) {
e.printStackTrace();
}

return data;
}

public static int getRowCount(String filePath, String sheetName) {

int rows = 0;

try {
FileInputStream fis = new FileInputStream(filePath);
XSSFWorkbook workbook = new XSSFWorkbook(fis);

XSSFSheet sheet = workbook.getSheet(sheetName);
rows = sheet.getLastRowNum();

workbook.close();
fis.close();

} catch (IOException e) {
e.printStackTrace();
}

return rows;
}

public static int getCellCount(String filePath, String sheetName, int rowNum) {

int cells = 0;

try {
FileInputStream fis = new FileInputStream(filePath);
XSSFWorkbook workbook = new XSSFWorkbook(fis);

XSSFSheet sheet = workbook.getSheet(sheetName);
cells = sheet.getRow(rowNum).getLastCellNum();

workbook.close();
fis.close();

} catch (IOException e) {
e.printStackTrace();
}

return cells;
}


}
