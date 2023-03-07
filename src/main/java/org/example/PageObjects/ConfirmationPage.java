package org.example.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //find number of rows displayed
    //each row, multiply price and qty and see if it matches subtotal
    //add all row subtotal and see if it matches Total
    //validate each row price in cart page and see if it matches price in shop page


}

