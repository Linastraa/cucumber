package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    private WebDriver driver;

    @Given("user goes to the {string}")
    public void userGoesTo(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Then("user waits for {int} seconds")
    public void userWaitsForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

    @And("verifies that the page title contains the word {string}")
    public void verifiesPageTitleContainsWord(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assertions.assertTrue( actualTitle.contains(expectedTitle));
    }

    @And("closes the page")
    public void closesThePage() {
            driver.quit();
    }

}
