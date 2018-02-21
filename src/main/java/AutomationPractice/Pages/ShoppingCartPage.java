package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="h1.page-heading")
    WebElement shoppingCartHeading;

    @FindBy(xpath = "//a[text()='Color : Black, Size : M']")
    WebElement blouseSize;

    @FindBy(xpath = "//a[text()='Color : Yellow, Size : S']")
    WebElement chiffonDressSize;

    @FindBy(xpath = "//*[@id='product_price_2_9_53183']/span")
    WebElement blousePrice;

    @FindBy(xpath = "//*[@id='product_price_7_34_53183']/span[1]")
    WebElement chiffonPrice;

    @FindBy(linkText = "Proceed to checkout")
    WebElement shoppingCartProceedToCheckout;

    @FindBy(id="total_shipping")
    WebElement tShipping;

    @FindBy(xpath = "//td[@id='total_price_container']")
    WebElement total;

    @FindBy(xpath = "//td[@id='total_product']")
    WebElement actualTotalPdts;

    public Boolean viewShopppingCartHeader(){
        return shoppingCartHeading.isDisplayed();
    }

    public String getBlouseSize(){
       return blouseSize.getText();
    }

    public String getChiffonSize(){
        return chiffonDressSize.getText();
    }

    public Double checkBlousePrice(){
        return Double.parseDouble(blousePrice.getText().replace("$",""));
    }

    public Double checkChiffonDressPrice(){
        return Double.parseDouble(chiffonPrice.getText().replace("$",""));
    }

    public Double expectedTotalProducts(){
        return checkBlousePrice()+checkChiffonDressPrice();
    }

    public Double totalShipping(){
        return Double.parseDouble(tShipping.getText().replace("$",""));
    }

    public Double actualTotalProducts(){
        return Double.parseDouble(actualTotalPdts.getText().replace("$",""));
    }
    public Double totalPriceExpected(){
        return actualTotalProducts()+totalShipping();
    }

    public Double totalPriceActual(){
        return Double.parseDouble(total.getText().replace("$",""));
    }

    public void nvgtToAddressPage(){
        Utils.waitForElementVisible(shoppingCartProceedToCheckout);
        shoppingCartProceedToCheckout.click();
    }

}
