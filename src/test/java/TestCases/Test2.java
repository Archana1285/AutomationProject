package TestCases;

import BaseComponents.BaseCode;
import org.example.PageObjects.ContactPage;
import org.example.PageObjects.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

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
