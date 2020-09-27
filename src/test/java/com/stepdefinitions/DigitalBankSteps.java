package com.stepdefinitions;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ExcelData.Data;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DigitalBankSteps extends Data {
	public static WebDriver driver;
	PageObjectManager page_object_manager;
	String userName;
	String userPassword;
	String senderAccount;
	String receiverAccount;
	 String transferAmount;
	 String userDepositAccount;
	 String userDepositAmount;

	
	@Given("Launch the digital bank application {string} in browser")
	public void launch_the_digital_bank_application_in_browser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		page_object_manager = new PageObjectManager();
		page_object_manager.getLogin_page().loginPageAssertVerify("Sign Up Here");
		System.out.println("Login page is verifed Successfully");
	}

	@When("User gets {string} to perform fundtransfer")
	public void user_gets_to_perform_fundtransfer(String testCaseId) throws Exception {
//		System.out.println(retriveData().get("1").get("UserName"));
//		String string = retriveData().get(testCaseId).get("UserName");
//		System.out.println(string);
		  userName = retriveData().get(testCaseId).get("UserName");
		  userPassword = retriveData().get(testCaseId).get("Password");
		  senderAccount = retriveData().get(testCaseId).get("SenderAccount");
	 receiverAccount = retriveData().get(testCaseId).get("ReceiverAccount");
	 transferAmount = retriveData().get(testCaseId).get("TransferAmount");
	
	}
	
	@When("User enters the userName and password to log in to application")
	public void user_enters_the_userName_and_password_to_log_in_to_application() {
		page_object_manager.getLogin_page().performLogin(userName,userPassword);
		page_object_manager.getHome_page().homePageAssertVerify("Welcome");
		System.out.println("Home Page is verified Successfully");
	}

	@When("User initiate the fund transfer")
	public void user_initiate_the_fund_transfer() {
	   page_object_manager.getHome_page().checkBalanceBeforeTransfer();
	   page_object_manager.getFundtransfer_page().fundTransferPageAssertVerify("Transfer Between Accounts");
	}
	

	@When("User inputs the senderAccount, receiverAccount and amount to complete  the fund transfer")
	public void user_inputs_the_senderAccount_receiverAccount_and_amount_to_complete_the_fund_transfer() {
	    page_object_manager.getFundtransfer_page().perfomFundTransfer(senderAccount,receiverAccount,transferAmount);
	    page_object_manager.getFundtransfer_page().checkBalanceAfterFundTransfer();
	}

	@Then("Verify user completes the fund transfer successfully and log out the application")
	public void verify_user_completes_the_fund_transfer_successfully_and_log_out_the_application() {
		page_object_manager.getFundtransfer_page().printTransactionLog();
		System.out.println();
		page_object_manager.getLogout().performLogOut();
		page_object_manager.getLogout().logOutPageAssertVerify("success");
		System.out.println("Logout successful");
	  
	}
	
	@When("User gets {string} to perform  deposit into account")
	public void user_gets_to_perform_deposit_into_account(String testCaseId) throws Exception {
	   userName = retriveData().get(testCaseId).get("UserName");
	   userPassword = retriveData().get(testCaseId).get("Password");
	   userDepositAccount = retriveData().get(testCaseId).get("AccountForDeposit");
	   userDepositAmount  = retriveData().get(testCaseId).get("DepositAmount");
	}

	@When("User initiates the deposit into account")
	public void user_initiates_the_deposit_into_account() {
	    page_object_manager.getSavings_page().checkBalanceBeforeDeposit();
	    page_object_manager.getDeposit_page().initiateDeposit("Deposit into Account");
	    System.out.println("Deposit Page is verified successfully");
	}

	@When("User inputs the accountForDeposit and depositAmount to complete the deposit")
	public void user_inputs_the_accountForDeposit_and_depositAmount_to_complete_the_deposit() {
	   page_object_manager.getDeposit_page().performDeposit(userDepositAccount, userDepositAmount);
	}

	@Then("Verify user completes the deposit successfully with deposit amount depositAmount")
	public void verify_user_completes_the_deposit_successfully_with_deposit_amount_depositAmount() {
		 page_object_manager.getDeposit_page().checkBalanceAfterDeposit();
		    System.out.println("Deposit Page is verified successfully");
	}

	@Then("User logs out of the application")
	public void user_logs_out_of_the_application() {
	    page_object_manager.getLogout().performLogOut();
	    page_object_manager.getLogout().logOutPageAssertVerify("success");
	    System.out.println("Logout successful");
	}
}
