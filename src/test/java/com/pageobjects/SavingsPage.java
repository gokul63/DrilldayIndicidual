package com.pageobjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.stepdefinitions.DigitalBankSteps;

public class SavingsPage {
	
	public SavingsPage()
	{
		PageFactory.initElements(DigitalBankSteps.driver, this);
	}
	
	@FindBy(id = "savings-menu")
	private WebElement savingsMenu;
	
	@FindBy(linkText = "View Savings")
	private WebElement savingsPage;
	
	@FindBy(xpath = "//*[@id='transactionTable']/tbody/tr[1]/td[5]")
	private WebElement firstBalance;
	
	@FindBy(xpath = "(//div[@class='card-body'][1])")
	private WebElement accountList;
	
	@FindBy(id="new-savings-menu-option")
	private WebElement newSavings;
	
	@FindBy(xpath="//strong[text()='New Savings Account']")
	private WebElement newSavingsHeading;
	
	@FindBy(xpath = "//input[@type='radio']/preceding::label[@for='Savings']")
	private  WebElement accountType;
	
	@FindBy(xpath = "//input[@type='radio']/preceding::label[@for='Individual']")
	private  WebElement accountOwnership;
	
	@FindBy(id = "name")
	private  WebElement accountName;
	
	@FindBy(id = "openingBalance")
	private  WebElement openBal;
	
	@FindBy(id = "newSavingsSubmit")
	private  WebElement savingSubmit;
	
	@FindBy(xpath = "//a[contains(text(),'View Savings')]")
	private  WebElement viewSavingAcc;
	
	public  void checkBalanceBeforeDeposit()
	{
		savingsMenu.click();
		savingsPage.click();
		System.out.println("Account Balance Before Deposit : "+firstBalance.getText());
	}
	
	

}
