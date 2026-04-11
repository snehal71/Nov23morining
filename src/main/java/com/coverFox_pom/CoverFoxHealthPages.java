package com.coverFox_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPages {
    
	// variables
	// constructor
	// method 
	
	
	// variables
	@FindBy(className="next-btn")private WebElement nextbutton;
	
	// // constructor
	public CoverFoxHealthPages(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	// method 
	
	public void clickonNextButtonHealthPages(){
		Reporter.log("click on Next Button of health plane pages ", true);
		nextbutton.click();
	}
}
