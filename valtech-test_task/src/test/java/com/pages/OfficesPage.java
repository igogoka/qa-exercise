package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class OfficesPage extends BasePage {

    public OfficesPage(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath ="//h3[text() = 'United Kingdom']")
	private WebElement unitedKingdom;

	@FindBy(xpath = "//h3[text() = 'United Kingdom']/../..//address")
	private List<WebElement> ukOffices;


    public void ckickUnitedKingdom() {
        waitForElement(unitedKingdom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", unitedKingdom);
        Actions act = new Actions(driver);
        act.moveToElement(unitedKingdom).click().perform();
    }

    public void verifyNumbersOfOffices() {
        Assert.assertEquals(ukOffices.size(), 3);
    }

    public void printUkOffices() {
        System.out.println("UK offices:");
        for (WebElement office : ukOffices) {
            System.out.println(office.getText() + "\n");
        }
    }

}
