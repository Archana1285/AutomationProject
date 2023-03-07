package TestCases;

import BaseComponents.BaseCode;
import org.example.PageObjects.ContactPage;
import org.example.PageObjects.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

@Test(invocationCount = 2)
public class Test2 extends BaseCode {

    public void testCase2() throws InterruptedException, IOException {

        HomePage homepage = launchApplication();
        //from Home go to Contact page
        ContactPage contactpage = homepage.gotoContact();
        //fill in all required field
        contactpage.fillform("Tester1", "Test", "test@gmail.com", "42224242", "test123");
        contactpage.submit();
    }
}
