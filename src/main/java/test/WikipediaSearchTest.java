package test;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.WikipediaHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WikipediaSearchTest extends BaseTest {

    @Test
    public void searchForVillage() {

        WikipediaHomePage home = new WikipediaHomePage(driver);
        home.open();
        home.searchFor("Barchaczów");

        WebElement title = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("mw-page-title-main")));

        assertEquals("Barchaczów", title.getText());
        assertTrue(driver.getCurrentUrl().contains("/wiki/"));
    }
}
