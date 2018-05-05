package excelread;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import testbase.TestBase;

public class Excelread extends TestBase {

	public static String path = "..///CurioSample//src//main//java//testdata/Curiotest1.xls";
	public static String Sheet = "Login";
	public static String Sheet1 = "SearchFlight1";
	public static org.apache.poi.ss.usermodel.Cell c;

	public static org.apache.poi.ss.usermodel.Sheet sh;

	public static Object[][] getdata(String path, String Sheet) throws Exception {

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(Sheet);
		String[][] readdata = null;

		int row = sh.getLastRowNum();
		Row r = sh.getRow(0);

		int column = r.getLastCellNum();
		int ci, cj;
		readdata = new String[row][column];
		ci = 0;
		for (int i = 1; i <= row; i++, ci++) {
			cj = 0;
			for (int j = 0; j < column; j++, cj++) {

				readdata[ci][cj] = getCellData(i, j);

			//	System.out.println(c);
			}
		}
		return readdata;
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			c = sh.getRow(RowNum).getCell(ColNum);

			if (c == null || c.getCellType() == c.CELL_TYPE_BLANK) {
				return "";
				// This cell is empty
			} else {

				String CellData = c.getStringCellValue();

				return CellData;

			}
		} catch (Exception e) {

			//System.out.println(e.getMessage());

			throw (e);

		}

	}

}
