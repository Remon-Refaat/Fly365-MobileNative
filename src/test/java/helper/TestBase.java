package helper;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AndroidDriver<WebElement> driver;

    @BeforeSuite()
    public void startDriver() throws MalformedURLException {
//        AppiumDriverLocalService service = new AppiumServiceBuilder().usingPort(Integer.valueOf("4723")).withAppiumJS(new File("/Users/remonrefaat/node_modules/appium/build/lib/main.js")).build();
//        service.start();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"OPPO F1s");
        caps.setCapability(MobileCapabilityType.APP,"/Users/remonrefaat/Desktop/app-debug.apk");
        driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);

    }
}
