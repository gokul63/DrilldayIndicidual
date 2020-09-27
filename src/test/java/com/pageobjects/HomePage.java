package com.pageobjects;



import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepdefinitions.DigitalBankSteps;

public class HomePage {

	public HomePage() {

		PageFactory.initElements(DigitalBankSteps.driver, this);
	}

	@FindBy(linkText = "Transfer")
	private WebElement transferOption;

	@FindBy(linkText = "Between Accounts")
	private WebElement betweenAccountOption;

	@FindBy(linkText = "Savings")
	private WebElement savingsOption;

	@FindBy(linkText = "View Savings")
	private WebElement viewSavingsOption;

	@FindBy(xpath = "//div[text()='gok']")
	private WebElement textUserName;

	@FindBy(xpath = "//div[contains(text(),'Balance')]")
	private WebElement userBalance;

	@FindBy(linkText = "Logout")
	private WebElement userLogout;

	@FindBy(xpath = "//li[contains(text(),'Welcome')]")
	private WebElement WelcomeText;
	


	public void homePageAssertVerify(String text) {
		Assert.assertTrue("Home Page Assert", WelcomeText.getText().contains(text));
	}

	public void checkBalanceBeforeTransfer() {
		savingsOption.click();
		viewSavingsOption.click();
		System.out.println("Account Holder Name :" + textUserName.getText());
		System.out.println("Account Before Fund Transfer " + userBalance.getText());
		transferOption.click();
		betweenAccountOption.click();
	}

	
}
