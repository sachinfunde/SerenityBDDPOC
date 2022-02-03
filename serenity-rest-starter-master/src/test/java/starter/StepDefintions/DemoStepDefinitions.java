package starter.StepDefintions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import starter.ResponseExtraction.DemoApiExtraction;
import starter.Tests.DemoTestClass;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DemoStepDefinitions {
    static JSONParser parser = new JSONParser();
    public static HashMap<String, String> osbHeadersMap = new HashMap<String, String>();
    public static JSONObject jsonBodyObjectCommon;
    public static String url = "";
    public static JSONObject testDataFileJsonObject, verificationDataFileJsonObject;

    static {
        try {
            testDataFileJsonObject = (JSONObject) parser.parse(new FileReader("./src/test/resources/test-data/test-data.json"));
            verificationDataFileJsonObject = (JSONObject) parser.parse(new FileReader("./src/test/resources/test-data/verification-data.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Steps
    DemoTestClass demoTestClass;

    public DemoStepDefinitions() throws IOException, ParseException {
    }

    @When("I hit the endpoint with valid account number")
    public void hitEndpointWithValidAccountNo() {
        demoTestClass.fetchOsbServiceChargeExchangeInformation();
    }


    @Then("the resulting response should contains account number related details, currency data and OSB exchange information")
    public void the_resulting_response_should_contains_account_number_related_details_currency_data_and_osb_exchange_information() {
        try {
            JSONObject osbJsonObject = (JSONObject) verificationDataFileJsonObject.get("osb");
            String country = (String) osbJsonObject.get("COUNTRY");
            String accountNumber = (String) osbJsonObject.get("ACCT_NBR");
            restAssuredThat(response -> response.statusCode(200));
            restAssuredThat(response -> response.body(DemoApiExtraction.COUNTRY, equalTo(country)));
            restAssuredThat(response -> response.body(DemoApiExtraction.ACCOUNT_NUMBER, equalTo(accountNumber)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I pass Number")
    public void I_Pass_Number() {
        try {
            demoTestClass.fetchNumberToWordConversionDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I should get word for it")
    public void I_Should_Get_Word_For_It() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(DemoApiExtraction.NUMBER_TO_WORD, contains("five hundred ")));
    }

    @When("I provide the userid")
    public void I_Provide_The_UserId() {
        demoTestClass.getUserInfo();
    }

    @When("I should get user information")
    public void I_Should_Get_User_Information() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(DemoApiExtraction.FIRST_NAME, equalTo("Janet")));
    }

    public static void loadOsbData() {
        try {
            JSONObject osbJsonObject = (JSONObject) testDataFileJsonObject.get("osb");
            url = (String) osbJsonObject.get("url");
            JSONObject osbHeadersObject = (JSONObject) osbJsonObject.get("headers");
            jsonBodyObjectCommon = (JSONObject) osbJsonObject.get("body");
            osbHeadersMap.put("accept", (String) osbHeadersObject.get("accept"));
            osbHeadersMap.put("sessionId", (String) osbHeadersObject.get("sessionId"));
            osbHeadersMap.put("x-b3-traceId", (String) osbHeadersObject.get("x-b3-traceId"));
            osbHeadersMap.put("x-b3-spanId", (String) osbHeadersObject.get("x-b3-spanId"));
            osbHeadersMap.put("x-b3-sampled", (String) osbHeadersObject.get("x-b3-sampled"));
            osbHeadersMap.put("x-b3-parentSpanId", (String) osbHeadersObject.get("x-b3-parentSpanId"));
            osbHeadersMap.put("x-forwarded-for", (String) osbHeadersObject.get("x-forwarded-for"));
            osbHeadersMap.put("channel", (String) osbHeadersObject.get("channel"));
            osbHeadersMap.put("customerId", (String) osbHeadersObject.get("customerId"));
            osbHeadersMap.put("country", (String) osbHeadersObject.get("country"));
            osbHeadersMap.put("product", (String) osbHeadersObject.get("product"));
            osbHeadersMap.put("customerIdType", (String) osbHeadersObject.get("customerIdType"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
