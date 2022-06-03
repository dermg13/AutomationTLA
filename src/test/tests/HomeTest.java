package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.SeleniumUtils;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void localSetUp(){
        homePage = new HomePage(getDriver());
    }

    @DataProvider (name = "links title")
    public Object[][] data1() {
        Object[][] data1 = new Object[3][2];

        return data1;
    }

    @Test(testName = "Verify all links on the homepage of the app")
    public void  test01(){
        System.out.println(getDriver().getTitle());
    }

    @Test (testName = "Verify title of the page is 'User DB'")
    public void test02(){
        homePage.click(homePage.userMtgBtn);
        homePage.click(homePage.accessDB);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(),extentManager);

        Assert.assertEquals(actualTitle, "User DB");
    }

    }
