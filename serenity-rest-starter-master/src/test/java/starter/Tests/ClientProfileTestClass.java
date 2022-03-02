package starter.Tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;
import java.io.FileNotFoundException;

import io.restassured.response.Response;
//import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.StepDefintions.ClientProfileStepDefinitions;

public class ClientProfileTestClass {

	public ClientProfileTestClass() throws FileNotFoundException {
	}

	@Step("Getting contact data spain")
	public String getContactDataESP() {
		// TODO Auto-generated method stub
		ClientProfileStepDefinitions.loadContactDataESP();

		Response response = SerenityRest.given().when().header("accessToken", "token_esp").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url).then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema/getContactDataSpain.json"))).extract().response();
		
		System.out.println("************************************************" + response.getBody().asString());

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
		return response.getBody().asString();

	}

	@Step("Getting contact data portuguize")
	public String getContactDataPRT() {
		// TODO Auto-generated method stub
		ClientProfileStepDefinitions.loadContactDataPRT();

		Response response = SerenityRest.given().when().header("accessToken", "token_prt").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url).then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema/getContactDataPRT.json"))).extract().response();

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

	@Step("Getting personal data portuguize")
	public String getPersonalDataPRT() {
		// TODO Auto-generated method stub
		ClientProfileStepDefinitions.loadPersonalDataPRT();

		Response response = SerenityRest.given().when().header("accessToken", "token_prt").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url).then().assertThat().
				body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema/getPersonalDataPRT.json"))).extract().response();

		
		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

	@Step("Getting personal data spain")
	public String getPersonalDataESP() {
		// TODO Auto-generated method stub
		ClientProfileStepDefinitions.loadPersonalDataESP();

		Response response = SerenityRest.given().when().header("accessToken", "token_esp").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url).then()
				.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema/getPersonalDataESP.json"))).extract().response();

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

	@Step("Getting contact data spain with wrong header")
	public String getContactDataESPWithWrongHeader() {

		ClientProfileStepDefinitions.loadContactDataESPWithWrongHeader();

		Response response = SerenityRest.given().when().header("accessTokenasd", "token_esp").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

	@Step("Getting contact data spain without auth token")
	public String getContactDataESPWithoutAuth() {
		ClientProfileStepDefinitions.loadContactDataESPWithoutAuth();

		Response response = SerenityRest.given().when().relaxedHTTPSValidation().get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting contact data spain with wrong url")
	public String getContactDataESPWithWrongURL() {
		ClientProfileStepDefinitions.loadContactDataESPWithWrongURL();

		Response response = SerenityRest.given().when().header("accessToken", "token_esp").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting contact data spain with wrong Auth Token")

	public String getContactDataESPWithWrongAuthToken() {
		ClientProfileStepDefinitions.loadContactDataESPWithWrongAuthToken();

		Response response = SerenityRest.given().when().header("accessToken", "spadd").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting contact data portuguize with wrong header")
	public String getContactDataPRTWithWrongHeader() {
		ClientProfileStepDefinitions.loadContactDataPRTWithWrongHeader();

		Response response = SerenityRest.given().when().header("accessTokenasd", "token_prt").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting contact data portuguize without Auth")
	public String getContactDataPRTWithoutAuth() {
		ClientProfileStepDefinitions.loadContactDataPRTWithoutAuth();

		Response response = SerenityRest.given().when().relaxedHTTPSValidation().get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting contact data portuguize with Wrong URL")
	public String getContactDataPRTWithWrongURL() {
		ClientProfileStepDefinitions.loadContactDataPRTWithWrongURL();
		Response response = SerenityRest.given().when().header("accessToken", "token_prt").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting contact data portuguize with Wrong Auth Token")
	public String getContactDataPRTWithWrongAuthToken() {
		ClientProfileStepDefinitions.loadContactDataPRTWithWrongAuth();
		Response response = SerenityRest.given().when().header("accessToken", "asd234").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting Personal data spain with wrong header")

	public String getPersonalDataESPWithWrongHeader() {
		ClientProfileStepDefinitions.loadPersonalDataESPWithWrongHeader();

		Response response = SerenityRest.given().when().header("accessTokenasd", "token_esp").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting Personal data spain without auth")
	public String getPersonalDataESPWithoutAuth() {
		ClientProfileStepDefinitions.loadPersonalDataESPWithoutAuth();

		Response response = SerenityRest.given().when().relaxedHTTPSValidation().get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting Personal data spain with wrong URL")

	public String getPersonalDataESPWithWrongURL() {
		ClientProfileStepDefinitions.loadPersonalDataESPWithWrongURL();

		Response response = SerenityRest.given().when().header("accessToken", "token_esp").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

	@Step("Getting Personal data spain with wrong Auth token")

	public String getPersonalDataESPWithWrongAuthToken() {
		ClientProfileStepDefinitions.loadPersonalDataESPWithWrongAuthToken();

		Response response = SerenityRest.given().when().header("accessToken", "asd234").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting Personal data PRT with wrong header")
	public String getPersonalDataPRTWithWrongHeader() {
		ClientProfileStepDefinitions.loadPersonalDataPRTWithWrongHeader();

		Response response = SerenityRest.given().when().header("accessTokenasd", "token_prt").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting Personal data PRT without auth")

	public String getPersonalDataPRTWithoutAuth() {
		ClientProfileStepDefinitions.loadPersonalDataPRTWithoutAuth();

		Response response = SerenityRest.given().when().relaxedHTTPSValidation().get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting Personal data PRT with WrongURL")

	public String getPersonalDataPRTWithWrongURL() {
		ClientProfileStepDefinitions.loadPersonalDataPRTWithWrongURL();

		Response response = SerenityRest.given().when().header("accessToken", "token_prt").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("Getting Personal data PRT with Wrong Auth Token")

	public String getPersonalDataPRTWithWrongAuthToken() {
		ClientProfileStepDefinitions.loadPersonalDataPRTWithWrongAuthToken();

		Response response = SerenityRest.given().when().header("accessToken", "asd234").relaxedHTTPSValidation()
				.get(ClientProfileStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

}
