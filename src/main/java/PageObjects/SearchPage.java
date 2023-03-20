package PageObjects;

import ExcelUtility.DProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchPage extends LoginPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='tv-header-search-container tv-header-search-container__button tv-header-search-container__button--full js-header-search-button']")
    public WebElement search;
    @FindBy(xpath = "//input[@placeholder='Symbol, eg. AAPL']")
    public WebElement search1;

    @FindBy(xpath = "//button[@id='Indices']")
    public WebElement indices;
    @FindBy(xpath = "//button[@id='Stocks']")
    public WebElement stocks;
    @FindBy(xpath = "//button[@id='Forex']")
    public WebElement forex;
    @FindBy(xpath = "//div[@class='scrollContainer-vWG52QBW']//div[@data-type='index']//em[contains(text(),'BANKNIFTY')]")
    public WebElement bankNiftyGraph;



    public GraphPage searchGraph( )
    {
        //waitForElementVisibility(search);
        search.click();
        search1.click();
        search1.sendKeys("BANKNIFTY");
        bankNiftyGraph.click();
        //GraphPage graphPage = new GraphPage(driver);
        return new GraphPage(driver);

    }

}