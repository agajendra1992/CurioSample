package pagelib;

import org.openqa.selenium.WebElement;

import log.Log;
import testbase.TestBase;

public class Loginlib extends TestBase {

	public void login(String comp, String userid, String passw) throws Exception {
		Log.info("Clear the Company Field");
		getWebElement("curio.company").clear();
		Log.info("Enter the Company Name");
		getWebElement("curio.company").sendKeys(comp);
		Log.info("Clear the UserId");
		getWebElement("curio.userid").clear();
		Log.info("Enter the userId");
		getWebElement("curio.userid").sendKeys(userid);

		Log.info("Clear the Password");
		getWebElement("curio.password").clear();
		Log.info("Enter the Password");
		getWebElement("curio.password").sendKeys(passw);

	}

	public void loginclick() throws Exception {
		Log.info("Enter the submit button");
		getWebElement("curio.login").click();
	}

	public WebElement curiotitle() throws Exception {
		return getWebElement("curio.title");

	}

	public WebElement successmessage() throws Exception {
		return getWebElement("curio.loginsuccess");
	}

	public void logout() throws Exception {
		Thread.sleep(2000);
		getWebElement("curio.logout").click();
	}
}
