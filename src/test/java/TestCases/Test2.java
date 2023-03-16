package TestCases;

import BaseComponents.BaseCode;
import org.example.PageObjects.ContactPage;
import org.example.PageObjects.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;
/*
Test case 2:
1. From the home page go to contact page
2. Populate mandatory fields
3. Click submit button

4. Validate successful submission message
Note: Run this test 5 times to ensure 100% pass rate

Can use Faker library to generate test data
 */

@Test(invocationCount = 5)
public class Test2 extends BaseCode {

    public void testCase2() throws InterruptedException, IOException {

        HomePage homepage = launchApplication();
        //from Home go to Contact page
        ContactPage contactpage = homepage.gotoContact();
        //fill in all required field with random values
        contactpage.fillform(contactpage.genRandomName(10), contactpage.genRandomName(10), contactpage.genRandomName(10) + "@gmail.com", contactpage.genRandomPhone(), contactpage.genRandomName(12)+contactpage.genRandomPhone());
        contactpage.submit();
    }
}
