package com.coverfox_utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
// make static method
	// read data from excel 
	// screenShot method
	// Scrolling view 
	
	public static String readDataFromExcel(String SheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		
	    FileInputStream myfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\New Microsoft Excel Worksheet.xlsx");
		// FileInputStream myfile=new FileInputStream("C:\\Users\\ingal\\OneDrive\\Desktop\\New Microsoft Excel Worksheet.xlsx");
		//"C:\Users\ingal\OneDrive\Desktop\New Microsoft Excel Worksheet.xlsx"
		
		Reporter.log("Reading data From Excel Files", true);
		 Sheet mySheet = WorkbookFactory.create(myfile).getSheet(SheetName);
		 String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		 Reporter.log("reading data From excel ", true);
		 return data;
	}
	
	// screenShot method
public static  void takeScreenShot(WebDriver driver,String screenshotName ) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	File  dest = new File(System.getProperty("user.dir")+"\\screenshot"+screenshotName+".png");
	FileHandler.copy(src, dest);
	Reporter.log("taking screenshot save at"+ dest , true);
	
	}

   //Scrolling view 

public  static void ScrollintoView(WebDriver driver,WebElement element) {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	
	Reporter.log(" Scroll into  iew into the pages", true);
}
// properties file read credentials details

public static String readDataFromPropertiesFile(String key) throws IOException {
	Properties prop =new Properties();
	// C:\Users\ingal\eclipse-workspace\Nov24Morning25Seleninum\coverFox.properties
	FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\coverFox.properties");
	prop.load(myfile);
	String value = prop.getProperty(key);
	Reporter.log("Reading data From properties Files", true);
	return value;
	
}

public void implicitlyWait(WebDriver driver , int timeInmilisec) {
	Reporter.log("Waiting for "+timeInmilisec, true);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeInmilisec));
	
	
}

}
