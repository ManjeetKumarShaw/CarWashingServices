package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.CarWashingServicesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_ListOfCarWashingServices extends BaseClass{
	@Test
	public void topFiveCarWashingCenter() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.handleLoginPopup();
		hp.searchCarWashingServices();
		
		CarWashingServicesPage cw = new CarWashingServicesPage(driver);
		cw.topRatedFilter();
		cw.retriveFiveWashingServices();
	}

}
