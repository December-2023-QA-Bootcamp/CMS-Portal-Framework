package pagesTest;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class NewUserRegistrationTest extends BaseClass{
	
	@Test
	public void newUserRegistrationTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.stepOneClickOnCancelButtonDirectToHomePage();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoTitleAndHeaderValidation();
	}
	
	
	

}
