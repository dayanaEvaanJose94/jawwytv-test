package com.JawwyTV.testScripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.JawwyTV.automationCore.Base;
import com.JawwyTV.dataProvider.DataProviders;
import com.JawwyTV.pages.Homepage;
import com.JawwyTV.utilities.ExcelUtility;



public class HomePageTest extends Base{
	
	Homepage home;
	ExcelUtility excel;
	@Test(dataProvider = "multipleCountries",dataProviderClass = DataProviders.class,priority = 1,enabled = true,groups = {"regression"})
	public void TC_001_ValidateTheSubscriptionPackages(String country) {
		excel=new ExcelUtility();
		List<ArrayList<String>> expectedData=excel.getExcelAs2DList(country);
		System.out.println("expected data="+country+""+expectedData);
		home=new Homepage(driver);
		home.clickOnEnglish();
		home.clickOnCountry();
		home.selectCountry(country);
		List<ArrayList<String>> actualData=home.getplans();
		System.out.println("actual data="+country+""+actualData);
		Assert.assertEquals(actualData, expectedData,"invalid data for country"+country);
		
	}
	
}
