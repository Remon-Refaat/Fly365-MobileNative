package helper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks extends TestBase {

//    @After
//    public void resetApp() {
//        driver.resetApp();
//    }

    @After
    public void takeScreenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()){

            File scrFile = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Screenshots/"+scenario.getName()+".jpg"));
        }
    }
}
