package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helper.GeneralMethods;
import helper.TestBase;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomeTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);
    GeneralMethods gmObject = new GeneralMethods();

    By originTXT = By.id("tv_origin_details");
    By searchFieldTXT = By.id("search_src_text");
    By destinationTXT = By.id("tv_destination_details");
    By selectDateTXT = By.id("tv_date_details");
    By passengerCabinMENU = By.id("tv_passenger_details");
    By plusAdultBTN = By.xpath("//android.widget.RelativeLayout[1]//android.widget.ImageView[2]");
    By plusChildBTN = By.xpath("//android.widget.RelativeLayout[2]//android.widget.ImageView[2]");
    By plusInfantBTN = By.xpath("//android.widget.RelativeLayout[3]//android.widget.ImageView[2]");
    By doneBTN = By.id("searchMTV");
    By cabinClassMENU = By.id("tv_cabin_class_details");
    By searchNowBTN = By.id("searchMTV");



    @Given("^Select \"(.*)\" trip$")
    public void selectOneWayTrip(String oneWayTAB)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchNowBTN));
    driver.findElement(By.xpath("//*[@content-desc='"+oneWayTAB+"']")).click();
    }

    @And("^Add airport to the Origin \"(.*)\"$")
    public void addAirportToTheOrigin(String originAirport) {
        By airportSearchResult = By.xpath("//android.widget.TextView[@text='"+originAirport+"']");
        driver.findElement(originTXT).click();
        driver.findElement(searchFieldTXT).sendKeys(originAirport);
        wait.until(ExpectedConditions.visibilityOfElementLocated(airportSearchResult));
        driver.findElement(airportSearchResult).click();
    }

    @And("^Add airport to the Destination \"(.*)\"$")
    public void addAirportToTheDestination(String destinationAirport)  {
        By airportSearchResult = By.xpath("//android.widget.TextView[@text='"+destinationAirport+"']");
        driver.findElement(destinationTXT).click();
        driver.findElement(searchFieldTXT).sendKeys(destinationAirport);
        wait.until(ExpectedConditions.visibilityOfElementLocated(airportSearchResult));
        driver.findElement(airportSearchResult).click();
    }

    @And("^Select the date of the departure, after \"(.*)\" day from today$")
    public void selectTheDateOfTheDepartureAfterDayFromToday(int period) throws InterruptedException {
        String returnDate = gmObject.addDateWithCertainPeriodAndFormat(period, "dd MMMM yyyy");
        String year = returnDate.replaceAll("\\A\\d\\d\\s","");
        String day = returnDate.replaceAll("\\s\\w*\\s\\d*\\z","");
        driver.findElement(selectDateTXT).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchNowBTN));
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+year+"']//following-sibling::androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@text='"+day+"']")).click();
        driver.findElement(searchNowBTN).click();

    }




    @And("^Select Passengers: \"(.*)\" adult, \"(.*)\" child, \"(.*)\" infant$")
    public void selectPassengersAdultChildInfant(int adultCount, int childCount, int infantCount)  {

        driver.findElement(passengerCabinMENU).click();

        for (int counter = 0; counter < (adultCount - 1); counter++) {
            driver.findElement(plusAdultBTN).click();
        }

        for (int counter = 0; counter < childCount; counter++) {
            driver.findElement(plusChildBTN).click();
        }

        for (int counter = 0; counter < infantCount; counter++) {
            driver.findElement(plusInfantBTN).click();
        }

        driver.findElement(doneBTN).click();

    }


    @And("^Select \"(.*)\" Class$")
    public void selectClass(String cabinClass)  {
        driver.findElement(cabinClassMENU).click();
        driver.findElement(By.id("button_"+cabinClass.toLowerCase()+"")).click();

    }


    @And("^Press on Search Now$")
    public void pressOnSearchNow() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchNowBTN));
        driver.findElement(searchNowBTN).click();
//        Thread.sleep(5000);
    }
}
