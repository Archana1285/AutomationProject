package PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ExcelUtility.DProvider;

import java.io.File;
import java.io.IOException;

public class GraphPage extends SearchPage {

    WebDriver driver;

    public GraphPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='chart-gui-wrapper']")
    public WebElement resultGraph;


    public void takeScreenShot() throws IOException {
        waitForElementVisibility(resultGraph);
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C://Automation//PrabhuStockScreens//BankNifty.png");
        FileUtils.copyFile(SrcFile, DestFile);
        driver.navigate().back();
    }

}