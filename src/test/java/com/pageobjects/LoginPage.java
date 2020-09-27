package com.pageobjects;




import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.ExcelData.Data;
import com.stepdefinitions.DigitalBankSteps;

public class LoginPage extends Data {
	
	
	public LoginPage()
	{
		
		PageFactory.initElements(DigitalBankSteps.driver, this);
	}

	@FindBy(id = "username")
	private  WebElement TextUserName;
	
	@FindBy(id = "password")
	private  WebElement TextPassword;
	
	@FindBy(id = "submit")
	private  WebElement LoginButton;
	
	@FindBy(linkText="Sign Up Here")
	private WebElement ConfirmText;
	

	
	public void performLogin(String userName, String userPassword) {
	TextUserName.sendKeys(userName);
	TextPassword.sendKeys(userPassword);
	LoginButton.click();
	}
	
	public void loginPageAssertVerify(String text)
	{
		Assert.assertTrue("Login Page Assert",
				ConfirmText.getText().equals(text));
	}
	
	
	}
	
	

