package testscript;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelread.Dataprovider;
import log.Log;
import pagelib.Loginlib;
import testbase.TestBase;

public class Loginscript extends TestBase {
	@BeforeTest
	public void launchcurio() throws IOException {
		Log.startTestCase("Curio_Test_002");

		launch();
	}

	@Test(dataProvider = "login", dataProviderClass = Dataprovider.class)
	public void vlogin(String com, String uid, String pass, String Inputtype, String Expected) throws Exception {

		new Loginlib().login(com, uid, pass);
		new Loginlib().loginclick();

		try {
			if (Inputtype.contains("N")) {

				if (Expected.trim().contains(new Loginlib().curiotitle().getText().trim())) {

					Log.info("Negative Login Test Cases Pass");
				} else

				{
				}

			} else {

			}
			if (Expected.trim().contains(new Loginlib().successmessage().getText().trim())) {
				driver.navigate().refresh();
				Log.info("Positive Login Test Cases Pass");
				Log.endTestCase("Curio_Test_002");
			} else {

			}
		} catch (Exception e) {

		}

	}

	@AfterTest
	public void closeall() throws Exception {
		Log.info("Logout the Curio");
		new Loginlib().logout();

	}

	@AfterSuite
	public void closebrows() {
		Log.info("Close Browser");
		driver.close();
	}
}
