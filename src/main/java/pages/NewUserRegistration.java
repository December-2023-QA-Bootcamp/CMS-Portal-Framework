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
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderFirstName;
	
	@FindBy(xpath = "//a[contains(text(), 'First Name')]")
	WebElement firstNameErrorMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Must be alphabetic characters.']")
	WebElement alphabeticCharactersErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-middleName")
	WebElement middleName;

	@FindBy(id = "cms-newuser-lastName")
	WebElement lastName;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderLastName;
	
	@FindBy(xpath = "//a[contains(text(), 'Last Name')]")
	WebElement lastNameErrorMsgTopOfThePage;

	@FindBy(id = "cms-newuser-nameSuffix")
	WebElement suffix;
	
	@FindBy(xpath = "//select[@id='cms-newuser-nameSuffix']/option")
	List <WebElement> suffixList;
	
	@FindBy(id = "cms-newuser-birthMonth")
	WebElement birthMonth;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderBirthMonth;
	
	@FindBy(xpath = "//a[contains(text(), 'Birth Month')]")
	WebElement birthMonthErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthMonth']/option")
	List<WebElement> birthMonthList;

	@FindBy(id = "cms-newuser-birthDate")
	WebElement birthDate;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderBirthDate;
	
	@FindBy(xpath = "//a[contains(text(), 'Birth Date')]")
	WebElement birthDateErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthDate']/option")
	List<WebElement> birthDateList;

	@FindBy(id = "cms-newuser-birthYear")
	WebElement birthYear;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderBirthYear;
	
	@FindBy(xpath = "//a[contains(text(), 'Birth Year')]")
	WebElement birthYearErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthYear']/option")
	List<WebElement> birthYearList;
	
	@FindBy(xpath = "//label[@class='check-radio']//parent::li[@class='cms-radio-item']")
	WebElement usBasedAddress;

	@FindBy(xpath = "//label[@class='check-radio']//parent::li[@class='cms-radio-item2']")
	WebElement nonUsBasedAddress;

	@FindBy(id = "cms-newuser-homeAddressLine1")
	WebElement addressLine1;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderHomeAddressLine1;
	
	@FindBy(xpath = "//a[contains(text(), 'Home Address Line1')]")
	WebElement homeAddressLine1ErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//span[text()='Must be alphanumeric characters.']")
	WebElement alphanumericCharactersErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-usAddress2")
	WebElement addressLine2;

	@FindBy(id = "cms-newuser-usCity")
	WebElement city;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderCity;
	
	@FindBy(xpath = "//a[contains(text(), 'City')]")
	WebElement cityErrorMsgTopOfThePage;

	@FindBy(id = "cms-newuser-usState")
	WebElement state;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderState;
	
	@FindBy(xpath = "//a[contains(text(), 'State')]")
	WebElement stateErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-usState']/option")
	List<WebElement> stateList;

	@FindBy(name = "cms-newuser-zipcode")
	WebElement zipCode;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderZipCode;
	
	@FindBy(xpath = "//a[contains(text(), 'Zip Code')]")
	WebElement zipCodeMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Must be a valid numeric ZIP Code.']")
	WebElement numericZipCodeErrorMsgUnderTheField;

	@FindBy(xpath = "//span[text()='Must be a valid numeric ZIP+4 Code.']")
	WebElement numericZipPlus4CodeErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-usZipcodeExt")
	WebElement zipCodeExt;

	@FindBy(id = "cms-newuser-usEmail")
	WebElement email;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderEmail;
	
	@FindBy(xpath = "//a[contains(text(), 'Email Address')]")
	WebElement emailAddressMsgTopOfThePage;

	@FindBy(id = "cms-newuser-usConfirmEmail")
	WebElement confirmEmail;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderConfirmEmail;
	
	@FindBy(xpath = "//a[contains(text(), 'Confirm Email Address')]")
	WebElement confirmEmailAddressMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Must match Email Address values.']")
	WebElement mismatchEmailAddressErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-usPhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderPhoneNumber;
	
	@FindBy(xpath = "//a[contains(text(), 'Phone Number')]")
	WebElement phoneNumberMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Phone Number must not start with a 1 or 0.']")
	WebElement phoneNumberNotStartWithErrorMsgUnderTheField;

	@FindBy(xpath = "//span[text()='Must be a valid Phone Number.']")
	WebElement validPhoneNumberErrorMsgUnderTheField;

	@FindBy(id = "step2NextButton")
	WebElement nextButtonStep2;
	
	@FindBy(xpath = "(//a[contains(text(), 'Cancel')])[2]")
	WebElement stepTwoCancel;
	
	@FindBy(id = "step2BackButton")
	WebElement stepTwoBackButton;
		
	public void landingOnhomePageAndDirectingToNewUserRegistration() {
		elementDisplayed(logo);
		verifyTitle(driver,"CMS Enterprise Portal");
		elementEnabled(newUserRegistration);
		verifyTextInTheWebElement(newUserRegistration, "New User Registration");
		clickElement(newUserRegistration);
		pause(3);
	}
	
	public void stepOneClickOnCancelButtonDirectToHomePage() {
		clickElement(selectYourApplication);
		inputTextThenClickEnter(textSearch, "BCRS Web");
		elementEnabled(stepOneCancel);
		verifyTextInTheWebElement(stepOneCancel, "Cancel");
		clickElement(stepOneCancel);
		pause(3);
		currentUrl(driver, "https://portal.cms.gov/portal/");
	}
	
	public void selectApplicationOnStepOneAndNavigateToStepTwo() {
//		pause(3);
//		clickElement(newUserRegistration);
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
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderFirstName, "Required field.");
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
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderLastName, "Required field.");
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
		selectDropdown(birthMonth, "February");
		pause(3);
		selectDropdown(birthMonth, "Select Birth Month");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderBirthMonth, " Required field.");
		pause(3);
		verifyErrorMsgTopOfThePage(birthMonthErrorMsgTopOfThePage, "Birth Month is a required field.");
		pause(3);
		selectDropdownOnebyOne(birthMonth, birthMonthList);
		selectDropdown(birthMonth, "February");
		pause(5);
		selectDropdown(birthDate, "1");
		pause(3);
		selectDropdown(birthMonth, "Select Birth Date");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderBirthDate, " Required field.");
		pause(3);
		verifyErrorMsgTopOfThePage(birthDateErrorMsgTopOfThePage, "Birth Date is a required field.");
		pause(3);
		selectDropdownOnebyOne(birthDate, birthDateList);
		selectDropdown(birthDate, "28");
	
		// Birth Year need to be added
		
	}
	
	public void addressLine1Validation() {
		clickElement(nonUsBasedAddress);
		pause(5);
		clickElement(usBasedAddress);
		// start of addressLine 1 validation
		verifyLengthOfTheFieldContent(addressLine1, "60");
		inputTextThenClickTab(addressLine1, " * < > ^ ! # $ + / : ; = ? @ [ ] ");
		verifyErrorMsgUnderTheField(alphanumericCharactersErrorMsgUnderTheField, "Must be alphanumeric characters.");
		pause(3); // is not used in the industry, this is used when you scripting the test cases,
					// we will comment out all and run, if failed, then we will use web driver wait
		clearTextFromTheField(addressLine1);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderHomeAddressLine1, "Required field.");
		pause(3);
		inputText(addressLine1, "6.1E 97th-s S_t, 66"); // **NOTE: Special characters allowed are: (Space) ' ‐ , . _
		pause(3);
	}
	
	public void addressLine2Validation() {
		verifyLengthOfTheFieldContent(addressLine2, "64");
		inputTextThenClickTab(addressLine2, " * < > ^ ! # $ + / : ; = ? @ [ ] ");
		verifyErrorMsgUnderTheField(alphanumericCharactersErrorMsgUnderTheField, "Must be alphanumeric characters.");
		pause(3); 
		clearTextFromTheField(addressLine2);
		pause(3);
		inputText(addressLine2, "A.pt 123123 E 1009th-s S_t, 66");
		pause(3);
	}
	
	public void cityValidation() {
		verifyLengthOfTheFieldContent(city, "30");
		pause(3);
		inputTextThenClickTab(city, " > ^ ! # $ + / : ; = ? @");		
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(city);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderCity, "Required field.");
		pause(3);
		inputTextThenClickTab(city, "64783city");
		pause(3);
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(city);
		inputText(city, "Clark's Mountain"); // another example: Winston-Salem
		pause(3);
	}
	
	public void stateValidation() {
//		selectDropdown(state, "New York"); // function is not same as Birth Month
//		pause(3);
//		selectDropdown(state, "Select State");
//		pause(3);
		clickElementThenTab(state);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderState, " Required field.");
		pause(3);
		selectDropdownOnebyOne(state, stateList);
		pause(3);
		selectDropdown(state, "New York");
		pause(3);
	}
	
	public void zipCodeValidation() {
		verifyLengthOfTheFieldContent(zipCode, "5");	
		inputTextThenClickTab(zipCode, "1002");
		pause(3);
		verifyErrorMsgUnderTheField(numericZipCodeErrorMsgUnderTheField, "Must be a valid numeric ZIP Code.");
		clearTextFromTheField(zipCode);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderZipCode, "Required field.");
		pause(3);
		inputTextThenClickTab(zipCode, " > ^ ! # $ + / : ; = ? @");
		verifyErrorMsgUnderTheField(numericZipCodeErrorMsgUnderTheField, "Must be a valid numeric ZIP Code.");
		pause(3);
		clearTextFromTheField(zipCode);
		inputText(zipCode, "AaBcR");
		verifyErrorMsgUnderTheField(numericZipCodeErrorMsgUnderTheField, "Must be a valid numeric ZIP Code.");
		pause(3);
		clearTextFromTheField(zipCode);
		inputText(zipCode, "10019");
		pause(3);
	}
	
	public void zipCodePlus4Validation() {
		verifyLengthOfTheFieldContent(zipCodeExt, "4");
		inputTextThenClickTab(zipCodeExt, "100");
		verifyErrorMsgUnderTheField(numericZipPlus4CodeErrorMsgUnderTheField, "Must be a valid numeric ZIP+4 Code.");		
		clearTextFromTheField(zipCodeExt);
		pause(3);
		inputTextThenClickTab(zipCodeExt, " > ^ ! # $ + / : ; = ? @");
		verifyErrorMsgUnderTheField(numericZipPlus4CodeErrorMsgUnderTheField, "Must be a valid numeric ZIP+4 Code.");
		pause(3);
		clearTextFromTheField(zipCodeExt);
		inputText(zipCodeExt, "AdBc");
		verifyErrorMsgUnderTheField(numericZipPlus4CodeErrorMsgUnderTheField, "Must be a valid numeric ZIP+4 Code.");
		pause(3);
		clearTextFromTheField(zipCodeExt);
		inputText(zipCodeExt, "1001");
		pause(3);
	}
	
	public void emailValidation() {
		verifyLengthOfTheFieldContent(email, "74");
		inputTextThenClickTab(email, "^%&^%^%&");
//		pause(5);
//		verifyErrorMsgUnderTheField(email, "Must be a valid Email Address.");		// actual error message is nt received
		pause(3);
		clearTextFromTheField(email);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderEmail, "Required field.");
		pause(3);
