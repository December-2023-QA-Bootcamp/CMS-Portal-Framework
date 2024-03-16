package pages;

import java.awt.Dimension;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
		// PageFactory help to instantiate WebElements
		PageFactory.initElements(driver, this);
		// If no PageFactory class, Web element can't instantiated and will show "NullPointerException"
		// do java comment for line 16 to see the exception
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

}
