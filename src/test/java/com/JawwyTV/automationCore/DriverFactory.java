package com.JawwyTV.automationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public static WebDriver testInitialization(String browser){
	    if(browser.equals("chrome")){
	    	 WebDriverManager.chromedriver().setup();
	        tlDriver.set(new ChromeDriver());
	    }else if(browser.equals("FireFox")){
	    	WebDriverManager.firefoxdriver().setup();
	        tlDriver.set(new FirefoxDriver());
	    }else if(browser.equals("edge")){
	    	 WebDriverManager.edgedriver().setup();
	        tlDriver.set(new EdgeDriver());
	    }else{
	        throw new RuntimeException("Invalid browser");
	    }
	    getDriver().manage().deleteAllCookies();
	    getDriver().manage().window().maximize();
	    return getDriver();
	}
	public static synchronized WebDriver getDriver() {
	    return tlDriver.get();
	}
	
}
