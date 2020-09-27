package com.pageobjects;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.stepdefinitions.DigitalBankSteps;

public class FundTransferPage {

	public FundTransferPage() {

		PageFactory.initElements(DigitalBankSteps.driver, this);
	}

	@FindBy(id = "fromAccount")
	private WebElement senderAccount;

	@FindBy(id = "toAccount")
	private WebElement receiverAccount;

	@FindBy(id = "amount")
	private WebElement amountTransfer;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//strong[@class='card-title text-white']")
	private WebElement headingText;
	
	@FindBy(xpath = "//span[@class='switch-handle']")
	private WebElement handleButton;
	
	@FindBy(xpath = "//div[contains(text(),'Balance')]")
	private WebElement userBalance;
	
	@FindBy(tagName = "th")
	private List<WebElement> textHeading;

	@FindBy(tagName = "tr")
	private List<WebElement> textRow;
	
	public void fundTransferPageAssertVerify(String text) {
		Assert.assertTrue("Fund Transfer Assert", headingText.getText().equals(text));

	}

	public void perfomFundTransfer(String senderName, String receiverName, String transferAmount) {

		Select dropdownSender = new Select(senderAccount);
		dropdownSender.selectByValue(senderName.split("-")[1]);
		Select dropdownReceiver = new Select(receiverAccount);
		dropdownReceiver.selectByValue(receiverName.split("-")[1]);
		amountTransfer.sendKeys(transferAmount);
		submitButton.click();

	}
	
	public void checkBalanceAfterFundTransfer() {
		handleButton.click();
		System.out.println("Account After Fund Transfer " +userBalance.getText());

	}
	
	public void printTransactionLog() {
		System.out.println("\n\t\tTransaction statement for fund transfer\n");
		int size = textHeading.size();
		for (int i = 0; i < size; i++) {
			System.out.print(textHeading.get(i).getText() + "\t\t\t\t");
		}
		System.out.println();
		WebElement txtData = textRow.get(1);
		List<WebElement> txt = txtData.findElements(By.tagName("td"));
		for (WebElement webElement : txt) {
			System.out.print(webElement.getText() + "\t\t");
		}


	}
}
