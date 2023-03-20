package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
        WebDriver driver;
        public HomePage(WebDriver driver) {
           // super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

    @FindBy(xpath = "//button[@class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']//*[name()='svg']")
    public WebElement signInButton;
    @FindBy(xpath = "//span[@class='label-TZ2SJ2fG label-RhC5uhZw label-TZ2SJ2fG label-K12_SJ0T js-main-menu-dropdown-link-title']")
    public WebElement signInLink;



        public void launchPage() {
            driver.get("https://www.tradingview.com/");

        }
    public LoginPage clickSignIn()
    {
        signInButton.click();
        signInLink.click();
       // loginpage = new LoginPage(driver);
        return new LoginPage(driver);
    }

    }


