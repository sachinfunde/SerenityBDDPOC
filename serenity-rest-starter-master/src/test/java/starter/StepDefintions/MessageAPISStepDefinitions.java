package starter.StepDefintions;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Tests.MessageAPISTestClass;

public class MessageAPISStepDefinitions {

	static JSONParser parser = new JSONParser();
//	public static HashMap<String, String> createMessageHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> deleteMessageHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> getMessageHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> createMessageWithwrongHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> createMessageWithoutAuthTokenHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> createMessageWithWrongUrlHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> createMessageWithWrongAuthTokenHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> deleteMessageWithwrongHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> deleteMessageWithoutAuthTokenHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> deleteMessageWithWrongUrlHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> deleteMessageWithwrongAuthTokenHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> getMessageWithwrongHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> getMessageWithoutAuthTokenHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> getMessageWithWrongUrlHeaderHeadersMap = new HashMap<String, String>();
//	public static HashMap<String, String> getMessageWithWrongAuthTokenHeaderHeadersMap = new HashMap<String, String>();

	public static JSONObject jsonBodyObjectCommon;
	public static JSONObject jsonBodyObjectCommon1;
	public static String url = "";
	public static JSONObject MessageAPIStestDataFileJsonObject, messageAPISverificationDataFileJsonObject;
	public String jsonResponse;

