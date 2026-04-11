package com.coverFox_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePages {
	// variables......> webElement
	
	
	@FindBy(xpath = "//div[text()=\"Male\"]") private WebElement gender;
	
	// constructor 
	
	public CoverFoxHomePages(WebDriver driver) {
		
		PageFactory.initElements( driver,this);
	}
	 public void clickongender() {
		 Reporter.log("click on Gender", true);
		 gender.click();
	 }

}
