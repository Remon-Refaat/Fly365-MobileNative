package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.TestBase;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PassengersTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By passengerSCTN = By.id("rv_add_passengers");
    By contactFirstNameTXT = By.id("et_contact_first_name");
    By contactLastNameTXT = By.id("et_contact_family_name");
    By contactEmailAddressTXT = By.id("et_contact_email");
    By phoneNumberTXT = By.id("et_contact_phone");
    By continueBTN = By.id("btn_continue");

    @And("^Add the following data in the Contact Details$")
    public void addTheFollowingDataInTheContactDetails(DataTable contactData)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerSCTN));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"Mr\"));"));
        for (Map<String,String> contactDetails : contactData.asMaps(String.class,String.class)){
            driver.findElement(By.id("rb_"+contactDetails.get("Title").toLowerCase()+"")).click();
            driver.findElement(contactFirstNameTXT).sendKeys(contactDetails.get("First Name"));
            driver.findElement(contactLastNameTXT).sendKeys(contactDetails.get("Last Name"));
            driver.findElement(contactEmailAddressTXT).sendKeys(contactDetails.get("Email"));
            driver.findElement(phoneNumberTXT).sendKeys(contactDetails.get("Phone Number"));
        }
    }

    @And("^Click on CONTINUE$")
    public void clickOnCONTINUE() throws InterruptedException {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"CONTINUE\"));"));
        driver.findElement(continueBTN).click();
        Thread.sleep(3000);
    }
}
