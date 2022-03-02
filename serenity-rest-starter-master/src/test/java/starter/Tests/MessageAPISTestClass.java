package starter.Tests;

import java.io.File;
import java.io.FileNotFoundException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
//import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.StepDefintions.MessageAPISStepDefinitions;



public class MessageAPISTestClass {

	public MessageAPISTestClass() throws FileNotFoundException {
	}

//	@Step("Creating message data")
//	public String CreateMessageData() {
//		// TODO Auto-generated method stub
//		MessageAPISStepDefinitions.loadMessageDataForCreate();
//
//		Response response = SerenityRest.given().when().headers(MessageAPISStepDefinitions.createMessageHeadersMap)
//				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
//				.post(MessageAPISStepDefinitions.url);
//
//		// Response response =
//		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
//		return response.getBody().asString();
//	}

	@Step("Creating message data")
	public String CreateMessageData() {
		// TODO Auto-generated method stub
		MessageAPISStepDefinitions.loadMessageDataForCreate();

		Response response = SerenityRest.given().when().header("AT", "1").contentType("application/json")
				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
				.post(MessageAPISStepDefinitions.url).then().assertThat()
				.body(matchesJsonSchema(new File("./src/test/resources/jsonschema/createMessage.json"))).extract().response();
		
		System.out.println("************************************************" + response.getBody().asString());


		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
		return response.getBody().asString();
	}

//	@Step("deleting message data")
//	public String deleteMessageData() {
//		// TODO Auto-generated method stub
//		MessageAPISStepDefinitions.loadMessageDataForDelete();
//
//		Response response = SerenityRest.given().when().headers(MessageAPISStepDefinitions.deleteMessageHeadersMap)
//				.relaxedHTTPSValidation().delete(MessageAPISStepDefinitions.url);
//
//		// Response response =
//		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
//
//		System.out.println("************************************************" + response.getBody().asString());
//		return response.getBody().asString();
//
//	}

