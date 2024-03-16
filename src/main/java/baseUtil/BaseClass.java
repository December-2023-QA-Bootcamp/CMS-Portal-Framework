package baseUtil;

import java.lang.reflect.Method;
import java.time.Duration;

import org.bouncycastle.LICENSE;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.CommonActions;
import constants.Profile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.NewUserRegistration;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.Configuration;
import static utils.IConstant.*;

public class BaseClass {
	public WebDriver driver;
	public HomePage homePage;
	Configuration configuration;
	public NewUserRegistration newUserRegistration;
	public Select select;
	//public JavascriptExecutor js;
	public WebDriverWait wait;
	String browserName;
	ExtentReports report;
	ExtentTest extentTest;
	
	// newly added
	@BeforeSuite
	public void initialReporting() {
		report = ExtentManager.initialReports();
	}
	
	// newly added
	@BeforeClass
	public void beforeClassSetUp() {
		configuration = new Configuration(Profile.GENERAL); 
		// parameterized Constructor of Configuration Class will be initialized
	}

	// newly added
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional(EDGE) String browserName) {
		// If any reason our test suit doesn't have parameter or value, then @Optional(EDGE) will work
		// If there is empty value or wrong value in testng.xml suite, then browser will not match and get the default one
		// WebdriverManager is instantiating the ChromeDriver
		this.browserName = browserName;
		initDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.getProperties(URL));
		// How can we convert a String to Long type
		long pageLoadWait = Long.parseLong(configuration.getProperties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));	
		// long explicitlyWait = Long.parseLong(configuration.getProperties(EXPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		// wait = new WebDriverWait(driver, Duration.ofSeconds(explicitlyWait));
		initClass();
		//js = (JavascriptExecutor) driver;
	}
	
	public void initDriver() {
		// String browserName = configuration.getProperties(BROWSER);
		// above line will be deleted and line 45 added
		
		switch (browserName) {
		
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
			driver = new ChromeDriver();
			break;

		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		
		case "EDGE":
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
			
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	public void initClass() {
		homePage = new HomePage(driver);
		newUserRegistration = new NewUserRegistration(driver);	
	}	
	
	// newly added
	@BeforeMethod
	public void initialTest(Method method) {
		extentTest = ExtentTestManager.createTest(report, method.getName());
		extentTest.assignCategory(method.getDeclaringClass().getName());
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test PASSED");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(CommonActions.getSreenShot(method.getName(), driver));
			extentTest.log(Status.FAIL, "Test FAILED");
		}else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test SKIPPED");
		}
	}
	
	@AfterSuite
	public void publishReport() {
		report.flush();
	}
	

}
