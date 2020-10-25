package com.steps;

import com.pages.HomePage;
import com.pages.OfficesPage;
import com.pages.PartnersPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class NavigationSteps {
    private HomePage homePage;
    private PartnersPage partnersPage;
    private OfficesPage officesPage;

    WebDriver driver;
    private final String browser = (System.getProperty("browser") == null) ? "chrome" : System.getProperty("browser");

    @Before
    public void browserSetup() {

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.valtech.com/en-gb/");
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
    }

    @Given("I am on home page")
    public void i_am_on_home_page() {
        homePage = new HomePage(driver);
        homePage.checkPage();
        homePage.acceptCookies();
    }

    @When("I click on menu")
    public void i_click_on_menu() {
        homePage.openMenu();
    }

    @And("I click on partners")
    public void i_click_on_partners() {
        homePage.clickPartners();
    }

    @Then("I see partners section")
    public void i_see_partners_section() {
        homePage.isDisplayed();
    }

    @When("I click on Our Partners")
    public void i_click_on() {
        homePage.openOurPartners();
    }

    @Then("I am on partners page")
    public void i_am_on_partners_page() {
        partnersPage = new PartnersPage(driver);
        partnersPage.checkPage();
    }

    @Then("I capture and print a list of all partners")
    public void i_capture_and_print_a_list_of_all_partners() {
        System.out.println("Links of partners:");
        partnersPage.printPartners();
    }

}
