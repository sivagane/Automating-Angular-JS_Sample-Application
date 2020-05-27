package qa.test.AngularJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.Automate_AngularApplication.AngularBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AngularTest {
	
	AngularBase angBas= new AngularBase();
	WebDriver driver;
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		jsDriver= (JavascriptExecutor)driver;
		ngWebDriver= new NgWebDriver(jsDriver);
		driver.get("http://localhost:3456/");
		ngWebDriver.waitForAngularRequestsToFinish();
	}
	@Test(priority=1)
	public void add() {
		angBas.doSum("10", "20");
	}
	@Test(priority=2)
	public void sub() {
		angBas.doSub("20", "10");
	}
	@Test(priority=3)
	public void mul() {
		angBas.doMul("10", "3");
	}
    @Test(priority=4)
    public void div() {
    	angBas.doDiv("40", "10");
    }
    
}
