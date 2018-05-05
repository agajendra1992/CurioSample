package pagelib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Key;

import log.Log;
import testbase.TestBase;

public class SearchFlight extends TestBase {

	public void SFlight(String start, String start1, String start2, String end, String end1, String end2, String date1)
			throws Exception {
		Thread.sleep(2000);
		Log.info("Clear the startcity");
		getWebElement("curio.startingcity").clear();
		getWebElement("curio.startingcity").sendKeys(start);
		// Thread.sleep(1000);
		getWebElement("curio.startingcity").sendKeys(start1);
		// Thread.sleep(1000);
		getWebElement("curio.startingcity").sendKeys(start2);
		Log.info("Enter the startcity");
		Thread.sleep(1000);

		if (!getWebElement("curio.waitele").isDisplayed()) {
			Log.info("Select the startcity");
			getWebElement("curio.startingcity").sendKeys(start2, Keys.BACK_SPACE);
			Thread.sleep(2000);
		}

		List<WebElement> Allelement = getWebElements("curio.startcity");
		int size = Allelement.size();

		for (int i = 0; i < size - 1; i++) {
			if (Allelement.get(i).getText().equalsIgnoreCase("Hyderabad(Rajiv Gandhi Intl, HYD),IN")
					|| Allelement.get(i).getText().equalsIgnoreCase("Bengaluru(Kempegowda Intl Arpt, BLR),IN")
					|| Allelement.get(i).getText().equalsIgnoreCase("Delhi(Delhi Indira Gandhi Intl, DEL),IN")) {

				Allelement.get(i).click();
			}
		}

		Thread.sleep(1000);
		getWebElement("curio.Departuredate").click();
		Log.info("Click on Date");
		List<WebElement> allDates = getWebElements("curio.alldates");
		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(date1)) {
				ele.click();
				Log.info("Select the Date");
				break;
			}

		}
		Log.info("Clear the endcity");
		getWebElement("curio.Goingtocity").clear();
		getWebElement("curio.Goingtocity").sendKeys(end);
		getWebElement("curio.Goingtocity").sendKeys(end1);
		getWebElement("curio.Goingtocity").sendKeys(end2, Keys.BACK_SPACE);
		getWebElement("curio.Goingtocity").sendKeys(end2, Keys.ARROW_RIGHT, Keys.ENTER);
		Log.info("Enter the endcity");
		List<WebElement> AllCity = getWebElements("curio.endcity");

		int sizecity = AllCity.size();
		for (int i = 0; i < size - 1; i++) {

			if (AllCity.get(i).getText().equalsIgnoreCase("Delhi(Delhi Indira Gandhi Intl, DEL),IN")
					|| AllCity.get(i).getText().equalsIgnoreCase("Bengaluru(Kempegowda Intl Arpt, BLR),IN")
					|| AllCity.get(i).getText().equalsIgnoreCase("Hyderabad(Rajiv Gandhi Intl, HYD),IN")) {
				AllCity.get(i).click();
				break;

			}
		}

	}

	public void searchbutton() throws Exception {
		Log.info("Click on Searchbutton");
		waitelement(getWebElement("curio.searchbutton"));
		if (getWebElement("curio.searchbutton").isDisplayed()) {

			getWebElement("curio.searchbutton").click();
		} else {

		}

	}

	public WebElement successflight() throws Exception {
		waitelement(getWebElement("curio.successflight"));
		return getWebElement("curio.successflight");
	}

	public WebElement fromcityerror() throws Exception {
		return getWebElement("curio.fromcityerror");
	}

	public WebElement tocityerror() throws Exception {
		return getWebElement("curio.tocityerror");
	}

	public void Selectflight() throws Exception {
		Log.info("Select the Filght");
		driver.navigate().refresh();
		WebElement SelectFlight = getWebElement("curio.selectflight");
		if (SelectFlight.isDisplayed()) {
			SelectFlight.click();
			Thread.sleep(1000);
			getWebElement("curio.selectok").click();
		}

	}

}