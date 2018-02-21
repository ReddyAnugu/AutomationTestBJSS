package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="a.login")
    WebElement signInLink;

    @FindBy(xpath="//ul[@id='homefeatured']/li[2]/div/div[1]/div/a[1]/img")
    WebElement blouseItem;

    @FindBy(xpath = "//body[@id='product']/div/div/div[2]/h1")
    WebElement blouseHeader;

    @FindBy(id="group_1")
    WebElement size;

    @FindBy(xpath ="//p[@id='add_to_cart']/button/span")
    WebElement blouseAddToCart;

    @FindBy(css="iframe.fancybox-iframe")
    WebElement iframe;

    @FindBy(xpath = "//div[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[7]/div/div[1]/div/a[1]/img")
    WebElement chiffonDress;

    @FindBy(css="button.exclusive")
    WebElement addToCartChiffonDress;

    @FindBy(xpath = "//div[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckoutChiffonDress;

    @FindBy(xpath = "//h1[text()='Printed Chiffon Dress']")
    WebElement chiffonDressHeader;

    @FindBy(xpath = "//a[@title='My orders']")
    WebElement viewOrders;



    public void navigateToSignPage(){
        signInLink.click();
    }

    public void viewBlouseItem(){
        Utils.mouseHoverAndClick(blouseItem,blouseItem);
        driver.switchTo().frame(iframe);
    }

    public Boolean isBlouseHeaderDisplayed() {
        Utils.waitForElementVisible(blouseHeader);
        return blouseHeader.isDisplayed();
    }

    public void selectSize(String arg1){
        Utils.selectByVisibleText(size,arg1);
    }

    public void blouseAddToCart(){
        blouseAddToCart.click();
    }

    public void continueShopping(){
        Utils.waitForElementVisible(continueShoppingButton);
        continueShoppingButton.click();
    }

    public void viewChiffonDress(){
        Utils.mouseHoverAndClick(chiffonDress,chiffonDress);
        driver.switchTo().frame(iframe);

    }
    public Boolean viewChiffonDressHeader() {
        Utils.waitForElementVisible(chiffonDressHeader);
        return chiffonDressHeader.isDisplayed();
    }

    public void addChiffonDressToCart(){

        addToCartChiffonDress.click();
    }

    public void proceedToCheckoutChiffon(){
        Utils.waitForElementVisible(proceedToCheckoutChiffonDress);
        proceedToCheckoutChiffonDress.click();
    }

    public void navigateToOrdersPage(){
        viewOrders.click();
    }


}
