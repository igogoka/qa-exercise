package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

	@FindBy(id = "CybotCookiebotDialogBodyButtonAccept")
	private WebElement accept_cookies_btn;

	@FindBy(className = "icon-menu")
	private WebElement icon_menu;

	@FindBy(css= ".site-nav__menu__primary > li:nth-child(3) > button")
	private WebElement partners;

	@FindBy(linkText = "Offices")
	private WebElement offices;

	@FindBy(css = "a.button--primary-hollow[data-om-navcta='Partners']")
	private WebElement our_partners;

    public void checkPage() {
        driver.getCurrentUrl().equals("https://www.valtech.com/en-gb/");
    }

    public void acceptCookies() {
        accept_cookies_btn.click();
    }

    public void openMenu() {
        waitForElement(icon_menu);
        icon_menu.click();
    }

    public void isDisplayed() {
        partners.isDisplayed();
    }

    public void clickPartners() {
        waitForElement(partners);
        partners.click();
    }

    public void openOurPartners() {
        waitForElement(our_partners);
        our_partners.click();
    }

}
