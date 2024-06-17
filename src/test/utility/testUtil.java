package test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;


public class testUtil {
static Xls_Reader reader;


	public static  ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("C:/Users/abhin/eclipse-workspace/EbayTesting/src/com/testData/dataSheet.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowcount= 2; rowcount<=reader.getRowCount("Sheet1");rowcount++) {
			String businessName =reader.getCellData("Sheet1", "businessName", rowcount);
			String businessEmail  =reader.getCellData("Sheet1", "businessEmail", rowcount);
			String bizPassword = reader.getCellData("Sheet1", "password", rowcount);
			String Country =reader.getCellData("Sheet1", "country", rowcount); 
			
			Object obj[]= {businessName,businessEmail,bizPassword,Country};
			mydata.add(obj);
			
		}
		return mydata;
	}
}