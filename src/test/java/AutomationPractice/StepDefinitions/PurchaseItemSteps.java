package AutomationPractice.StepDefinitions;

import AutomationPractice.Pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PurchaseItemSteps {

    //*******************TEST 1: HAPPY PATH, PURCHASE 2 ITEMS************************

    public HomePage homePage;
    public ShoppingCartPage shoppingCartPage;
    public AddressPage addressPage;
    public ShippingPage shippingPage;
    public PaymentPage paymentPage;
    public BankWirePaymentPage bankWirePaymentPage;
    public OrderConfirmationPage orderConfirmationPage;

    @When("^user Quick view Blouse product$")
    public void user_Quick_view_Blouse_product() {
        homePage=new HomePage();
        homePage.viewBlouseItem();

    }

    @Then("^user should see Blouse product$")
    public void user_should_see_Blouse_product() {

        Assert.assertTrue(homePage.isBlouseHeaderDisplayed());
    }

    @When("^user change the size of the item to \"([^\"]*)\"$")
    public void user_change_the_size_of_the_item_to(String arg1) {
        homePage.selectSize(arg1);
    }

    @When("^add the item to the cart$")
    public void add_the_item_to_the_cart() {
        homePage.blouseAddToCart();
    }

    @When("^continue shopping$")
    public void continue_shopping() {
        homePage.continueShopping();
    }

    @Then("^user should be on the home page$")
    public void user_should_be_on_the_home_page() {
        homePage=new HomePage();
        Assert.assertTrue(homePage.getTitle().equalsIgnoreCase("My Store"));
    }

    @When("^user Quick view Chiffon dress$")
    public void user_Quick_view_Chiffon_dress() {
        homePage.viewChiffonDress();
    }

    @Then("^user should see Chiffon dress$")
    public void user_should_see_Chiffon_dress() {
        homePage.viewChiffonDressHeader();
    }

    @When("^user add the item to the cart$")
    public void user_add_the_item_to_the_cart() {
        homePage.addChiffonDressToCart();

    }

    @When("^user proceed to checkout$")
    public void user_proceed_to_checkout() {
        homePage.proceedToCheckoutChiffon();
    }

    @Then("^user should be on Shopping cart page$")
    public void user_should_be_on_Summary_page(){
        shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.viewShopppingCartHeader();

    }

    @Then("^user should see M size Blouse$")
    public void user_should_see_M_size_Blouse() {
    Assert.assertTrue(shoppingCartPage.getBlouseSize().contains("Size : M"));
    }

    @Then("^user should see S size Chiffon dress$")
    public void user_should_see_S_size_Chiffon_dress() {
    Assert.assertTrue(shoppingCartPage.getChiffonSize().contains("Size : S"));
    }

    @Then("^user should see the correct price for Blouse$")
    public void user_should_see_dollar_price_for_Blouse() {
        Assert.assertEquals(shoppingCartPage.checkBlousePrice(),27.00,0.0);
    }

    @Then("^user should see the correct price for Chiffon dress$")
    public void user_should_see_dollar_price_for_Chiffon_dress() {
        Assert.assertEquals(shoppingCartPage.checkChiffonDressPrice(),16.40,0.0);

    }
    @Then("^user should see sum of blouse and chiffon price as total products value$")
    public void user_should_see_sum_of_blouse_and_chiffon_price_as_total_products_value() {
        Assert.assertEquals(shoppingCartPage.expectedTotalProducts(),shoppingCartPage.actualTotalProducts(),0.0);
    }
    @Then("^user should see sum of Total products and Shipping as Total$")
    public void user_should_see_sum_of_total_products_and_shipping_as_total() {
        Assert.assertEquals(shoppingCartPage.totalPriceExpected(),shoppingCartPage.totalPriceActual(),0.0);
    }

    @When("^user selects summary proceed to checkout$")
    public void user_selects_summary_proceed_to_checkout() {
    shoppingCartPage.nvgtToAddressPage();
    }

    @Then("^user should navigate to address page$")
    public void user_should_be_on_the_address_page() {
        addressPage=new AddressPage();
        addressPage.viewAddressHeader();
    }

    @When("^user selects address proceed to checkout$")
    public void user_selects_address_proceed_to_checkout() {
        addressPage.navigateToShippingPage();
    }

    @Then("^user should be on the shipping page$")
    public void isUserOnShippingPage() {
        shippingPage =new ShippingPage();
        Assert.assertTrue(shippingPage.viewShippingHeader());
    }

    @When("^user selects terms of service checkbox$")
    public void user_selects_terms_of_service_checkbox() {
        shippingPage.selectShippingChkBox();
    }

    @When("^user selects shipping proceed to checkout$")
    public void user_selects_shipping_proceed_to_checkout() {
        shippingPage.navigateToPaymentPage();
    }

    @Then("^user should see payment page$")
    public void user_should_see_payment_page() {
        paymentPage=new PaymentPage();
        paymentPage.viewPaymentHeader();
    }

    @When("^user selects pay by bank wire$")
    public void user_selects_pay_by_bank_wire() {
        paymentPage.selectPayByBankWire();
    }

    @Then("^user should be on the bank wire payment page$")
    public void user_should_should_be_on_the_bank_wire_payment_page() {
        bankWirePaymentPage=new BankWirePaymentPage();
        bankWirePaymentPage.viewBankWirePaymentPageHeader();
    }

    @When("^user selects i confirm my order$")
    public void user_selects_i_confirm_my_order() {
        bankWirePaymentPage.navigateToConfirmationPage();
    }

    @Then("^user should purchase products successfully$")
    public void user_should_purchase_products_successfully() {
        orderConfirmationPage=new OrderConfirmationPage();
        Assert.assertTrue(orderConfirmationPage.viewOrderConfirmaionHeader());
    }
    @When("^user select signout link after purchase$")
    public void user_select_signout_link() {
        orderConfirmationPage.signOutAfterPurchase();
    }

}
