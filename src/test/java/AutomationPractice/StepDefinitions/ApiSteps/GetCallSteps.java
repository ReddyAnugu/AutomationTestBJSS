package AutomationPractice.StepDefinitions.ApiSteps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class GetCallSteps {

    private ValidatableResponse json;
    private Response response;
    static String baseURL;

    @Given("^the apis are up and running for \"([^\"]*)\"$")
    public void theApisAreUpAndRunningFor(String baseURL) {
        this.baseURL = baseURL;
    }

    @When("^user performs a get request to \"([^\"]*)\"$")
    public void userPerformsAGetRequestTo(String api_url) {
        this.baseURL = this.baseURL + api_url;
        response=RestAssured.get(baseURL);

    }
    @Then("^the status code is (\\d+)$")
    public void theStatusCodeIs(int statusCode){
        json = response.then().statusCode(statusCode);

    }

    @And("^user should see following details in the json response$")
    public void userShouldSeeFollowingDetailsInTheJsonResponse(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                System.out.println(field.getValue());
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                json.body(field.getKey(), containsInAnyOrder(field.getValue()));
            }

        }
    }


}





