package AutomationPractice.StepDefinitions.ApiSteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class PostCallSteps {

static String baseURL;
     Map<String,String> body;
    private ValidatableResponse json;
    private Response response;
    Map<String,Object> responseMap;




    @Given("^the apis are up and running for post call \"([^\"]*)\"$")
    public void theApisAreUpAndRunningForPostCall(String baseURL)  {
        this.baseURL = baseURL;
    }
    @When("^user performs a post request to \"([^\"]*)\" with below details$")
    public void userPerformsAPostRequestToWithBelowDetails(String post_url, DataTable dataTable) {
        this.baseURL = this.baseURL + post_url;
        System.out.println(post_url);
        System.out.println(baseURL);
        response = RestAssured.post(baseURL);
        this.body = new LinkedHashMap<String, String>();
        for (DataTableRow row : dataTable.getGherkinRows()) {
            this.body.put(row.getCells().get(0), row.getCells().get(1));

        }
    }

    @Then("^the status code for post call is (\\d+)$")
    public void theStatusCodeForPostCallIs(int statusCode){
        json = response.then();
        response= RestAssured.given().contentType(ContentType.JSON).body(this.body).when().post(this.baseURL);
int code=response.getStatusCode();
        System.out.println(code);
        Assert.assertEquals(201,code);
    }

    @And("^user should see following details in the json response in post call$")
    public void userShouldSeeFollowingDetailsInTheJsonResponseInPostCall(DataTable dataTable){

Map<String,String>query=new LinkedHashMap<String, String>();
        for (DataTableRow row : dataTable.getGherkinRows()) {
            this.body.put(row.getCells().get(0), row.getCells().get(1));
        }
        ObjectReader reader=new ObjectMapper().reader(Map.class);
        try {
            responseMap=reader.readValue(response.asString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(responseMap);

        for(String key:query.keySet()){
            Assert.assertTrue(responseMap.containsKey(key));
            Assert.assertEquals(query.get(key),responseMap.get(key).toString());
        }

    }




}