//		inputText(email, "12345");
//		verifyErrorMsgUnderTheField(email, "Must be a valid Email Address.");
//		pause(3);
//		clearTextFromTheField(email);
		inputText(email, "tofael483@gmail.com");
		pause(3);
		// Need to find out the requirements for email configuration
	}
	
	public void emailConfirmValidation() {
		verifyLengthOfTheFieldContent(confirmEmail, "74");
		inputTextThenClickTab(confirmEmail, "amtks483@gmail.com");
		pause(3);
		verifyErrorMsgUnderTheField(mismatchEmailAddressErrorMsgUnderTheField, "Must match Email Address values.");
		pause(3);
		clearTextFromTheField(confirmEmail);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderConfirmEmail, "Required field.");
		pause(3);		
		inputText(confirmEmail, "tofael483@gmail.com");
		pause(3);
	}
	
	public void phoneNumberValidation() {
		verifyLengthOfTheFieldContent(phoneNumber, "12");
		inputText(phoneNumber, "0929301602");
		verifyErrorMsgUnderTheField(phoneNumberNotStartWithErrorMsgUnderTheField, "Phone Number must not start with a 1 or 0.");
		pause(3);
		clearTextFromTheField(phoneNumber);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderPhoneNumber, "Required field.");
		pause(3);
		inputText(phoneNumber, "1929301602");
		verifyErrorMsgUnderTheField(phoneNumberNotStartWithErrorMsgUnderTheField, "Phone Number must not start with a 1 or 0.");
		pause(3);
		clearTextFromTheField(phoneNumber);
		pause(3);
		inputText(phoneNumber, "(3)*<>^9!#$+ ");
		pause(3);
		verifyErrorMsgUnderTheField(validPhoneNumberErrorMsgUnderTheField, "Must be a valid Phone Number.");
		pause(3);
		clearTextFromTheField(phoneNumber);
		pause(3);
		inputText(phoneNumber, "ahsuchbs");
		pause(3);
		verifyErrorMsgUnderTheField(validPhoneNumberErrorMsgUnderTheField, "Must be a valid Phone Number.");
		pause(3);
		clearTextFromTheField(phoneNumber);
		pause(3);
		inputText(phoneNumber, "9293016028");
		pause(5);
	}
	
	public void nextStep2Validation() {
		scrollIntoViewToTheElement(driver, "arguments[0].scrollIntoView(true);", nextButtonStep2);
		elementEnabled(nextButtonStep2);
		verifyTextInTheWebElement(nextButtonStep2, "Next");
		pause(3);
		clickElement(nextButtonStep2);
		pause(5);
	}
	
	public void clickOnNextButtonInStep2WithoutAnyData() {
		pause(3);
		scrollIntoViewToTheElement(driver, "arguments[0].scrollIntoView(true);", nextButtonStep2);
		pause(3);
		clickElement(nextButtonStep2);
		pause(5);
		verifyErrorMsgTopOfThePage(firstNameErrorMsgTopOfThePage, "First Name is a required field.");
		verifyErrorMsgTopOfThePage(lastNameErrorMsgTopOfThePage, "Last Name is a required field.");
		verifyErrorMsgTopOfThePage(birthMonthErrorMsgTopOfThePage, "Birth Month is a required field.");
		verifyErrorMsgTopOfThePage(birthDateErrorMsgTopOfThePage, "Birth Date is a required field.");
		verifyErrorMsgTopOfThePage(birthYearErrorMsgTopOfThePage, "Birth Year is a required field.");
		verifyErrorMsgTopOfThePage(homeAddressLine1ErrorMsgTopOfThePage, "Home Address Line1 is a required field.");
		verifyErrorMsgTopOfThePage(cityErrorMsgTopOfThePage, "City is a required field.");
		verifyErrorMsgTopOfThePage(stateErrorMsgTopOfThePage, "State is a required field.");
		verifyErrorMsgTopOfThePage(zipCodeMsgTopOfThePage, "Zip Code is a required field.");
		verifyErrorMsgTopOfThePage(emailAddressMsgTopOfThePage, "Email Address is a required field.");
		verifyErrorMsgTopOfThePage(confirmEmailAddressMsgTopOfThePage, "Confirm Email Address is a required field.");
		verifyErrorMsgTopOfThePage(phoneNumberMsgTopOfThePage, "Phone Number is a required field.");
		pause(5);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderFirstName, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderLastName, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderBirthMonth, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderBirthDate, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderBirthYear, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderHomeAddressLine1, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderCity, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderState, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderZipCode, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderEmail, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderConfirmEmail, "Required field.");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderPhoneNumber, "Required field.");
		pause(3);
	}
	
	public void untilClickOnNextButtonInStep2WithData() {
		pause(3);
		inputText(firstName, "Moha'mm-ad Md");
		pause(3);
		inputText(middleName, "To'fael Ka-bir");
		pause(3);
		inputText(lastName, "S'- harkar");
		pause(5);
		selectDropdown(suffix, "SR");
		pause(3);
		selectDropdown(birthMonth, "February");
		pause(5);
		selectDropdown(birthDate, "28");
		pause(5);
		selectDropdown(birthYear, "1975");
		pause(5);
		inputText(addressLine1, "6.1E 97th-s S_t, 66");
		pause(3);
		inputText(addressLine2, "A.pt 123123 E 1009th-s S_t, 66");
		pause(3);
		inputText(city, "Clark's Mountain"); // another example: Winston-Salem
		pause(3);
		selectDropdown(state, "New York");
		pause(3);
		inputText(zipCode, "10019");
		pause(3);
		inputText(zipCodeExt, "1001");
		pause(3);
		inputText(email, "tofael483@gmail.com");
		pause(3);
		inputText(confirmEmail, "tofael483@gmail.com");
		pause(3);
		inputText(phoneNumber, "9293016028");
		pause(5);
	}
	
	public void stepTwoClickOnCancelButtonDirectToHomePage() {
		pause(5);
		scrollIntoViewToTheElement(driver, "arguments[0].scrollIntoView(true);", stepTwoCancel);
		elementEnabled(stepTwoCancel);
		verifyTextInTheWebElement(stepTwoCancel, "Cancel");
		pause(3);
		clickElement(stepTwoCancel);
		pause(3);
		currentUrl(driver, "https://portal.cms.gov/portal/");
	}
	
	public void stepTwoClickOnBackButtonDirectToPreviousPage() {
		pause(5);
		scrollIntoViewToTheElement(driver, "arguments[0].scrollIntoView(true);", stepTwoBackButton);
		elementEnabled(stepTwoBackButton);
		verifyTextInTheWebElement(stepTwoBackButton, "Back");
		pause(3);
		clickElement(stepTwoBackButton);
		pause(3);
		currentUrl(driver, "https://portal.cms.gov/portal/newuserregistration"); // no need
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration"); // no need
		validationOfHeader(stepOneHeader, "Step #1: Select Your Application");
		validationOfSubHeader(stepOneSubHeader, "Step 1 of 3 - Select your application from the dropdown. You will then need to agree to the terms & conditions.");
		pause(3);
	}
	
	
	





	
	
	
	

}
