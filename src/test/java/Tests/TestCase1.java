package Tests;

import BaseComp.BaseFile;
import ExcelUtility.DProvider;
import PageObjects.GraphPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase1 extends BaseFile {

    @Test
    public void testCase1() throws InterruptedException, IOException {

        homepage = launchApplication();
        loginPage = homepage.clickSignIn();
        searchPage = loginPage.signIn();


    }

    @Test(dataProvider = "stockNames", dataProviderClass = DProvider.class)
    public void testCase2(String shareName, String searchName) throws InterruptedException, IOException {

        graphPage = searchPage.searchGraph(shareName,searchName);
        graphPage.takeScreenShot();



    }
}
