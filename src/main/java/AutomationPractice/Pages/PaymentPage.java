package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
    public PaymentPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".page-heading")
    WebElement paymentHeader;

    @FindBy(css="a.bankwire")
    WebElement payByBankWire;

    public Boolean viewPaymentHeader(){
        return paymentHeader.isDisplayed();
    }

    public void selectPayByBankWire(){
        payByBankWire.click();
    }

}
