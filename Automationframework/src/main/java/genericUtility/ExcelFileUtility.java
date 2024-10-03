package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 * 
	 * 
	 */
public String toReadDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\Testdat5.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String value=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
	
	
	return value;
}

}
