package testCases;

import org.testng.annotations.Test;

import pageObjects.FreeListingPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_ListWithInvalidDataAndRetriveErrorMsg extends BaseClass {

	@Test
	public void errorMsgForInvalidData() {
		HomePage hp = new HomePage(driver);
		hp.handleLoginPopup();
		hp.listServices();
		
		FreeListingPage flp = new FreeListingPage(driver);
		flp.listWithInvalidMobileNo();
		flp.retriveErrorMsg();
	}
}
