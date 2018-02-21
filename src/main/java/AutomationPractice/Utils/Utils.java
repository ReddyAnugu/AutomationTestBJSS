package AutomationPractice.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Utils extends BrowserFactory {

    //MouseHoverAndClick
    public static void mouseHoverAndClick(WebElement elementToHover,WebElement elementToClick){
        Actions action=new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }
    //Wait for element visible
    public static void waitForElementVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Wait for Element Clickable
    public static void waitForElementClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    //Select
    public static void selectByVisibleText(WebElement element,String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    //For Screenshot
    public static void captureScreenshot( String screenshotName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
            System.out.println("Screenshot taken");

        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot"+ e.getMessage());
        }
    }


}
