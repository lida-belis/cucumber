package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    private WebDriver driver;

    private By HOTELNAME = By.xpath("//span[contains(text(),'Kimpton Vividora Hotel')]");
    private By SCORE = By.xpath("//span[contains(text(),'Kimpton Vividora Hotel')]" +
            "/ancestor::div[@class='sr_item_content sr_item_content_slider_wrapper ']" +
            "//div[@class='bui-review-score__badge']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHotelName() {
        return driver.findElement(HOTELNAME);
    }

    public WebElement getScore() {
        return driver.findElement(SCORE);
    }

    public String getHotelNameText() {
        return getHotelName().getText();
    }

    public String getScoreText() {
        return getScore().getText();
    }
}
