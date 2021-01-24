package e2e;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.newtours.*;
import tests.BaseTest;

public class BookFlightTest extends BaseTest {

    private String numberOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numberOfPassengers", "expectedPrice"})
    public void setupParameters(String numberOfPassengers, String expectedPrice) {
        this.numberOfPassengers = numberOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPage() {
        RegistartionConfirmationPage registartionConfirmationPage = new RegistartionConfirmationPage(driver);
        registartionConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(numberOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();

        Assert.assertEquals(actualPrice, expectedPrice);

    }
}
