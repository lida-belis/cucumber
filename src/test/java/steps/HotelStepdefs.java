package steps;

import base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SearchPage;
import pages.SearchResultsPage;
import utils.Waiters;

public class HotelStepdefs extends BaseUtil {
    private BaseUtil baseUtil;
    private By HOTELNAME = By.xpath("//span[contains(text(),'Kimpton Vividora Hotel')]");

    public HotelStepdefs(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Given("browser is started")
    public void browserIsStarted() {
        DriverManagerType driverManagerType = DriverManagerType.CHROME;
        WebDriverManager.getInstance(driverManagerType).setup();
        baseUtil.driver = new ChromeDriver();
    }

    @When("search page is opened")
    public void searchPageIsOpened() {
        baseUtil.driver.get("https://www.booking.com/");
    }

    @Then("search button is displayed")
    public void searchButtonIsDisplayed() {
        SearchPage searchPage = new SearchPage(baseUtil.driver);
        Assert.assertTrue(searchPage.getSearchButton().isDisplayed());
    }

    @When("find {string} and click button")
    public void findAndClickButton(String hotelName) {
        SearchPage searchPage = new SearchPage(baseUtil.driver);
        searchPage.search(hotelName);
    }

    @Then("name {string} is displayed")
    public void nameIsDisplayed(String hotelName) {
        Waiters waiters = new Waiters(baseUtil.driver);
        waiters.waitForVisibility(HOTELNAME);
        SearchResultsPage resultsPage = new SearchResultsPage(baseUtil.driver);
        Assert.assertEquals(resultsPage.getHotelNameText(), hotelName);
    }

    @Then("score {string} is displayed")
    public void scoreIsDisplayed(String score) {
        SearchResultsPage resultsPage = new SearchResultsPage(baseUtil.driver);
        Assert.assertEquals(resultsPage.getScoreText(), score);
    }
}
