package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import log.Log;
import utils.Utils;

public class TestBase extends Utils {

	public static Properties P = new Properties();
	public File f;
	public FileInputStream FI;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void launch() throws IOException {

		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("Curio_Test_001");
		Log.info("Loading the Properties");
		loadproperties();
		selectbrowser(P.getProperty("browser"));
		Log.info("Launch the browser ");
		waitlimit(20);
		driver.get(P.getProperty("url"));
		Log.info("Enter the URL");
		Log.endTestCase("Curio_Test_001");

	}

	public void loadproperties() throws IOException {
		f = new File(System.getProperty("user.dir") + "//src//main//java//config//Config.properties");
		FI = new FileInputStream(f);
		P.load(FI);

		f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\applocator\\loginlocator.properties");
		FI = new FileInputStream(f);
		P.load(FI);
		f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\applocator\\Search.properties");
		FI = new FileInputStream(f);
		P.load(FI);

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);

	}

	public WebElement getlocator(String locator) throws Exception {
		// System.out.println("iii"+locator);
		String locatorkey = locator.split("_")[0];
		String locatorvalue = locator.split("_")[1];

		if (locatorkey.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorvalue));

		else if (locatorkey.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorvalue));

		else if (locatorkey.toLowerCase().equals("name"))
			return driver.findElement(By.xpath(locatorvalue));

		else if ((locatorkey.toLowerCase().equals("classname")) || (locatorkey.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorvalue));

		else if ((locatorkey.toLowerCase().equals("tagname")) || (locatorkey.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorvalue));
		else if ((locatorkey.toLowerCase().equals("linktext")) || (locatorkey.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorvalue));
		else if (locatorkey.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorvalue));
		else if ((locatorkey.toLowerCase().equals("cssselector")) || (locatorkey.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorvalue));

		else
			throw new Exception("ELEMENT" + locatorkey);
	}

	public static List<WebElement> getLocators(String locator) throws Exception {
		String locatorkey = locator.split("_")[0];
		String locatorValue = locator.split("_")[1];

		if (locatorkey.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorkey.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorkey.toLowerCase().equals("classname")) || (locatorkey.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorkey.toLowerCase().equals("tagname")) || (locatorkey.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorkey.toLowerCase().equals("linktext")) || (locatorkey.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorkey.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorkey.toLowerCase().equals("cssselector")) || (locatorkey.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorkey.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorkey + "'");
	}

	public WebElement getWebElement(String locator) throws Exception {
		return getlocator(P.getProperty(locator));
	}

	public List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(P.getProperty(locator));
	}

	public Actions getact() {
		Actions action = new Actions(driver);
		return action;
	}

	public Select getselect(WebElement element) {

		Select select = new Select(element);
		return select;
	}
}
