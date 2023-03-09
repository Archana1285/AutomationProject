package TestCases;

import BaseComponents.BaseCode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.PageObjects.ContactPage;
import org.example.PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static java.lang.Thread.sleep;

@Test
public class Test1 extends BaseCode {

    public void testCase1() throws InterruptedException, IOException {

        HomePage homepage = launchApplication();
        //from Home go to Contact page
        ContactPage contactpage = homepage.gotoContact();
        contactpage.fillform("Arch", "", "test@gmail.com", "42224242", "");
        //Submit contact page without any values
        contactpage.submit();
        //fill in all required field
        contactpage.fillform("Tester1", "Test", "test@gmail.com", "42224242", "test123");
        contactpage.mandatoryCheck();


    }
}
