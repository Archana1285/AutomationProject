package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingPage extends BasePage {

    WebDriver driver;

    public ShoppingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    /*@FindBy(xpath = "//li[@id='product-2']//a[@class='btn btn-success']")
    WebElement StuffedFrog;
    @FindBy(xpath = "//li[@id='product-4']//a[@class='btn btn-success']")
    WebElement FluffyBunny;
    @FindBy(xpath = "//li[@id='product-7']//a[@class='btn btn-success']")
    WebElement ValentineBear;*/

    public void buyItems(String Buyitem, int count) {

        List<WebElement> items = driver.findElements(By.xpath("//li[@class='product ng-scope']"));
        WebElement shopit = items.stream().filter(item -> item.findElement(By.cssSelector("h4")).getText().equals(Buyitem)).findFirst().orElse(null);
        while (count > 0) {
            shopit.findElement(By.cssSelector("a")).click();
            count--;
        }



   /* public void Buy(String item, int count) {
        if (item == "StuffedFrog") {
            while (count > 0) {
                StuffedFrog.click();
                count--;
            }
        } else if (item == "FluffyBunny") {
            while (count > 0) {
                FluffyBunny.click();
                count--;
            }
        } else if (item == "ValentineBear") {
            while (count > 0) {
                ValentineBear.click();
                count--;
            }
        }*/


    }
}


