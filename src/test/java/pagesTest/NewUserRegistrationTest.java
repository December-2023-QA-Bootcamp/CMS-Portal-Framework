package pagesTest;

import static common.CommonActions.clickElement;
import static common.CommonActions.currentUrl;
import static common.CommonActions.elementEnabled;
import static common.CommonActions.pause;
import static common.CommonActions.scrollIntoViewToTheElement;
import static common.CommonActions.validationOfHeader;
import static common.CommonActions.validationOfSubHeader;
import static common.CommonActions.verifyTextInTheWebElement;
import static common.CommonActions.verifyTitle;

import org.testng.annotations.Test;
import baseUtil.BaseClass;

public class NewUserRegistrationTest extends BaseClass {

	@Test (enabled = false)
	public void stepOneClickOnCancelButtonDirectToHomePage() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.stepOneClickOnCancelButtonDirectToHomePage();
	}
	
	
	@Test (enabled = false)
	public void newUserRegistrationTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoTitleAndHeaderValidation();
		newUserRegistration.firstNameValidation();
		newUserRegistration.middleNameValidation();
		newUserRegistration.lastNameValidation();
		newUserRegistration.suffixValidation();
		newUserRegistration.dobValidation();
		newUserRegistration.addressLine1Validation();
		newUserRegistration.addressLine2Validation();
		newUserRegistration.cityValidation();
		newUserRegistration.stateValidation();
		newUserRegistration.zipCodeValidation();
		newUserRegistration.zipCodePlus4Validation();
		newUserRegistration.emailValidation();
		newUserRegistration.emailConfirmValidation();
		newUserRegistration.phoneNumberValidation();
		newUserRegistration.nextStep2Validation();
	}
	
	@Test (enabled = false)
	public void clickOnNextButtonInStep2WithoutAnyDataTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.clickOnNextButtonInStep2WithoutAnyData();
		
	}
	
	@Test (enabled = false)
	public void clickOnNextButtonInStep2WithDataTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.untilClickOnNextButtonInStep2WithData();		
		newUserRegistration.nextStep2Validation();
	}
	
	@Test (enabled = false)
	public void stepTwoClickOnCancelButtonDirectToHomePage() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoClickOnCancelButtonDirectToHomePage();
	}
	
	@Test (enabled = true)
	public void stepTwoClickOnBackButtonDirectToPreviousPageTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoClickOnBackButtonDirectToPreviousPage();
	}
	
	
	


}
