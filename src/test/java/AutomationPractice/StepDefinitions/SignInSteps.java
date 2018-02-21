package AutomationPractice.StepDefinitions;

import AutomationPractice.Pages.HomePage;
import AutomationPractice.Pages.MyAccountPage;
import AutomationPractice.Pages.SignInPage;
import AutomationPractice.Utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static AutomationPractice.Pages.BasePage.driver;

public class SignInSteps {
    @Before
    public void setUp(){
    BrowserFactory.startBrowser();
    }
    @After
    public void cleanUp(){
    BrowserFactory.stopBrowser();
    }

    public HomePage homePage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;

    @Given("^User is on the home page$")
    public void verifyIsUserOnTheHomePage(){
        homePage=new HomePage();
        Assert.assertTrue(homePage.getTitle().equalsIgnoreCase("My Store"));
    }
    @When("^User selects SignIn link$")
    public void user_selects_SignIn_link() {
        homePage.navigateToSignPage();
    }

    @Then("^User should see the Login Page$")
    public void user_should_see_the_Login_Page() {
        signInPage=new SignInPage();
        Assert.assertTrue(signInPage.isUserOnLoginPage());

    }

    @When("^User enter email  as \"([^\"]*)\" password as \"([^\"]*)\" and select Signin button$")
    public void user_enter_email_as_password_as_and_select_Signin_button(String email, String password) {
        signInPage.setEmailPasswordAndSubmit(email,password);
    }

    @Then("^User should see his name as \"([^\"]*)\"$")
    public void user_should_see_his_name_as(String userName) {
        myAccountPage=new MyAccountPage();
        String accountName = myAccountPage.getAccountName();
        Assert.assertEquals(userName, accountName );
    }

    @When("^user selects home button$")
    public void user_selects_home_button() {
        myAccountPage.navigateToHomePage();
    }


}
