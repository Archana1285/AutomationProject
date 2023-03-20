package BaseComp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import PageObjects.GraphPage;
import PageObjects.LoginPage;
import PageObjects.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseFile {

      protected HomePage homepage;
    protected LoginPage loginPage;
    protected SearchPage searchPage;
    protected GraphPage graphPage;


        public WebDriver driver;

        public WebDriver initializeDriver() throws IOException {
            Properties Properties = new Properties();
            FileInputStream fis = new FileInputStream("C://PrabhuStockScreens//src//main//java//Config//GlobalData.properties");
            Properties.load(fis);
            String browserName = Properties.getProperty("browser");

            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");

                driver = new ChromeDriver(chromeOptions);

            } else if (browserName.equalsIgnoreCase("edge")) {
                //Code to invoke Edge driver
            } else if (browserName.equalsIgnoreCase("firefox")) {
                //Code to invoke firefox driver
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            return driver;
        }


        public HomePage launchApplication() throws IOException {
            driver = initializeDriver();
            HomePage homepage = new HomePage(driver);
            homepage.launchPage();
            return homepage;
        }

        @AfterClass(alwaysRun = true)
        public void closeBrowser() {
            driver.quit();
        }

    }

