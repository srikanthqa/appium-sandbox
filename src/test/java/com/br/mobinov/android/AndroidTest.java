package com.br.mobinov.android;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.br.mobinov.config.MobileProperty;
import com.br.mobinov.config.MobileProperty.DevicePlatform;


public class AndroidTest {

	private static final int SIXTY_SECONDS = 60;
	private static final String APPIUM_SERVER = "http://127.0.0.1:4723/wd/hub/";

	private AppiumDriver appiumDriver;

	@Before
	public void setup() throws IOException{
		DesiredCapabilities capabilities = new MobileProperty(DevicePlatform.ANDROID).buildCapabilities();
		appiumDriver = createAppiumDriver(capabilities);
	}
	
	@After
	public void closeSession(){
	//	appiumDriver.closeApp();
	//	appiumDriver.close(); 
	//	appiumDriver.quit();
	}

	@Test
	public void testHelloAndroid() throws MalformedURLException, InterruptedException {
		appiumDriver.manage().timeouts().implicitlyWait(SIXTY_SECONDS, TimeUnit.SECONDS);
	}

	private AppiumDriver createAppiumDriver(DesiredCapabilities capabilities)
			throws MalformedURLException {
		URL appiumServerURL = new URL(APPIUM_SERVER);
		AppiumDriver appiumDriver = new AppiumDriver(appiumServerURL, capabilities);
		return appiumDriver;
	}
}