package pages.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistartionConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(text(),'sign-in')]")
    private WebElement signInLink;
    @FindBy(id = "flight-link")
    private WebElement flightsLink;

    public RegistartionConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.signInLink));
        this.flightsLink.click();
    }
}
