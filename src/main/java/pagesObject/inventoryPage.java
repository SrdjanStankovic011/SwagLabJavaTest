package pagesObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class inventoryPage extends BasePage{
    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;

    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;

    @FindBy (css = "#shopping_cart_container span")
    WebElement cart;

    public inventoryPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String Cart(){
        return cart.getText();
    }
    public void AddBackpack(){
        backpack.click();
    }
    public void AddBikeLight(){
        bikeLight.click();
    }

}
