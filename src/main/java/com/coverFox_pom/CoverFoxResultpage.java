package com.coverFox_pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultpage {
//  matching Health Insurance Plans
	
	@FindBy(xpath = "//div[contains(text(),'matching ')]")private WebElement planeResult;
	//@FindBys({@FindBy(className = "plan-card-container")})private ;
	
	@FindBy(className = "plan-card-container")private List <WebElement> planscard;
	
	//@FindBy(xpath = "//div[@id=\"plans-list\")]")private  List <WebElement> planscard;
	
	// construction 
	
	public CoverFoxResultpage(WebDriver driver) {
		
		PageFactory.initElements( driver,this);
	}
	
	public void validateplans() throws InterruptedException {
		String result = planeResult.getText();
		
	String[] result1 = result.split("  ");
		//48 matching Health Insurance Plans	
	int resultInNumber = Integer.parseInt(result1[0]);		
	Thread.sleep(8000);
	int totalplans = planscard.size();
		if(totalplans==resultInNumber) {			
			System.out.println("tc case pass");
		}

	else {
		System.out.println("tc case fail");
		}
	}
	
public int getPlanesNumberFromText() throws InterruptedException {
	
	Reporter.log("Getting planes number from text", true);
	
	String result = planeResult.getText();
	       
	String[] result1 = result.split(" ");
	
	//48 matching Health Insurance Plans
	Thread.sleep(5000);
	int planesNumber = Integer.parseInt(result1[0]);
	Thread.sleep(3000);
	return planesNumber;
	
	
}
   public int getplanesNumberFromplanescard() throws InterruptedException {
	Reporter.log("Getting planes number from cards", true);
      int planNumberFromcards = planscard.size();

	return planNumberFromcards;
}
}
