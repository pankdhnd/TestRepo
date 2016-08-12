package projectUtility;

public class dataForTesting {
    private static excelDriver oExcelDriver = new excelDriver();

	public dataForTesting()
	{
    	oExcelDriver.openExcelSheet("D:\\selenium\\Framework\\InputData\\InputTestData.xlsx");

	}
	
	public String[] getLoginDetails(){
		String excelSheetName = "Login";
		String[] loginData = new String[2];  	
		loginData[0] = oExcelDriver.getCellData(excelSheetName, 1, 2);
    	loginData[1] = oExcelDriver.getCellData(excelSheetName, 2, 2);  	
    	return loginData;			
				
	}
}
