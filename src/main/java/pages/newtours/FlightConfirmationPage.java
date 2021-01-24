package pages.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightConfirmationHeader;
    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;
    @FindBy(id = "sign-on")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        this.wait.until(ExpectedConditions
                .visibilityOf(this.flightConfirmationHeader));
        String price = this.prices.get(1).getText();
        this.signOffLink.click();
        return price;
    }


}
