package org.example.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactPage extends BasePage {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "forename")
    WebElement foreName;
    @FindBy(id = "surname")
    WebElement surName;
    @FindBy(id = "email")
    WebElement emailId;
    @FindBy(id = "telephone")
    WebElement telephone;
    @FindBy(id = "message")
    WebElement message;
    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    WebElement submit;
    //@FindBy(xpath ="//div[@class='alert alert-error ng-scope']")
    // WebElement AlertError;
    @FindBy(id = "header-message")
    WebElement header;
    @FindBy(xpath = "//*[@required='required']")
    List<WebElement> mandatoryFields;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    WebElement alertSuccess;

    public void submit() throws InterruptedException {
        waitForElementVisibility(submit);
        //MandatoryCheck();
        submit.click();
        mandatoryCheck();

        try {
            waitForElementVisibility(alertSuccess);
            if (alertSuccess.isDisplayed()) {
                System.out.println("Form submitted successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mandatoryCheck() {

        for (WebElement field : mandatoryFields) {
            if (field.getAttribute("value").isEmpty()) {
                System.out.println("Error: " + field.getAttribute("name") + " is a mandatory field and cannot be empty.");

            } else {
                System.out.println(field.getAttribute("name") + " is filled correctly");
            }
        }
    }

    public void fillform(String foreName1, String surName1, String email, String phoneNumber, String msg) {
        foreName.clear();
        foreName.sendKeys(foreName1);
        surName.clear();
        surName.sendKeys(surName1);
        emailId.clear();
        emailId.sendKeys(email);
        telephone.clear();
        telephone.sendKeys(phoneNumber);
        message.clear();
        message.sendKeys(msg);
    }
}

