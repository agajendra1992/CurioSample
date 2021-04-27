package utils;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;


public class Utils {

	public static WebDriver driver;

	public static WebDriver selectbrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox") || (browser.equalsIgnoreCase("FIREFOX"))) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;

		} else if (browser.equalsIgnoreCase("chrome") || (browser.equalsIgnoreCase("CHROME"))) {

			System.setProperty("webdriver.chrome.driver", TestBase.P.getProperty("browserpath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		return driver;
	}

	public void waitlimit(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void closebrowser() {
		driver.close();
	}

	public WebDriverWait waitelement(WebElement wb){
	WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(wb));
	return wait;
	}
	public void takeScreenshot(String name) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(src, new File("user.dir"
					+ "//CurioSample//src//main//java//screenshot//" + name +System.currentTimeMillis()+ ".jpg"));

		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}

	}

}