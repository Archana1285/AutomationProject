package TestCases;

import BaseComponents.BaseCode;
import org.example.PageObjects.CartPage;
import org.example.PageObjects.HomePage;
import org.example.PageObjects.ShoppingPage;
import org.testng.annotations.Test;

import java.io.IOException;
/*
Test case 3:
Buy 2Stuffed Frog,5Fluffy Bunny, 3Valentine Bear
Go to the cart page
Verify the subtotal for each product is correct
Verify the price for each product
Verify that total = sum(sub totals)
 */
@Test
public class Test3 extends BaseCode {

    public void testCase3() throws IOException, InterruptedException {

        HomePage homepage = launchApplication();
        ShoppingPage shoppingpage = homepage.gotoShopping();
        shoppingpage.buyItems("Stuffed Frog", 2);
        shoppingpage.buyItems("Fluffy Bunny", 5);
        shoppingpage.buyItems("Valentine Bear", 3);
        CartPage cartpage = shoppingpage.gotoCart();
        cartpage.Validatetotal();
    }
}
