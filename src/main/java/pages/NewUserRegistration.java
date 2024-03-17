package pages;

import static common.CommonActions.*;
import static common.CommonWaits.*;



import java.awt.Dimension;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class NewUserRegistration {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	Dimension dimension;	
	
	public NewUserRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")
	WebElement logo;
	
	@FindBy(id = "cms-newuser-reg")
	WebElement newUserRegistration;
	
	@FindBy(xpath = "//p[contains(text(), ' Step #')]")
	WebElement stepOneHeader;

	@FindBy(xpath = "//p[contains(text(), ' Step 1 of 3')]")
	WebElement stepOneSubHeader;
	
	@FindBy(xpath = "//div[@class='ng-input']")
	WebElement selectYourApplication;

	@FindBy(id = "textSearch")
	WebElement textSearch;
	
	// @FindBy(xpath = "//a[text()='Cancel']//parent::div[@class='col-xs-12 col-sm-2 col-md-1 cms-agree-item cms-cancel']")
	@FindBy(xpath = "(//a[text()='Cancel'])[1]")
	WebElement stepOneCancel;

	@FindBy(id = "cms-tos-reg")
	WebElement agreeToTheTerms;

	@FindBy(name = "termsAndCondNext")
	WebElement StepOneNextButton;
	
	@FindBy(id = "cms-register-information")
	WebElement stepTwoHeader;

	@FindBy(xpath = "//p[contains(text(), ' Step 2 of 3')]")
	WebElement stepTwosubHeader;

	@FindBy(id = "cms-newuser-firstName")
	WebElement firstName;
	
	@FindBy(xpath = "//span[text()='Required field.']")
	WebElement requiredFieldErrorMsgUnderTheField;

	@FindBy(xpath = "//span[text()='Must be alphabetic characters.']")
	WebElement alphabeticCharactersErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-middleName")
	WebElement middleName;


		
	
	
	public void landingOnhomePageAndDirectingToNewUserRegistration() {
		elementDisplayed(logo);
		verifyTitle(driver,"CMS Enterprise Portal");
		elementEnabled(newUserRegistration);
		verifyTextInTheWebElement(newUserRegistration, "New User Registration");
		clickElement(newUserRegistration);
		pause(3);
	}
	
	public void stepOneClickOnCancelButtonDirectToHomePage() {
		pause(3);
		clickElement(selectYourApplication);
		inputTextThenClickEnter(textSearch, "BCRS Web");
		elementEnabled(stepOneCancel);
		verifyTextInTheWebElement(stepOneCancel, "Cancel");
		//clickElement(stepOneCancel);
		usingJavascriptExecutor(driver, "arguments[0].click()", stepOneCancel);
		pause(3);
		currentUrl(driver, "https://portal.cms.gov/portal/");
	}
	
	public void selectApplicationOnStepOneAndNavigateToStepTwo() {
		pause(3);
		clickElement(newUserRegistration);
		pause(3);
		currentUrl(driver, "https://portal.cms.gov/portal/newuserregistration");
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration");
		validationOfHeader(stepOneHeader, "Step #1: Select Your Application");
		validationOfSubHeader(stepOneSubHeader, "Step 1 of 3 - Select your application from the dropdown. You will then need to agree to the terms & conditions.");
		pause(3);
		clickElement(selectYourApplication);
		inputTextThenClickEnter(textSearch, "BCRS Web");
		elementSelected(agreeToTheTerms);
		waitThenClick(driver, agreeToTheTerms);
		pause(3);
		elementEnabled(StepOneNextButton);
		verifyTextInTheWebElement(StepOneNextButton, "Next");
		clickElement(StepOneNextButton);
		pause(3);
	}
	
	public void stepTwoTitleAndHeaderValidation() {
		pause(5);
		currentUrl(driver, "https://portal.cms.gov/portal/newuserregistration");
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration");
		validationOfHeader(stepTwoHeader, "Step #2: Register Your Information");
		validationOfSubHeader(stepTwosubHeader, "Step 2 of 3 - Please enter your personal and contact information.");
	}
	
	public void firstNameValidation() {
		verifyLengthOfTheFieldContent(firstName, "20");
		inputTextThenClickTab(firstName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(firstName);
		inputTextThenClickTab(firstName, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputTextThenClickTab(firstName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(firstName);
		pause(3);
		inputText(firstName, "Moha'mm-ad Md");
		pause(3);
	}

	
	
	

}
