package CursoAppium_CTAppium.core;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
	}
	
	private static void createDriver() {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulador-5454");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    //desiredCapabilities.setCapability("appPackage", "com.ctappium");
	    //desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Adm\\eclipse-workspace\\CursoAppium_CTAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    
	    try {
			driver = new AndroidDriver<MobileElement> (new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Aberto aplicativo CT Appium.");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		driver = null;
	}
}
