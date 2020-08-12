package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;

    private By SEARCHWINDOW = By.id("ss");
    private By SEARCHBUTTON = By.cssSelector(".sb-searchbox__button ");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchWindow() {
        return driver.findElement(SEARCHWINDOW);
    }

    public WebElement getSearchButton() {
        return driver.findElement(SEARCHBUTTON);
    }

    public void search(String hotelName) {
        getSearchWindow().sendKeys(hotelName);
        getSearchButton().click();
    }
}
