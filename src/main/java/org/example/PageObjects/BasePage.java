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
import java.util.Random;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public String genRandomName(int length)
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }
    public String genRandomPhone()
    {
        Random rand = new Random();
        int n = rand.nextInt((int)Math.pow(10, 10));
        String number = String.format("%010d", n);
        return number;
    }
}
