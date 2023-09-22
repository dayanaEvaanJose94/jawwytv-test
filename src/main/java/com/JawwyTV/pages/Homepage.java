package com.JawwyTV.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="translation-btn")
	WebElement language;
	@FindBy(id = "country")
	WebElement country;
	@FindBy(xpath = "//div[@id='country-selct']//a")
	List<WebElement> countries;
	@FindBy(xpath = "//div[@class='plan-names']//strong")
	List<WebElement> plans;
	@FindBy(id="currency-lite")
	WebElement lite;
	@FindBy(id="currency-classic")
	WebElement classic;
	@FindBy(id="currency-premium")
	WebElement premium;
	public void clickOnEnglish() {
		language.click();
	}
	public void clickOnCountry() {
		
		country.click();
	}
	public void selectCountry(String countryName) {
		for(int i=0;i<countries.size();i++) {
			String CName=countries.get(i).getText();
			if(countryName.equalsIgnoreCase(CName)) {
				countries.get(i).click();
				
			}
		}
	}
	public List<ArrayList<String>> getplans() {
		List<ArrayList<String>> data= new ArrayList<ArrayList<String>>();
		String values[]=new String[2];
		for(int i=0;i<plans.size();i++) {
			if(plans.get(i).getText().equalsIgnoreCase("Lite")) {
				values[0]=plans.get(i).getText();
				values[1]=lite.getText();
			}
			else if(plans.get(i).getText().equalsIgnoreCase("premium")) {
				values[0]=plans.get(i).getText();
				values[1]=premium.getText();
			}
			else if (plans.get(i).getText().equalsIgnoreCase("classic")) {
				values[0]=plans.get(i).getText();
				values[1]=classic.getText();
			}
			data.add(new ArrayList<String>(Arrays.asList(values)));
		}
		return data;
		
	}
}
