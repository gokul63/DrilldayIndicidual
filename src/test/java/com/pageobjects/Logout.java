package com.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepdefinitions.DigitalBankSteps;

public class Logout {

	public Logout() {

		PageFactory.initElements(DigitalBankSteps.driver, this);
	}

	@FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
	private WebElement initiateLogout;

	@FindBy(xpath = "//*[@id=\'header\']/div/div[2]/div[1]/div/a[3]")
	private WebElement logoutClick;

	@FindBy(xpath = "//span[@class='badge badge-pill badge-success']")
	private WebElement logoutVP;

	public void performLogOut() {

		initiateLogout.click();
		logoutClick.click();
	}
	
	public void logOutPageAssertVerify(String text) {
		Assert.assertTrue("Logout Assert:",
				logoutVP.getText().equalsIgnoreCase(text));

	}
}
