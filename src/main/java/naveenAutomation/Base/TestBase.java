package naveenAutomation.Base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import naveenAutomation.Listeners.WebdriverEvents;
import naveenAutomationBrowser.Browser;


public class TestBase {
	public static WebDriver driver;//instance of webdriver
	public Browser DEFAULT_BROWSER = Browser.GOOGLE_CHROME;//set default browser from enum class
	public static WebdriverEvents events=new WebdriverEvents();//create instance of webdriver events
	public EventFiringWebDriver eventFiringWebDriver;//create instance of eventfiring web driver
	public void launchBrowser() {

		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}
		eventFiringWebDriver=new EventFiringWebDriver(driver);//wrap your driver insatnce with eventfiring webdriver
		eventFiringWebDriver.register(events);//register webdriverevents 's events instance with evenf
		driver=eventFiringWebDriver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		// Manage the page load timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Manage the script load timeout
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		// Launch a page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	}

	public void quitBrowser() {
		// closing the browser
		driver.close();
	}

}
	