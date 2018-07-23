package Steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import Util.Lib;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GUIStepDefinition extends Lib{
	
	
	WebDriver driver;
	
	@Before
	public void initialize() {
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("mac")) {
			System.out.println("Running on Mac!");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/mac/chomedriver");
		} else if (os.contains("windows")) {
			System.out.println("Running on Windows");
			System.setProperty("webdriver.chome.driver", "C:\\Users\\xxthe\\Google Drive\\PIIT\\Selenium\\Java\\FacebookBDDTest\\chromedriver.exe");
		} else {
			System.out.println("Running on Linux");
		}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Given("^i am at homepage of site$")
	public void home_page() {
		String title = getTitle(driver);
		System.out.println("Title: " + title);
	}
	
	@Then("^i am typing \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_value(String value, String key) throws IOException, InterruptedException {
		WebElement enter = findElem(driver, readProperty(value));
		enter.sendKeys(key);
		Thread.sleep(1000);
	}
	
	@Then("^i am clicking \"([^\"]*)\"$")
	public void click_item(String value) throws IOException, InterruptedException {
		WebElement click = findElem(driver, readProperty(value));
		click.click();
		Thread.sleep(1000);
	}

	@Then("^i move mouse to \"([^\"]*)\"$")
	public void move_mouse(String value) throws IOException, InterruptedException {
		WebElement elem = findElem(driver, readProperty(value));
		Actions ac = new Actions(driver);
		ac.moveToElement(elem).build().perform();
		Thread.sleep(1000);
	}
	
	@Then("^i am closing tab$")
	public void close_tab() throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		switchWindow(driver);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(1000);
	}
	
	@Then("^i am switching tab$")
	public void switch_tab() throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		switchWindow(driver);
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(1000);
	}
	
	@Then("^i am printing text \"([^\"]*)\"$")
	public void print_text(String value) throws InterruptedException, IOException {
		WebElement elem = findElem(driver, readProperty(value));
		String text = elem.getText();
		System.out.println(text);
		Thread.sleep(1000);
	}
	
	@Then("^i am selecting \"([^\"]*)\" \"([^\"]*)\"$")
	public void select_item(String value, String key) throws InterruptedException, IOException {
		WebElement elem = findElem(driver, readProperty(value));
		Select sc = new Select(elem);
		sc.selectByValue(key);
		Thread.sleep(1000);
	}
	
	@Then("^i am executing \"([^\"]*)\" \"([^\"]*)\"$")
	public void execute_item(String value, String key) throws InterruptedException, IOException {
		WebElement elem = findElem(driver, readProperty(value));
		elem.click();
		elem.sendKeys("New York");
		Thread.sleep(1000);
	}
	
	@Then("^i take screenshot \"([^\"]*)\"$")
	public void screenshot(String value) throws IOException, InterruptedException {
		takeScreenshot(driver, value);
		Thread.sleep(1000);
	}
	
	@After
	public void teardown() {
		System.out.println("Testing Complete");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
