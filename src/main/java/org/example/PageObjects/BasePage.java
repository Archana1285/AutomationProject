package org.example.PageObjects;

import org.example.PageObjects.CartPage;
import org.example.PageObjects.ContactPage;
import org.example.PageObjects.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
public BasePage(WebDriver driver)
{

    this.driver = driver;
    PageFactory.initElements(driver,this);
}

    @FindBy(id="nav-home")
   public WebElement homeButton;
    @FindBy(id="nav-contact")
    public WebElement contactButton;
    @FindBy(id="nav-shop")
    public WebElement shopButton;
    @FindBy(id="nav-cart")
    public WebElement cartButton;

    public void waitForElementVisibility(WebElement locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void gotoHome()
    {
        homeButton.click();
    }
    public void gotoShop()
    {
        shopButton.click();
    }

    public ContactPage gotoContact()
    {
        contactButton.click();
        ContactPage contactpage = new ContactPage(driver);
        return contactpage;
    }

    public CartPage gotoCart()
    {
        cartButton.click();
       CartPage cartpage = new CartPage(driver);
        return cartpage;
    }

    public ShoppingPage gotoShopping()
    {
        shopButton.click();
        ShoppingPage shoppingpage = new ShoppingPage(driver);
        return shoppingpage;

    }
}
