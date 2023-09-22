package com.JawwyTV.automationCore;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class Base {
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true )
	@Parameters({"browser","url"})
	public void setUP(String browserName,String urls) {
	//public void setUP(){
        driver = DriverFactory.testInitialization(browserName);
        driver.get(urls);
	}
	@AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus()== ITestResult.FAILURE){
            TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
            File screenshot=takeScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("./Screenshots/"+result.getName()+".png"));
        }
        driver.quit();
    }
}
	
