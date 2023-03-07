package org.example.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Start Shopping »')]")
    WebElement startShopping;
    @FindBy(xpath = "//h1[contains(text(),'Jupiter Toys')]")
    WebElement homeHeader;

    public void launchPage() {
        driver.get("http://jupiter.cloud.planittesting.com");
    }
    /*public boolean ValidateHeader()
    {
        //waitForElementVisibility(HomeButton);
        if (HomeHeader.getText() == "Jupiter Toys")
        {
        System.out.println("Home Page");
            return true;
        }
        return false;
    }*/

}
