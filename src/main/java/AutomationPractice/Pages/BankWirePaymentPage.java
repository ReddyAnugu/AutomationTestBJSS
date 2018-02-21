package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankWirePaymentPage extends BasePage {
    public BankWirePaymentPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="h3.page-subheading")
    WebElement bankwireHeading;

    @FindBy(xpath = "//p[@id='cart_navigation']/button")
    WebElement navigateConfirmationPage;

    public Boolean viewBankWirePaymentPageHeader(){
        return bankwireHeading.isDisplayed();
    }
    public void navigateToConfirmationPage(){
        navigateConfirmationPage.click();
    }
}


