package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDBPage;
import utils.ConfigReader;
import utils.SeleniumUtils;

public class UserDBTest extends BaseTest {
    UserDBPage userDBPage;

    @BeforeMethod
    public void localSetUp() {
        userDBPage = new UserDBPage(getDriver());
    }

    @Test(testName = "Add a new user to the User-Mgt page, Submit a table to add to the Database, and verify the user was added to DB")
    public void test01() {
        userDBPage.click(userDBPage.userMtgBtn);
        userDBPage.click(userDBPage.accessDB);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(),extentManager);

        Assert.assertEquals(actualTitle, "User DB");

        userDBPage.userInfo();

    }
}
