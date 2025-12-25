package utilities;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {  //failedtest case variable used to store the "failed testcase" method name

		TakesScreenshot scrShot = (TakesScreenshot) driver;// takescreenshot is an interface which is used to capture the screenshot
		// casting is done here. here moving driver control to interface
		
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);  // scrnshot file> temporary storing of screenshot
		

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// date and time fetched and store to timestamp variable

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory // foldrr creation-> System.getProperty("user.dir") fetches  local system path in which project exist
		//also create an output screenshot folder
		if (!f1.exists()) { // incase if folder is not created
			
		f1.mkdirs(); // mkdirs is a method used to create the folder. This is present on file class
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";

		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);// copying files to final destination from temporary variable scrnshot
		}

}
