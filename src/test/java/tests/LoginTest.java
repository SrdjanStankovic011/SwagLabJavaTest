package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.StringParm;
import pagesObject.loginPage;

public class LoginTest extends BaseTest{

    ChromeDriver driver;

    loginPage login;

    @BeforeMethod
    public void SetUp (){
        driver=openWebDriver();
        login = new loginPage(driver);
    }

    @Test
    public void loginWithValidData(){
        login.Login(StringParm.VALID_USERNAME, StringParm.VALID_PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginWithNoValidData(){
        login.Login(StringParm.NOT_VALID_USERNAME, StringParm.VALID_PASSWORD);
        Assert.assertEquals(loginPage.getTestMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void After (){
        driver.quit();
    }


}
