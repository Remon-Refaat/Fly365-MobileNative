package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.TestBase;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PassengerDetailsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By passengerSCTN = By.id("rv_add_passengers");
    By passengerFirstNameTXT = By.id("et_input_f_name");
    By passengerMiddleNameTXT = By.id("et_input_m_name");
    By passengerLastNameTXT = By.id("et_input_l_name");
    By passengerBirthdayTXT = By.id("et_birthday");
    By addPassengerBTN = By.id("btn_add_passenger");

    @And("^Add the following data in the passenger Details$")
    public void addTheFollowingDataInThePassengerDetails(DataTable passengerData) {

        int i = 1;

            for (Map<String,String> passengerDetails : passengerData.asMaps(String.class,String.class)){
                wait.until(ExpectedConditions.visibilityOfElementLocated(passengerSCTN));
                driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView [@resource-id='com.fly365:id/rv_add_passengers']//android.view.ViewGroup["+i+"]")).click();
                driver.findElement(By.id("rb_"+passengerDetails.get("Title").toLowerCase()+"")).click();
                driver.findElement(passengerFirstNameTXT).sendKeys(passengerDetails.get("First Name"));
                driver.findElement(passengerMiddleNameTXT).sendKeys(passengerDetails.get("Middle Name"));
                driver.findElement(passengerLastNameTXT).sendKeys(passengerDetails.get("Last Name"));
                driver.findElement(passengerBirthdayTXT).sendKeys(passengerDetails.get("Birthday"));
                driver.findElement(addPassengerBTN).click();
                i++;
            }


    }




}
