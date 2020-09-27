package com.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;




public class Hooks {
	
	@After
	public void endConnection(Scenario sc) {
		
		if(sc.isFailed())
		{
			TakesScreenshot t = (TakesScreenshot)DigitalBankSteps.driver;
			byte[] screenshotAs = t.getScreenshotAs(OutputType.BYTES);
			sc.embed(screenshotAs, "Failure/png");
		}
		else {
			TakesScreenshot t = (TakesScreenshot)DigitalBankSteps.driver;
			byte[] screenshotAs = t.getScreenshotAs(OutputType.BYTES);
			sc.embed(screenshotAs, "Pass/png");
		}
		DigitalBankSteps.driver.quit();
	}

}
