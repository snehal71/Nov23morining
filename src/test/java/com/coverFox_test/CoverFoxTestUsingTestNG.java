package com.coverFox_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.coverFox_Base.Base;
import com.coverFox_pom.CoverFoxAddressdetailspages;
import com.coverFox_pom.CoverFoxHealthPages;
import com.coverFox_pom.CoverFoxHomePages;
import com.coverFox_pom.CoverFoxMemberDetailspages;
import com.coverFox_pom.CoverFoxResultpage;
import com.coverfox_utility.Utility;



//@Listeners(coverFoxPOMBaseTestUtility.Listnener.class)


public class CoverFoxTestUsingTestNG extends Base {
	
	public static Logger logger;
	// object Creation in pom class 
	
	CoverFoxHomePages coverFoxHomePages;
	CoverFoxMemberDetailspages coverFoxMemberDetailspages;
	CoverFoxAddressdetailspages coverFoxAddressdetailspages;
	CoverFoxHealthPages coverFoxHealthPages;
	CoverFoxResultpage coverFoxResultpage;
	
	
	@BeforeClass
	  public void launchBrowser() throws EncryptedDocumentException, IOException {
		
		 
		logger= Logger.getLogger("23NOV24_coverFOX");
		  PropertyConfigurator.configure("log4j.properties");
		  logger.info("Welcome to coverFox Testing");

		
		
		  // object inilazation ;
		openBrowser();
		logger.warn("Launching Browser");
		 coverFoxHomePages =new CoverFoxHomePages(driver);
		 logger.info("getLogger");
		 coverFoxMemberDetailspages =new CoverFoxMemberDetailspages(driver);
		 coverFoxAddressdetailspages =new CoverFoxAddressdetailspages(driver);
		 coverFoxHealthPages =new CoverFoxHealthPages(driver);
		 coverFoxResultpage= new CoverFoxResultpage(driver);
		 
	}
		 
		 
	
	@BeforeMethod
	
  public void coverFoxPreCondtions() throws InterruptedException, EncryptedDocumentException, IOException {
		coverFoxHomePages.clickongender();
		logger.info("clickongender");
		coverFoxHealthPages.clickonNextButtonHealthPages();
		logger.info("clickonNextButtonHealthPages");
		coverFoxMemberDetailspages.handleAgeDropDown(Utility.readDataFromExcel("sheet2", 1, 0));
		logger.info("handleAgeDropDown");
		coverFoxMemberDetailspages.clickonextButtonofmembersdetailspages();
		logger.info("clickonextButtonofmembersdetailspages");
		coverFoxAddressdetailspages.enterpincode(Utility.readDataFromExcel("sheet2", 1, 1));
		logger.info("enterpincode");
		coverFoxAddressdetailspages.entermobilenumber(Utility.readDataFromExcel("sheet2", 1, 2));
		logger.info("entermobilenumber");
		coverFoxAddressdetailspages.clickoncontinuebutton();
		logger.info("clickoncontinuebutton");
		Thread.sleep(4000);
		
	}
	
	
 @Test
  public void validatecoverFoxPlanes() throws InterruptedException, IOException {
	  int planNumerText = coverFoxResultpage.getPlanesNumberFromText();
	  
	  int planNumberCards = coverFoxResultpage.getplanesNumberFromplanescard();
	  logger.info("validate coverFoxPlanes");
	  Assert.assertEquals(planNumerText, planNumberCards,"Tc is failed");
	 
	  Reporter.log("plane number are match Tc is pass", true);
	  
	 Utility.takeScreenShot(driver, "validatecoverFoxPlanes");
  }
 
 @AfterClass
 
 public void BrowserClose() throws InterruptedException {
	 Reporter.log("close Browser", true);
	 logger.info("Browser Close");
	 closeBroserwindow();
 }
}
