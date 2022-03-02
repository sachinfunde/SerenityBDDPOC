package starter.StepDefintions;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.ResponseExtraction.TestKunalAPIExtraction;
import starter.Tests.TestKunal;

public class TestStepDefinitions {

	static JSONParser parser = new JSONParser();
	public static HashMap<String, String> kunalHeadersMap = new HashMap<String, String>();
	public static JSONObject jsonBodyObjectCommon1;
	public static String url = "";
	public static JSONObject testDataFileJsonObject1, verificationDataFileJsonObject1;
	public String jsonResponse;

	static {
		try {
			testDataFileJsonObject1 = (JSONObject) parser.parse(new FileReader(
					"C:\\Users\\kunal.malpure\\Documents\\wizink\\SerenityBDDPOC\\serenity-rest-starter-master\\src\\test\\resources\\test-data\\Kunaltest-data.json"));
			verificationDataFileJsonObject1 = (JSONObject) parser
					.parse(new FileReader("./src/test/resources/test-data/a1.json"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Steps
	TestKunal testKunal;

	public TestStepDefinitions() throws IOException, ParseException {
	}

	@When("I hit the endpoint for creation user")
	public void hit_the_endpoint_for_creation_user() {
		jsonResponse = testKunal.getUserData();

	}

	@Then("the resulting response should contains id and createdAt")
	public void the_resulting_response_should_contains_id_and_created_at() {

		try {
			JSONObject kunalJsonObject = (JSONObject) verificationDataFileJsonObject1.get("data");
			String last_name = (String) kunalJsonObject.get("last_name");
			String firstName = (String) kunalJsonObject.get("first_name");
			restAssuredThat(response -> response.statusCode(200));

//			JsonPath js = new JsonPath(jsonResponse);
//			String firstNameFromActualJson = js.getString("data.first_name");
//			System.out.println("first Name From Actual Json" + firstNameFromActualJson);
//			String lastNameFromActualJson = js.getString("data.last_name");
//
//			System.out.println("last Name From Actual Json" + lastNameFromActualJson);
//
//			Assert.assertEquals(last_name, lastNameFromActualJson);
//			Assert.assertEquals(firstName, firstNameFromActualJson);

			restAssuredThat(response -> response.body(TestKunalAPIExtraction.Last_name, equalTo(last_name)));
			restAssuredThat(response -> response.body(TestKunalAPIExtraction.First_name, equalTo(firstName)));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void loadKunalData() {
		try {
			JSONObject kunalJsonObject = (JSONObject) testDataFileJsonObject1.get("ktest");
			url = (String) kunalJsonObject.get("url");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
