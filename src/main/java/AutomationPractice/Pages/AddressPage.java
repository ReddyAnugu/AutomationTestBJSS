package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage {

public AddressPage(){
    PageFactory.initElements(driver,this);
}

    @FindBy(css="h1.page-heading")
    WebElement addressHeader;

    @FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
    WebElement addressProceedToCheckout;


    public Boolean viewAddressHeader(){
        return addressHeader.isDisplayed();
    }

    public void navigateToShippingPage(){
        Utils.waitForElementVisible(addressProceedToCheckout);
        addressProceedToCheckout.click();
    }
}
