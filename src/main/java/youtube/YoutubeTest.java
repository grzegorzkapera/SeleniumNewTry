package youtube;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class YoutubeTest{

    WebDriver driver;

    @BeforeEach
    public void acceptCookies() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // <-- maksymalizujemy okno
        driver.get("https://www.youtube.com");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
        try {
            // Szukamy przycisku cookies po klasie CSS
            List<WebElement> cookiesButtons = driver.findElements(
                    By.cssSelector(".yt-spec-touch-feedback-shape__fill")
            );

            if (!cookiesButtons.isEmpty()) {
                WebElement accept = cookiesButtons.get(0);

                // Kliknięcie przez JS (omija problemy z widocznością)
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", accept);

                System.out.println("Kliknięto 'Accept all' przez JS.");
            } else {
                System.out.println("Przycisk cookies nie został znaleziony.");
            }

        } catch (Exception e) {
            System.out.println("Błąd podczas klikania w przycisk: " + e.getMessage());
        }

        driver.quit();
    }
}
