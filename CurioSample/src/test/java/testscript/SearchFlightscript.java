package testscript;

import org.testng.annotations.Test;

import excelread.Dataprovider;
import log.Log;
import pagelib.Loginlib;
import pagelib.SearchFlight;
import testbase.TestBase;

public class SearchFlightscript extends TestBase {

	@Test(dataProvider = "SearchFlight1", dataProviderClass = Dataprovider.class)
	public void FlightSearch(String scity, String scity1, String scity2, String send, String send1, String send2,
			String date2, String InputType, String Expected) throws Exception {
		Log.startTestCase("Curio_Test_003");
		new SearchFlight().SFlight(scity, scity1, scity2, send, send1, send2, date2);
		Thread.sleep(2000);
		new SearchFlight().searchbutton();
		waitlimit(10);

		try {
			if (InputType.contains("N")) {

				driver.navigate().refresh();
				if (Expected.trim().contains(new SearchFlight().fromcityerror().getText().trim())
						|| Expected.trim().contains(new SearchFlight().tocityerror().getText().trim())) {

					Log.info("Negative Search Flight Test Cases Pass");

				} else

				{
				}

			}

			if (Expected.trim().contains(new SearchFlight().successflight().getText().trim())) {
				new SearchFlight().Selectflight();
				Thread.sleep(5000);
				Log.info("Positve Search Flight Test Cases Pass");
				Log.endTestCase("Curio_Test_003");

			} else {
			}
		} catch (Exception e) {

		}

	}
}
