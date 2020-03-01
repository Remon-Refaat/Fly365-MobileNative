package helper;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AndroidDriver<WebElement> driver;
//    public static IOSDriver<WebElement> driver;

    AppiumDriverLocalService service = new AppiumServiceBuilder().usingPort(Integer.valueOf("4723")).withAppiumJS(new File("/Users/remonrefaat/node_modules/appium/build/lib/main.js")).build();

    @BeforeSuite()
    public void startDriver() throws MalformedURLException {
////        service.start();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3 XL");
        String appPath = System.getProperty("user.dir")+"/Application/app-debug.apk";
        caps.setCapability(MobileCapabilityType.APP,appPath);
        driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);


//        caps.setCapability("platformName","iOS");
//        caps.setCapability("platformVersion","12.1.2");
//        caps.setCapability("deviceName","Fly365");
//        caps.setCapability("udid","caeef49438b2e3cc68621b690eead8eaa0c39470");
//        caps.setCapability("xcodeOrgId", "MPMFPA7DGZ");
//        caps.setCapability("xcodeSigningId", "iPhone Developer");
//        caps.setCapability("app","/Users/remonrefaat/Desktop/Fly365.ipa");
//        IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);

    }

    @AfterSuite()
    public void stopDriver() {
        driver.quit();
//        service.stop();
    }
}
