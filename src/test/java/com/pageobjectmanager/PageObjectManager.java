package com.pageobjectmanager;



import com.pageobjects.DepositPage;
import com.pageobjects.FundTransferPage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.Logout;
import com.pageobjects.SavingsPage;





public class PageObjectManager {

	private LoginPage login_page;
	private HomePage home_page;
	private FundTransferPage fundtransfer_page;
	private Logout logout;
	private DepositPage deposit_page;
	private SavingsPage savings_page;
	

	public LoginPage getLogin_page() {
		return (login_page == null) ? login_page = new LoginPage() : login_page;
	}

	public HomePage getHome_page() {
		return (home_page == null) ? home_page = new HomePage() : home_page;
	}

	public FundTransferPage getFundtransfer_page() {
		return (fundtransfer_page == null) ? fundtransfer_page = new FundTransferPage() : fundtransfer_page;
	}

	public Logout getLogout() {
        return (logout == null) ? logout = new Logout() : logout;
    }
	
	public DepositPage getDeposit_page() {
		return (deposit_page == null) ? deposit_page = new DepositPage() : deposit_page;
	}
	
	public SavingsPage getSavings_page() {
		return (savings_page == null) ? savings_page = new SavingsPage() : savings_page;
	}
	
	
	
	
	

}
