package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import static java.lang.Thread.sleep;

public class CartPage extends BasePage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //find number of rows displayed
    //each row, multiply price and qty and see if it matches subtotal
    //add all row subtotal and see if it matches Total
    //validate each row price in cart page and see if it matches price in shop page
    @FindBy(xpath = "//table[@class='table table-striped cart-items']")
    WebElement table;
    @FindBy(css = ".total.ng-binding")
    WebElement expTotal;
    public float total = 0;
    DecimalFormat df = new DecimalFormat("#.00");

    public void Validatetotal() throws InterruptedException {
        List<WebElement> rows = table.findElements(By.xpath("//tbody//tr[@class='cart-item ng-scope']"));
        for (WebElement row : rows) {
            // Find the cells in the row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            //Get the values and discard the $ and covert to integer
            // Get the values from column 3 and 4 and multiply them
            String val1 = cells.get(1).getText();
            val1 = val1.substring(1);
            float value1 = Float.parseFloat(val1);
            String val2 = cells.get(2).findElement(By.tagName("input")).getAttribute("value");
            float value2 = Float.parseFloat(val2);
            float result = Float.valueOf(df.format(value1 * value2));

            // Get the value from column 5
            String val3 = cells.get(3).getText().substring(1);
            float expectedValue = Float.parseFloat(val3);
            // Validate that the result matches the expected value
            Assert.assertEquals(result,expectedValue,0.00);
            total += result;
        }

        //Round off the total field to 1 decimal

        total = Float.valueOf(df.format(total));
        //Fetch the Actual total from Cart Page, split to get the total amount (e.g.,"Total: $434.4" -> 434.4) only and convert to float
        String val4 = expTotal.getText().substring(7);
        Float expectedTotal = Float.parseFloat(val4);
        Assert.assertEquals(total,expectedTotal,0.00);
    }
}

