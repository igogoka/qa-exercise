package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PartnersPage extends BasePage {
    public PartnersPage(WebDriver driver) {
        super(driver);
    }

	@FindBy(css=".partners-block__logo")
	private List<WebElement> partners;



    public void checkPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.valtech.com/en-gb/partners/");
    }

    public void printPartners() {
        for (WebElement partner : partners) {
            System.out.println(partner.getAttribute("href"));
        }
    }

}
