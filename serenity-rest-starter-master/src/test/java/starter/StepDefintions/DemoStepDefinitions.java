package starter.StepDefintions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import starter.ResponseExtraction.DemoApiClassExtraction;
import starter.Tests.DemoTestClass;

import java.io.FileReader;

import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DemoStepDefinitions {
    JSONParser parser = new JSONParser();
    private Response response;
    @Steps
    DemoTestClass demoTestClass;

    @When("I hit the endpoint with valid account number")
    public void hitEndpointWithValidAccountNo() {
        demoTestClass.fetchOsbServiceChargeExchangeInformation();
    }


    @Then("the resulting response should contains account number related details, currency data and OSB exchange information")
    public void the_resulting_response_should_contains_account_number_related_details_currency_data_and_osb_exchange_information() {
        try{
            JSONObject fileJsonObject = (JSONObject)parser.parse(new FileReader("./src/test/resources/test-data/verification-data.json"));
            JSONObject osbJsonObject = (JSONObject) fileJsonObject.get("osb");
            String country= (String)osbJsonObject.get("COUNTRY");
            String accountNumber=(String)osbJsonObject.get("ACCT_NBR");
            restAssuredThat(response -> response.statusCode(200));
            restAssuredThat(response -> response.body(DemoApiClassExtraction.COUNTRY,equalTo(country)));
            restAssuredThat(response -> response.body(DemoApiClassExtraction.ACCOUNT_NUMBER,equalTo(accountNumber)));
            //restAssuredThat(response -> response.body(DemoApiClassExtraction.COUNTRY,equalTo("pp")));
            }catch(Exception e){
                e.printStackTrace();
            }
    }

}
