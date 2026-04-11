package com.coverFox_listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.coverFox_Base.Base;
import com.coverfox_utility.Utility;

public class Listnener extends Base  implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult result) {

   Reporter.log("Test "+result.getName() +"is sucesss", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		 Reporter.log("Test "+result.getName() +"is failed", true);
		try {
			Utility.takeScreenShot(driver,result.getName()+ "_failedTesTCase");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
