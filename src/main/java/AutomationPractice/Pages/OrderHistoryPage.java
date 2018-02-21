package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderHistoryPage extends BasePage {
    public OrderHistoryPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[text()='Order history']")
    WebElement orderHistoryHeader;

    @FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[1]/a")
    WebElement selectFirstOrder;

    @FindBy(xpath="//table[@id='order-list']/tbody/tr[1]/td[2]")
    WebElement orderDate;

    @FindBy(css="select.form-control")
    WebElement selectProduct;

    @FindBy(css="textarea.form-control")
    WebElement commentBox;

    @FindBy(css="button.button.btn.btn-default.button-medium")
    WebElement sendButton;

    @FindBy(xpath = "//*[@id='block-order-detail']/div[5]/table/tbody/tr/td[2]")
    WebElement message;

    @FindBy(xpath = "//div[@id=\"order-detail-content\"]/table/tbody/tr[1]/td[2]/label")
    WebElement blouseColor;

    @FindBy(css="a.logout")
    WebElement signout;

    @FindBy(css="a.login")
    WebElement signIn;

    public Boolean viewOrderHistoryHeader(){
        return orderHistoryHeader.isDisplayed();
    }
    public void selectFrstOrder(){
        selectFirstOrder.click();
    }
    public String viewOrderDate(){

        return orderDate.getText();

    }
    public String currentDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
    public void selectProdOrder(String prd ){
        Utils.waitForElementVisible(selectProduct);
        Utils.selectByVisibleText(selectProduct,prd);
    }

    public void addComment(){
        commentBox.sendKeys("Wrong item delivered");
    }

    public void submitComment(){
        sendButton.click();
    }

    public Boolean confirmMessage(){
        Utils.waitForElementVisible(message);
        return message.isDisplayed();
    }

    public String viewDressColor(){
        Utils.waitForElementVisible(blouseColor);
        return blouseColor.getText();
    }
    public void signOut(){
        signout.click();
    }
    public Boolean isSignInDisplayed(){
        return signIn.isDisplayed();
    }
}
