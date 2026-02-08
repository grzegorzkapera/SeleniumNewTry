package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikipediaHomePage extends BasePage {

    private By searchInput = By.id("searchInput");

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.wikipedia.org");
    }

    public void searchFor(String text) {
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);
    }
}
