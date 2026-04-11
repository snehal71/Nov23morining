package com.coverFox_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressdetailspages {
	
	//variables
	
	@FindBy(className = "mp-input-text") private WebElement pincodefiled;
	@FindBy(id = "want-expert")private WebElement moblienumberfild;
	@FindBy(xpath = "//div[text()=\"Continue\"]")private  WebElement continueButton;
	
	// constructor 
	
	public CoverFoxAddressdetailspages( WebDriver driver ) {
	 PageFactory.initElements( driver,this);	   
	}
	
	// method 
	
	public void enterpincode(String pincode ) {
		Reporter.log("Enter Pincode ", true);
		
		pincodefiled.sendKeys(pincode);
	}
	
	public void entermobilenumber(String mobnumber  ) {
		
		Reporter.log("Enter MobNumber ", true);
		moblienumberfild.sendKeys(mobnumber);
	}
	public void clickoncontinuebutton() {
		Reporter.log("click on next contineous button ", true);
		continueButton.click();
	}

}
