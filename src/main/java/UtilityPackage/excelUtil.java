package UtilityPackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtil {

	public static String data(String sheet ,int row ,int cell) throws Exception {
		
		FileInputStream fil=new FileInputStream("./src/test/resources/resources/OrangeHRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fil);
		String dataname = workbook.getSheet(sheet).getRow(row).getCell(cell).toString();
		return dataname;
	}
}
