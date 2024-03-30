package pages;

import java.awt.Dimension;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//new, you have to manually write it to get access of common method
//this is possible when they are static in nature, * means all
//This is called static import
import static common.CommonActions.*;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	Dimension dimension;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory help to instantiate WebElements
		PageFactory.initElements(driver, this);
		// If no PageFactory class, Web element can't instantiated and will show "NullPointerException"
		// do java comment for line 16 to see the exception
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(id = "cms-login-submit")
	WebElement loginButton;
	
	@FindBy(name = "user-d")
	WebElement userId;
	
	@FindBy (how = How.NAME, using = "pass-d")
	WebElement password;
	
	@FindBy(xpath = "//label[@id='cms-label-tc']")
	WebElement checkBox;
	
	@FindBy (id = "cms-login-submit")
	WebElement login;
	
	@FindBy(xpath = "//div[starts-with(text(),'Invalid')]")
	WebElement loginErrorMsg;
	
	public void clickLoginButton() {
		loginButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// CommonMethods are used
	public void clickUserIdField() {
		clickElement(userId);
		pause(4);
	}
	
	// below methods Used in HomePageParameterizedTest Class	
	public void inputUserIdField(String userIdFieldText) {
		inputText(userId, userIdFieldText);
	}
	
	public void inputPasswordField(String passwordFieldText) {
		inputText(password, passwordFieldText);
	}
	
	public void clickCheckBox() {
		pause(3);
		clickElement(checkBox);
	}
	
	public void clickLogin() {
		pause(3);
		clickElement(login);		
	}
	
	public void errorMessage(String errMsg) {
		pause(3);
		verifyErrorMsg(loginErrorMsg, errMsg);
	}


}