	@Step("deleting message data")
	public String deleteMessageData() {
		// TODO Auto-generated method stub
		MessageAPISStepDefinitions.loadMessageDataForDelete();

		Response response = SerenityRest.given().when().header("AT", 1).relaxedHTTPSValidation()
				.delete(MessageAPISStepDefinitions.url).then().assertThat()
				.body(matchesJsonSchema(new File("./src/test/resources/jsonschema/getMessageByID.json"))).extract().response();

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

//	@Step("Getting message data")
//	public String getMessageData() {
//		// TODO Auto-generated method stub
//		MessageAPISStepDefinitions.loadMessageData();
//
//		Response response = SerenityRest.given().when().headers(MessageAPISStepDefinitions.getMessageHeadersMap)
//				.relaxedHTTPSValidation().get(MessageAPISStepDefinitions.url);
//
//		// Response response =
//		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
//
//		System.out.println("************************************************" + response.getBody().asString());
//		return response.getBody().asString();
//
//	}

	@Step("Getting message data")
	public String getMessageData() {
		// TODO Auto-generated method stub

		MessageAPISStepDefinitions.loadMessageData();

		Response response = SerenityRest.given().when().header("AT", "1").contentType("application/json")
				.relaxedHTTPSValidation().get(MessageAPISStepDefinitions.url).then().assertThat()
				.body(matchesJsonSchema(new File("./src/test/resources/jsonschema/getMessageByID.json"))).extract().response();

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

//	@Step("Creating message data with wrong header")
//	public String CreateMessageDataWithWrongHeader() {
//		// TODO Auto-generated method stub
//		MessageAPISStepDefinitions.loadMessageDataForCreateWithwrongHeader();
//
//		Response response = SerenityRest.given().when()
//				.headers(MessageAPISStepDefinitions.createMessageWithwrongHeaderHeadersMap)
//				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
//				.post(MessageAPISStepDefinitions.url);
//
//		// Response response =
//		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
//		return response.getBody().asString();
//	}

	@Step("Creating message data with wrong header")
	public String CreateMessageDataWithWrongHeader() {
		// TODO Auto-generated method stub
		MessageAPISStepDefinitions.loadMessageDataForCreateWithwrongHeader();

		Response response = SerenityRest.given().when().header("ATasd", "1").contentType("application/json")
				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
				.post(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
		return response.getBody().asString();
	}

	@Step("Creating message data without auth token")
	public String CreateMessageDataWithoutAuthToken() {

		MessageAPISStepDefinitions.loadMessageDataForCreateWithoutAuthToken();

		Response response = SerenityRest.given().when().contentType("application/json")
				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
				.post(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
		return response.getBody().asString();
	}

	@Step("Creating message data with Wrong Url")
	public String CreateMessageDataWithWrongUrl() {
		MessageAPISStepDefinitions.loadMessageDataForCreate_withWrongUrl();

		Response response = SerenityRest.given().when().header("AT", "1").contentType("application/json")
				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
				.post(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
		return response.getBody().asString();
	}

//	@Step("Creating message data with Wrong AuthToken")
//	public String CreateMessageDataWithWrongAuthToken() {
//		MessageAPISStepDefinitions.loadMessageDataWithWrongAuthToken();
//
//		Response response = SerenityRest.given().when()
//				.headers(MessageAPISStepDefinitions.createMessageWithWrongAuthTokenHeaderHeadersMap)
//				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
//				.post(MessageAPISStepDefinitions.url);
//
//		// Response response =
//		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
//		return response.getBody().asString();
//	}

	@Step("Creating message data with Wrong AuthToken")
	public String CreateMessageDataWithWrongAuthToken() {
		MessageAPISStepDefinitions.loadMessageDataWithWrongAuthToken();

		Response response = SerenityRest.given().when().header("AT", "234").contentType("application/json")
				.body(MessageAPISStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
				.post(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");
		return response.getBody().asString();
	}

	@Step("delete message data with Wrong Header")
	public String deleteMessageDataWithWrongHeader() {
		// TODO Auto-generated method stub
		MessageAPISStepDefinitions.loadMessageDataForDeleteWithwrongHeader();

		Response response = SerenityRest.given().when().header("ATasd", "1234").contentType("application/json")
				.relaxedHTTPSValidation().delete(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("delete message data without auth token")
	public String deleteMessageDataWithoutAuthToken() {
		MessageAPISStepDefinitions.loadMessageDataForDeleteWithoutAuthToken();

		Response response = SerenityRest.given().when().relaxedHTTPSValidation().contentType("application/json")
				.delete(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("delete message data with Wrong Url")
	public String deleteMessageDataWithWrongUrl() {
		MessageAPISStepDefinitions.loadMessageDataForDeleteWithWrongURL();

		Response response = SerenityRest.given().when().header("AT", "1").contentType("application/json")
				.relaxedHTTPSValidation().delete(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

	@Step("delete message data with Wrong AuthToken")
	public String deleteMessageDataWithWrongAuthToken() {
		MessageAPISStepDefinitions.loadMessageDataForDeleteWithWrongAuthToken();

		Response response = SerenityRest.given().when().header("AT", "234").contentType("application/json")
				.relaxedHTTPSValidation().delete(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("get message data with Wrong header")
	public String getMessageDataWithWrongHeader() {
		MessageAPISStepDefinitions.loadMessageDataForGetWithwrongHeader();

		Response response = SerenityRest.given().when().header("ATasd", "1234").contentType("application/json")
				.relaxedHTTPSValidation().get(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("get message data with Wrong AuthToken")
	public String getMessageDataWithWrongAuthToken() {
		// TODO Auto-generated method stub
		MessageAPISStepDefinitions.loadMessageDataForGetWrongAuthToken();

		Response response = SerenityRest.given().when().header("AT", "234").contentType("application/json")
				.relaxedHTTPSValidation().get(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

	@Step("get message data with Wrong URL")
	public String getMessageDataWithWrongUrl() {
		// TODO Auto-generated method stub
		MessageAPISStepDefinitions.loadMessageDataForGetWrongURL();

		Response response = SerenityRest.given().when().header("AT", 1).contentType("application/json")
				.relaxedHTTPSValidation().get(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

	@Step("get message data without passing AuthToken")
	public String getMessageDataWithoutPassingAuthToken() {
		// TODO Auto-generated method stub
		MessageAPISStepDefinitions.loadMessageDataForGetWithoutPassingAuthToken();

		Response response = SerenityRest.given().when().contentType("application/json").relaxedHTTPSValidation()
				.get(MessageAPISStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();
	}

}
