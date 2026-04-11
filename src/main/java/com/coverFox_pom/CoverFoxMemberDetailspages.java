package com.coverFox_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailspages {

	// variables 
	// constructor
	// method 
	
	// variables 
	
	@FindBy(name ="You" )private WebElement aegDropDown;
	@FindBy(className ="next-btn" )private WebElement nextButton;
	
	
	// constructor
	
	public CoverFoxMemberDetailspages(WebDriver driver) {
		PageFactory.initElements( driver, this);
		
		
	}
	
	public void handleAgeDropDown(String age) {
		Reporter.log("handle Age drop dwon ", true );
		Select selectAge=new Select(aegDropDown);
		selectAge.selectByValue(age+ "y");
	}
	
	public void clickonextButtonofmembersdetailspages() {
		Reporter.log("clilk on the next Button of members details pages", true );
		nextButton.click();
	}
	
}
