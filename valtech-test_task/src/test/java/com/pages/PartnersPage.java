package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PartnersPage extends BasePage {
    public PartnersPage(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath = "//h1[text()='Our Partners']")
	private WebElement title;

	@FindBy(css=".partners-block__logo")
	private List<WebElement> partners;



    public void checkPage() {
        driver.getCurrentUrl().equals("https://www.valtech.com/en-gb/partners/");
    }

    public void printPartners() {
        for (WebElement partner : partners) {
            System.out.println(partner.getAttribute("href"));
        }
    }

}
