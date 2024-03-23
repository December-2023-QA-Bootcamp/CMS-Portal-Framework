package pages;

import static common.CommonActions.*;
import static common.CommonWaits.*;



import java.awt.Dimension;
import java.time.Duration;
import java.util.List;

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

	@FindBy(id = "cms-newuser-lastName")
	WebElement lastName;

	@FindBy(id = "cms-newuser-nameSuffix")
	WebElement suffix;
	
	@FindBy(xpath = "//select[@id='cms-newuser-nameSuffix']/option")
	List <WebElement> suffixList;
	
	@FindBy(id = "cms-newuser-birthMonth")
	WebElement birthMonth;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthMonth']/option")
	List<WebElement> birthMonthList;

	@FindBy(id = "cms-newuser-birthDate")
	WebElement birthDate;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthDate']/option")
	List<WebElement> birthDateList;

	@FindBy(id = "cms-newuser-birthYear")
	WebElement birthYear;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthYear']/option")
	List<WebElement> birthYearList;
		
	
	
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
		inputTextThenClickTab(firstName, "% & \\\" ( )"); // Why this method is used? Try to understand
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(firstName);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputText(firstName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(firstName);
		pause(3);
		inputText(firstName, "Moha'mm-ad Md");
		pause(3);
	}
	
	public void middleNameValidation() {
		verifyLengthOfTheFieldContent(middleName, "20");
		inputText(middleName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(middleName);
		pause(3);
		inputText(middleName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(middleName);
		pause(3);
		inputText(middleName, "To'fael Ka-bir");
		pause(3);
	}
	
	public void lastNameValidation() {
		verifyLengthOfTheFieldContent(lastName, "25");
		inputTextThenClickTab(lastName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(lastName);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputText(lastName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(lastName);
		pause(3);
		inputText(lastName, "S'- harkar");
		pause(5);
	}
	
	public void suffixValidation() {
		selectDropdownOnebyOne(suffix, suffixList);
		pause(3);
		selectDropdown(suffix, "SR");
		pause(3);
	}
	
	public void dobValidation() {
		clickElementThenTab(birthMonth);
		pause(3);
		clickElementThenTab(birthDate); // First 2 under the field message can't be validated, 3rd one done
		pause(3);
		clickElementThenTab(birthYear);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		selectDropdownOnebyOne(birthMonth, birthMonthList);
		selectDropdown(birthMonth, "February");
		pause(3);
		selectDropdownOnebyOne(birthDate, birthDateList);
		selectDropdown(birthDate, "29");
		pause(3);
		selectDropdownOnebyOne(birthYear, birthYearList);
		selectDropdown(birthYear, "1996");
		pause(3);
		
	}

	
	
	

}
