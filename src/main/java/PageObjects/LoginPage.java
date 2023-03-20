package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends HomePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//span[contains(text(),'Email')]")
    public WebElement emailOption;
    @FindBy(xpath = "//span[contains(text(),'Username or Email')]//preceding-sibling::input")
    public WebElement userName;
    @FindBy(xpath = "//span[contains(text(),'Password')]//preceding-sibling::input")
    public WebElement pswd;
    @FindBy(xpath = "//span[@class='tv-button__loader']")
    public WebElement signInButton;

    public void waitForElementVisibility(WebElement locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public SearchPage signIn()
    {
        emailOption.click();
        waitForElementVisibility(userName);
        userName.sendKeys("Prabhuchellamuthu2301@gmail.com");
        waitForElementVisibility(pswd);
        pswd.sendKeys("Nidhi@123$");
        signInButton.click();
       // SearchPage searchPage = new SearchPage(driver);
        return new SearchPage(driver);
    }

}