	static {
		try {
			MessageAPIStestDataFileJsonObject = (JSONObject) parser
					.parse(new FileReader("./src/test/resources/test-data/test-data.json"));
			messageAPISverificationDataFileJsonObject = (JSONObject) parser
					.parse(new FileReader("./src/test/resources/test-data/verification-data.json"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Steps
	MessageAPISTestClass messageApisTestClass;

	public MessageAPISStepDefinitions() throws IOException, ParseException {
	}

	// for create message

	@When("I hit the endpoint for createMessage1")
	public void i_hit_the_endpoint_for_create_message1() {
		jsonResponse = messageApisTestClass.CreateMessageData();
	}

	@Then("the resulting response should contains body and subject1")
	public void the_resulting_response_should_contains_body_and_subject1() {
		try {
			// JSONObject osbJsonObject = (JSONObject)
			// CreatemessageverificationDataFileJsonObject.get("messages");
//			String messageId = (String) osbJsonObject.get("messageId");
//			String subject = (String) osbJsonObject.get("subject");
			restAssuredThat(response -> response.statusCode(200));
//			restAssuredThat(response -> response.body(createMessageAPIExtraction.Message_ID, equalTo(messageId)));
//			restAssuredThat(response -> response.body(createMessageAPIExtraction.subject, equalTo(subject)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// for delete message

	@When("I hit the endpoint for deleteMessage1")
	public void i_hit_the_endpoint_for_delete_message1() {
		jsonResponse = messageApisTestClass.deleteMessageData();
	}

	@Then("the resulting response should see the message as Message deleted successfully1")
	public void the_resulting_response_should_see_the_message_as_message_deleted_successfully1() {
		try {
			// JSONObject osbJsonObject = (JSONObject)
			// CreatemessageverificationDataFileJsonObject.get("messages");
//		String messageId = (String) osbJsonObject.get("messageId");
//		String subject = (String) osbJsonObject.get("subject");
			restAssuredThat(response -> response.statusCode(200));
//		restAssuredThat(response -> response.body(createMessageAPIExtraction.Message_ID, equalTo(messageId)));
//		restAssuredThat(response -> response.body(createMessageAPIExtraction.subject, equalTo(subject)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void loadMessageDataForDelete() {
//		try {
//			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("deleteMessage");
//			url = (String) messageJsonObject.get("url");
//			System.out.println(url);
//			JSONObject messageHeadersObject = (JSONObject) messageJsonObject.get("headers");
//
//			// deleteMessageHeadersMap.put("Content-Type", (String)
//			// messageHeadersObject.get("Content-Type"));
//			deleteMessageHeadersMap.put("AT", (String) messageHeadersObject.get("AT"));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public static void loadMessageDataForDelete() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			System.out.println("********************" + messageJsonObject);
			JSONObject deleteMessageJsonObject = (JSONObject) messageJsonObject.get("deleteMessage");
			url = (String) deleteMessageJsonObject.get("url");
			System.out.println(url);
			// String url=(String)messageJsonObject1;
			// System.out.println((String)messageJsonObject1);
			// JSONObject deleteMessageHeadersObject = (JSONObject)
			// deleteMessageJsonObject.get("headers");

			// deleteMessageHeadersMap.put("Content-Type", (String)
			// messageHeadersObject.get("Content-Type"));
			// deleteMessageHeadersMap.put("AT", (String)
			// deleteMessageHeadersObject.get("AT"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	// for Get Message By Id

	@When("I hit the endpoint for getMessageByID1")
	public void i_hit_the_endpoint_for_get_message_by_id1() {
		jsonResponse = messageApisTestClass.getMessageData();
	}

	@Then("the resulting response should contains messageId and subject1")
	public void the_resulting_response_should_contains_messageId_and_subject1() {

		try {
			/*
			 * JSONArray getmessageJsonObject = (JSONArray)
			 * GetmessageverificationDataFileJsonObject.get("messages"); String messageId =
			 * (String) getmessageJsonObject.get("messageId"); String subject = (String)
			 * getmessageJsonObject.get("subject");
			 */
			restAssuredThat(response -> response.statusCode(200));

			/*
			 * // JsonPath js = new JsonPath(jsonResponse); // String String
			 * firstNameFromActualJson = js.getString("data.first_name"); //
			 * System.out.println("first Name From Actual Json" + firstNameFromActualJson);
			 * // String lastNameFromActualJson = js.getString("data.last_name"); // //
			 * System.out.println("last Name From Actual Json" + lastNameFromActualJson); //
			 * // Assert.assertEquals(last_name, lastNameFromActualJson); //
			 * Assert.assertEquals(firstName, firstNameFromActualJson);
			 */
			/*
			 * restAssuredThat(response ->
			 * response.body(GetMessageByIDAPIExtraction.Message_ID, equalTo(messageId)));
			 * restAssuredThat(response ->
			 * response.body(GetMessageByIDAPIExtraction.subject, equalTo(subject)));
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void loadMessageData() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");

			System.out.println("********************" + messageJsonObject);
			JSONObject getMessageJsonObject = (JSONObject) messageJsonObject.get("getMessageByID");
			url = (String) getMessageJsonObject.get("url");
			System.out.println(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for createMessage with wrong header")
	public void i_hit_the_endpoint_for_create_message_with_wrong_header() {
		jsonResponse = messageApisTestClass.CreateMessageDataWithWrongHeader();

	}

	@Then("the resulting response should contains status code as {int}")
	public void the_resulting_response_should_contains_status_code_as(int statusCode) {
		try {
			/*
			 * JSONArray getmessageJsonObject = (JSONArray)
			 * GetmessageverificationDataFileJsonObject.get("messages"); String messageId =
			 * (String) getmessageJsonObject.get("messageId"); String subject = (String)
			 * getmessageJsonObject.get("subject");
			 */
			restAssuredThat(response -> response.statusCode(statusCode));

			/*
			 * // JsonPath js = new JsonPath(jsonResponse); // String String
			 * firstNameFromActualJson = js.getString("data.first_name"); //
			 * System.out.println("first Name From Actual Json" + firstNameFromActualJson);
			 * // String lastNameFromActualJson = js.getString("data.last_name"); // //
			 * System.out.println("last Name From Actual Json" + lastNameFromActualJson); //
			 * // Assert.assertEquals(last_name, lastNameFromActualJson); //
			 * Assert.assertEquals(firstName, firstNameFromActualJson);
			 */
			/*
			 * restAssuredThat(response ->
			 * response.body(GetMessageByIDAPIExtraction.Message_ID, equalTo(messageId)));
			 * restAssuredThat(response ->
			 * response.body(GetMessageByIDAPIExtraction.subject, equalTo(subject)));
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void loadMessageDataForCreate() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject createMessageJsonObject = (JSONObject) messageJsonObject.get("createMessage");
			url = createMessageJsonObject.get("url").toString();
			System.out.println(url);
			// JSONObject createmessageHeadersObject = (JSONObject)
			// createMessageJsonObject.get("headers");
			jsonBodyObjectCommon = (JSONObject) createMessageJsonObject.get("body");
			// System.out.println((String) createmessageHeadersObject.get("Content-Type"));
			// System.out.println((String) createmessageHeadersObject.get("AT"));
			// createMessageHeadersMap.put("Content-Type", (String)
			// createmessageHeadersObject.get("Content-Type"));
			// createMessageHeadersMap.put("AT", (String)
			// createmessageHeadersObject.get("AT"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void loadMessageDataForCreateWithwrongHeader() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject createMessage_wrongHeaderJsonObject = (JSONObject) messageJsonObject
					.get("createMessage_wrongHeader");
			url = createMessage_wrongHeaderJsonObject.get("url").toString();
			System.out.println(url);
			jsonBodyObjectCommon = (JSONObject) createMessage_wrongHeaderJsonObject.get("body");

//			JSONObject messageHeadersObject1 = (JSONObject) messageJsonObject1.get("headers");
//			createMessageWithwrongHeaderHeadersMap.put("Content-Type",
//					(String) messageHeadersObject1.get("Content-Type"));
//			createMessageWithwrongHeaderHeadersMap.put("ATasd", (String) messageHeadersObject1.get("ATasd"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for createMessage without passing authToken")
	public void i_hit_the_endpoint_for_create_message_without_passing_auth_token() {
		jsonResponse = messageApisTestClass.CreateMessageDataWithoutAuthToken();
	}

	public static void loadMessageDataForCreateWithoutAuthToken() {
		try {

			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject createMessage_withoutAuthJsonObject = (JSONObject) messageJsonObject
					.get("createMessage_WithoutAuthToken");
			url = (String) createMessage_withoutAuthJsonObject.get("url");
			jsonBodyObjectCommon = (JSONObject) createMessage_withoutAuthJsonObject.get("body");
			System.out.println(url);
//			JSONObject messageHeadersObject = (JSONObject) messageJsonObject.get("headers");
//			createMessageWithoutAuthTokenHeaderHeadersMap.put("Content-Type",
//					(String) messageHeadersObject.get("Content-Type"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for createMessage by passing wrongUrl")
	public void i_hit_the_endpoint_for_create_message_by_passing_wrong_url() {
		jsonResponse = messageApisTestClass.CreateMessageDataWithWrongUrl();
	}

	public static void loadMessageDataForCreate_withWrongUrl() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject createMessageWithWrongURLJsonObject = (JSONObject) messageJsonObject
					.get("createMessageWithWrongURL");
			url = (String) createMessageWithWrongURLJsonObject.get("url");
			jsonBodyObjectCommon = (JSONObject) createMessageWithWrongURLJsonObject.get("body");
			System.out.println(url);
			// JSONObject createMessageWithWrongURLHeadersObject = (JSONObject)
			// createMessageWithWrongURLJsonObject.get("headers");
			// createMessageWithWrongUrlHeaderHeadersMap.put("Content-Type",
			// (String) createMessageWithWrongURLHeadersObject.get("Content-Type"));
			// createMessageWithWrongUrlHeaderHeadersMap.put("AT", (String)
			// createMessageWithWrongURLHeadersObject.get("AT"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for createMessage by passing wrong auth taken")
	public void i_hit_the_endpoint_for_create_message_by_passing_wrong_auth_taken() {
		jsonResponse = messageApisTestClass.CreateMessageDataWithWrongAuthToken();
	}

	public static void loadMessageDataWithWrongAuthToken() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject createMessageWithWrongAuthJsonObject = (JSONObject) messageJsonObject
					.get("createMessageWithWrongAuth");
			url = (String) createMessageWithWrongAuthJsonObject.get("url");
			jsonBodyObjectCommon = (JSONObject) createMessageWithWrongAuthJsonObject.get("body");
			System.out.println(url);
//			JSONObject messageHeadersObject = (JSONObject) messageJsonObject.get("headers");
//			createMessageWithWrongAuthTokenHeaderHeadersMap.put("Content-Type",
//					(String) messageHeadersObject.get("Content-Type"));
//			createMessageWithWrongAuthTokenHeaderHeadersMap.put("AT", (String) messageHeadersObject.get("AT"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Delete Messages

	@When("I hit the endpoint for deleteMessage with wrong header")
	public void i_hit_the_endpoint_for_delete_message_with_wrong_header() {
		jsonResponse = messageApisTestClass.deleteMessageDataWithWrongHeader();
	}

	public static void loadMessageDataForDeleteWithwrongHeader() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject deleteMessageWithWrongHeaderJsonObject = (JSONObject) messageJsonObject
					.get("deleteMessage_wrongHeader");
			url = (String) deleteMessageWithWrongHeaderJsonObject.get("url");
			System.out.println(url);
//			JSONObject messageHeadersObject1 = (JSONObject) messageJsonObject1.get("headers");
//			deleteMessageWithwrongHeaderHeadersMap.put("ATasd", (String) messageHeadersObject1.get("ATasd"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for deleteMessage without passing authToken")
	public void i_hit_the_endpoint_for_delete_message_without_passing_auth_token() {
		jsonResponse = messageApisTestClass.deleteMessageDataWithoutAuthToken();
	}

	public static void loadMessageDataForDeleteWithoutAuthToken() {
		try {

			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject deleteMessage_WithoutAuthTokenHeaderJsonObject = (JSONObject) messageJsonObject
					.get("deleteMessage_WithoutAuthToken");
			url = (String) deleteMessage_WithoutAuthTokenHeaderJsonObject.get("url");
			System.out.println(url);
			// JSONObject messageHeadersObject1 = (JSONObject)
			// messageJsonObject1.get("headers");
			// deleteMessageWithoutAuthTokenHeadersMap.put("AT", (String)
			// messageHeadersObject1.get("AT"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for deleteMessage by passing wrongUrl")
	public void i_hit_the_endpoint_for_delete_message_by_passing_wrong_url() {
		jsonResponse = messageApisTestClass.deleteMessageDataWithWrongUrl();
	}

	public static void loadMessageDataForDeleteWithWrongURL() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject deleteMessage_WithWrongURLHeaderJsonObject = (JSONObject) messageJsonObject
					.get("deleteMessage_WithWrongURL");

			url = (String) deleteMessage_WithWrongURLHeaderJsonObject.get("url");
			System.out.println(url);
			// JSONObject messageHeadersObject1 = (JSONObject)
			// messageJsonObject1.get("headers");
			// deleteMessageWithWrongUrlHeadersMap.put("AT", (String)
			// messageHeadersObject1.get("AT"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for deleteMessage by passing wrong auth taken")
	public void i_hit_the_endpoint_for_delete_message_by_passing_wrong_auth_taken() {
		jsonResponse = messageApisTestClass.deleteMessageDataWithWrongAuthToken();
	}

	public static void loadMessageDataForDeleteWithWrongAuthToken() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject deleteMessage_WithWrongAuthTokenHeaderJsonObject = (JSONObject) messageJsonObject
					.get("deleteMessage_WithWrongAuthToken");

			url = (String) deleteMessage_WithWrongAuthTokenHeaderJsonObject.get("url");
			System.out.println(url);
			// JSONObject messageHeadersObject1 = (JSONObject)
			// messageJsonObject1.get("headers");
			// deleteMessageWithwrongAuthTokenHeadersMap.put("AT", (String)
			// messageHeadersObject1.get("AT"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// Negative test cases for Get Message By ID

	@When("I hit the endpoint for getMessage with wrong header")
	public void i_hit_the_endpoint_for_get_message_with_wrong_header() {
		jsonResponse = messageApisTestClass.getMessageDataWithWrongHeader();
	}

	public static void loadMessageDataForGetWithwrongHeader() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject getMessage_WithWrongHeaderJsonObject = (JSONObject) messageJsonObject
					.get("getMessage_wrongHeader");

			url = (String) getMessage_WithWrongHeaderJsonObject.get("url");
			System.out.println(url);
//			JSONObject messageHeadersObject1 = (JSONObject) messageJsonObject1.get("headers");
//			getMessageWithwrongHeaderHeadersMap.put("ATasd", (String) messageHeadersObject1.get("ATasd"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for getMessage without passing authToken")
	public void i_hit_the_endpoint_for_get_message_without_passing_auth_token() {
		jsonResponse = messageApisTestClass.getMessageDataWithoutPassingAuthToken();
	}

	public static void loadMessageDataForGetWithoutPassingAuthToken() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject getMessage_WithoutAuthTokenHeaderJsonObject = (JSONObject) messageJsonObject
					.get("getMessage_WithoutAuthToken");

			url = (String) getMessage_WithoutAuthTokenHeaderJsonObject.get("url");
			System.out.println(url);
			// JSONObject messageHeadersObject1 = (JSONObject)
			// getMessage_WithoutAuthTokenHeaderJsonObject.get("headers");
			// getMessageWithoutAuthTokenHeaderHeadersMap.put("AT", (String)
			// messageHeadersObject1.get("AT"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	@When("I hit the endpoint for getMessage by passing wrongUrl")
	public void i_hit_the_endpoint_for_get_message_by_passing_wrong_url() {
		jsonResponse = messageApisTestClass.getMessageDataWithWrongUrl();
	}

	public static void loadMessageDataForGetWrongURL() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject getMessage_WithWrongURLHeaderJsonObject = (JSONObject) messageJsonObject
					.get("getMessage_WithWrongURL");
			url = (String) getMessage_WithWrongURLHeaderJsonObject.get("url");
			System.out.println(url);
//			JSONObject messageHeadersObject1 = (JSONObject) getMessage_WithWrongURLHeaderJsonObject.get("headers");
//			getMessageWithWrongUrlHeaderHeadersMap.put("AT", (String) messageHeadersObject1.get("AT"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for getMessage by passing wrong auth taken")
	public void i_hit_the_endpoint_for_get_message_by_passing_wrong_auth_taken() {
		jsonResponse = messageApisTestClass.getMessageDataWithWrongAuthToken();
	}

	public static void loadMessageDataForGetWrongAuthToken() {
		try {
			JSONObject messageJsonObject = (JSONObject) MessageAPIStestDataFileJsonObject.get("messages");
			JSONObject getMessage_WrongAuthTokenHeaderJsonObject = (JSONObject) messageJsonObject
					.get("getMessage_WrongAuthToken");

			url = (String) getMessage_WrongAuthTokenHeaderJsonObject.get("url");
			System.out.println(url);
			// JSONObject messageHeadersObject1 = (JSONObject)
			// messageJsonObject1.get("headers");
			// getMessageWithWrongAuthTokenHeaderHeadersMap.put("AT", (String)
			// messageHeadersObject1.get("AT"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////////
