package BaseComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseCode {
    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties Properties = new Properties();
        FileInputStream fis = new FileInputStream("C://Automation//ArchAssessment//src//main//java//Configuration//GlobalData.properties");
        Properties.load(fis);
        String browserName = Properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            //Code to invoke Edge driver
        } else if (browserName.equalsIgnoreCase("firefox")) {
            //Code to invoke firefox driver
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeTest(alwaysRun = true)
    public HomePage launchApplication() throws IOException {
        driver = initializeDriver();
        HomePage homepage = new HomePage(driver);
        homepage.launchPage();
        return homepage;
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}