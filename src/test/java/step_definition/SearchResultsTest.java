package step_definition;

import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By firstTripBTN = By.xpath("//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout");

    @And("^Choose a trip$")
    public void chooseATrip() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstTripBTN));
        driver.findElement(firstTripBTN).click();
    }
}
