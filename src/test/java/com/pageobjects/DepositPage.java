package com.pageobjects;



import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.stepdefinitions.DigitalBankSteps;

public class DepositPage {

	public DepositPage() {
		PageFactory.initElements(DigitalBankSteps.driver, this);
	}

	@FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/a")
	private WebElement transfersPage;

	@FindBy(linkText = "Deposit")
	private WebElement depositPage;

	@FindBy(id = "id")
	private WebElement depositAccount;

	@FindBy(id = "amount")
	private WebElement depositAmount;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='right-panel']/div[2]/div/div/div/div/div/strong")
	private WebElement transfersVP;
	
	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[1]/td[5]")
	private WebElement finalBalance;

	public void initiateDeposit(String text) {
		transfersPage.click();
		depositPage.click();
		Assert.assertTrue("Deposit Page Assertion",
				transfersVP.getText().equals(text));

	}
	
	public void performDeposit(String depoAccount, String depoAmount) {
		Select account = new Select(depositAccount);
		account.selectByValue(depoAccount.split("-")[1]);
		depositAmount.sendKeys(depoAmount);
		submitButton.click();

	}
	public void checkBalanceAfterDeposit() {
		System.out.println("Banalance After Deposit : "+finalBalance.getText());

	}


}
