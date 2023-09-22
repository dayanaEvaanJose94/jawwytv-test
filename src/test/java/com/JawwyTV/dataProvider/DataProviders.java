package com.JawwyTV.dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.JawwyTV.utilities.ExcelUtility;

public class DataProviders {
	
	@DataProvider(name="multipleCountries")
	    public Object[][] CountiesData() throws IOException {
	        ExcelUtility excelUtility=new ExcelUtility();
	        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
	        Object[][] excelData=excelUtility.readDataFromExcel(filepath,"country");
	        return excelData;
	    }
}
