package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.inventoryPage;
import pagesObject.loginPage;

public class InventoryTest extends BaseTest{
    ChromeDriver driver;
    loginPage loginPage;
    inventoryPage inventoryPage;


    @BeforeMethod
    public void Before(){
        driver = openWebDriver();
        loginPage = new loginPage(driver);
        inventoryPage = new inventoryPage(driver);
    }

    @Test
    public void Buy2Products(){
        loginPage.Login("standard_user", "secret_sauce");
        inventoryPage.AddBackpack();
        inventoryPage.AddBikeLight();
        Assert.assertEquals(inventoryPage.Cart(), "2");
        }

    @AfterMethod
    public void After(){
        driver.quit();
    }

}
