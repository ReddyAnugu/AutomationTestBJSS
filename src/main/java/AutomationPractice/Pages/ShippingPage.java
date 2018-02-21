package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage {
    public ShippingPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="h1.page-heading")
    WebElement shippingHeader;

    @FindBy(css="#cgv")
    WebElement shippingPageChkBox;

    @FindBy(xpath = "//form[@id='form']/p/button")
    WebElement navigatePaymentPage;

    public Boolean viewShippingHeader(){
        return shippingHeader.isDisplayed();
    }
    public void selectShippingChkBox(){
        shippingPageChkBox.click();
    }
    public void navigateToPaymentPage(){
        navigatePaymentPage.click();
    }
}
