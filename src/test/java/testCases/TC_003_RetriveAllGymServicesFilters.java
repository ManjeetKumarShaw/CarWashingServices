package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.GymPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_003_RetriveAllGymServicesFilters extends BaseClass {
	
	@Test
	public void retriveFilters() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.handleLoginPopup();
		hp.gymServices();
		
		GymPage gp = new GymPage(driver);
		gp.retriveAllFilters();
	}

}
