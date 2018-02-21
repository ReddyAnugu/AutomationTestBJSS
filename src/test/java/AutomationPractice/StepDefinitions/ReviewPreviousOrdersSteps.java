package AutomationPractice.StepDefinitions;

import AutomationPractice.Pages.HomePage;
import AutomationPractice.Pages.OrderHistoryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ReviewPreviousOrdersSteps {

   // *********************TEST 2: REVIEW PREVIOUS ORDERS AND ADD A MESSAGE********************

    public HomePage homePage;
    public OrderHistoryPage orderHistoryPage;

    @When("^user selects my orders$")
    public void user_selects_my_orders() {
    homePage=new HomePage();
    homePage.navigateToOrdersPage();
    }

    @Then("^user should navigate to order history page$")
    public void user_should_navigate_to_order_history_page(){
    orderHistoryPage=new OrderHistoryPage();
    orderHistoryPage.viewOrderHistoryHeader();
    }

    @When("^user select placed order$")
    public void user_select_placed_order() {
    orderHistoryPage.selectFrstOrder();
    }

    @Then("^user should see the date of order placed$")
    public void user_should_see_the_date_of_order_placed() {
        Assert.assertTrue(orderHistoryPage.viewOrderDate().contains(orderHistoryPage.currentDate()));
    }

    @When("^user select product from previous order as \"([^\"]*)\"$")
    public void user_select_product_from_previous_order_as_something(String order){
       orderHistoryPage.selectProdOrder(order);
    }
    @When("^user add comment about order$")
    public void user_add_comment_about_order() {
    orderHistoryPage.addComment();

    }

    @When("^user submit comment$")
    public void user_submit_comment() {
        orderHistoryPage.submitComment();
    }

    @Then("^comment should appear under messages$")
    public void comment_should_appear_under_messages_successfully() {
        Assert.assertTrue(orderHistoryPage.confirmMessage());
    }
    @When("^user select signout link$")
    public void user_select_signout_link() {
        orderHistoryPage.signOut();
    }
    @Then("^user should signout successfully$")
    public void user_should_see_signin_link(){
        Assert.assertTrue(orderHistoryPage.isSignInDisplayed());
    }


}


