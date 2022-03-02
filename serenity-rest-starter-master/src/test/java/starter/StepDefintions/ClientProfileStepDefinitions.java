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

public class ClientProfileStepDefinitions {

	static JSONParser parser = new JSONParser();
	public static HashMap<String, String> getContactDataESPHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getContactDataPRTHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataESPHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataPRTHeadersMap = new HashMap<String, String>();

	public static HashMap<String, String> getContactDataESPWithWrongHeaderHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getContactDataESPWithoutAuthHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getContactDataESPWithWrongURLHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getContactDataESPWithWrongAuthTokenHeadersMap = new HashMap<String, String>();

	public static HashMap<String, String> getContactDataPRTWithWrongHeaderHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getContactDataPRTWithoutAuthHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getContactDataPRTWithWrongURLHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getContactDataPRTWithWrongAuthTokenHeadersMap = new HashMap<String, String>();

	public static HashMap<String, String> getPersonalDataESPWithWrongHeaderHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataESPWithoutAuthHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataESPWithWrongURLHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataESPWithWrongAuthTokenHeadersMap = new HashMap<String, String>();

	public static HashMap<String, String> getPersonalDataPRTWithWrongHeaderHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataPRTWithoutAuthHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataPRTWithWrongURLHeadersMap = new HashMap<String, String>();
	public static HashMap<String, String> getPersonalDataPRTWithWrongAuthTokenHeadersMap = new HashMap<String, String>();

	public static JSONObject jsonBodyObjectCommon;
	public static String url = "";
	public static JSONObject getClientProfileTestDataFileJsonObject,
			getclientProfileTestDataVerificationDataFileJsonObject;
	public String jsonResponse;

	static {
		try {
			getClientProfileTestDataFileJsonObject = (JSONObject) parser
					.parse(new FileReader("./src/test/resources/test-data/test-data.json"));
			getclientProfileTestDataVerificationDataFileJsonObject = (JSONObject) parser
					.parse(new FileReader("./src/test/resources/test-data/verification-data.json"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Steps
	starter.Tests.ClientProfileTestClass ClientProfileTestClass;

	public ClientProfileStepDefinitions() throws IOException, ParseException {
	}

	// get contact data for spain
	@When("I hit the endpoint for get ContactData for Spain1")
	public void i_hit_the_endpoint_for_get_contact_data_for_spain1() {
		jsonResponse = ClientProfileTestClass.getContactDataESP();
	}

	@Then("the resulting response should contains Contact data for Spain1")
	public void the_resulting_response_should_contains_contact_data1() {
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

	public static void loadContactDataESP() {
		try {

			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataESPJsonObject = (JSONObject) clientProfileAPIJsonObject.get("getContactDataESP");
			url = (String) getContactDataESPJsonObject.get("url");
			System.out.println(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	////////////////////////////////////////////////////////////////////////////////////////
	// Get Contact data for portuguize

	@When("I hit the endpoint for get ContactData for portuguze1")
	public void i_hit_the_endpoint_for_get_contactdata_for_portuguze1() {
		jsonResponse = ClientProfileTestClass.getContactDataPRT();
	}

	@Then("the resulting response should contains Contact data for portuguze1")
	public void the_resulting_response_should_contains_contact_data_for_portuguze() {
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

	public static void loadContactDataPRT() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject contactDataPRTJsonObject = (JSONObject) clientProfileAPIJsonObject.get("getContactDataPRT");
			url = (String) contactDataPRTJsonObject.get("url");
			System.out.println(url);
			// JSONObject contactDataPRTHeadersObject = (JSONObject)
			// contactDataPRTJsonObject.get("headers");
			// getContactDataPRTHeadersMap.put("accessToken", (String)
			// contactDataPRTHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// get personal data for spain

	@When("I hit the endpoint for get Personaldata for spain1")
	public void i_hit_the_endpoint_for_get_personaldata_for_spain1() {
		jsonResponse = ClientProfileTestClass.getPersonalDataESP();
	}

	@Then("the resulting response should contains personal data1")
	public void the_resulting_response_should_contains_personal_data1() {
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

	public static void loadPersonalDataESP() {
		try {

			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject personalDataJsonObject = (JSONObject) clientProfileAPIJsonObject.get("getPersonalDataESP");
			url = (String) personalDataJsonObject.get("url");
			System.out.println(url);
//			JSONObject personalDataHeadersObject = (JSONObject) personalDataJsonObject.get("headers");
//			getPersonalDataESPHeadersMap.put("accessToken", (String) personalDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////

	// get Personaldata for portuguze

	@When("I hit the endpoint for get Personaldata for portuguze1")
	public void i_hit_the_endpoint_for_get_personaldata_for_portuguze1() {
		jsonResponse = ClientProfileTestClass.getPersonalDataPRT();
	}

	@Then("the resulting response should contains personal data for portuguze1")
	public void the_resulting_response_should_contains_personal_data_for_portuguze1() {
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

	public static void loadPersonalDataPRT() {
		try {

			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject personalDataPRTJsonObject = (JSONObject) clientProfileAPIJsonObject.get("getPersonalDataPRT");
			url = (String) personalDataPRTJsonObject.get("url");
			System.out.println(url);
//			JSONObject personalDataPRTHeadersObject = (JSONObject) personalDataPRTJsonObject.get("headers");
//			getPersonalDataPRTHeadersMap.put("accessToken", (String) personalDataPRTHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////

	// Negative test cases for Test get Contact data Spain.

	@When("I hit the endpoint for get Contact data Spain with wrong header")
	public void i_hit_the_endpoint_for_get_contact_data_spain_with_wrong_header() {
		jsonResponse = ClientProfileTestClass.getContactDataESPWithWrongHeader();
	}

	public static void loadContactDataESPWithWrongHeader() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataESP_WrongHeaderJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataESP_WrongHeader");
			url = (String) getContactDataESP_WrongHeaderJsonObject.get("url");
			System.out.println(url);
			/*
			 * JSONObject contactDataHeadersObject = (JSONObject)
			 * getContactDataESP_WrongHeaderJsonObject.get("headers");
			 * getContactDataESPWithWrongHeaderHeadersMap.put("accessTokenasd", (String)
			 * contactDataHeadersObject.get("accessTokenasd"));
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
				.get("clientProfileAPIS");
		System.out.println("********************" + clientProfileAPIJsonObject);
		JSONObject getContactDataESP_WrongHeaderJsonObject = (JSONObject) clientProfileAPIJsonObject
				.get("getContactDataESP_WrongHeader");

	}

	//////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for get Contact data Spain without passing authToken")
	public void i_hit_the_endpoint_for_get_contact_data_spain_without_passing_auth_token() {
		jsonResponse = ClientProfileTestClass.getContactDataESPWithoutAuth();
	}

	public static void loadContactDataESPWithoutAuth() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataESP_WithoutAuthJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataESP_WithoutAuth");
			url = (String) getContactDataESP_WithoutAuthJsonObject.get("url");
			System.out.println(url);
			// JSONObject contactDataHeadersObject = (JSONObject)
			// contactDataJsonObject.get("headers");
			// getContactDataESPHeadersMap.put("accessToken", (String)
			// contactDataHeadersObject.get("accessToken"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for Test get Contact data Spain by passing wrongUrl")
	public void i_hit_the_endpoint_for_test_get_contact_data_spain_by_passing_wrong_url() {
		jsonResponse = ClientProfileTestClass.getContactDataESPWithWrongURL();
	}

	public static void loadContactDataESPWithWrongURL() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataESP_WithWrongURLJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataESP_WithWrongURL");
			url = (String) getContactDataESP_WithWrongURLJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getContactDataESPWithWrongURLHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for Test get Contact data Spain by passing wrong auth taken")
	public void i_hit_the_endpoint_for_test_get_contact_data_spain_by_passing_wrong_auth_taken() {
		jsonResponse = ClientProfileTestClass.getContactDataESPWithWrongAuthToken();

	}

	public static void loadContactDataESPWithWrongAuthToken() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataESP_WithWrongAuthTokenJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataESP_WithWrongAuthToken");
			url = (String) getContactDataESP_WithWrongAuthTokenJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getContactDataESPWithWrongAuthTokenHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for get Contact data portuguize with wrong header")
	public void i_hit_the_endpoint_for_get_contact_data_portuguize_with_wrong_header() {
		jsonResponse = ClientProfileTestClass.getContactDataPRTWithWrongHeader();
	}

	public static void loadContactDataPRTWithWrongHeader() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataPRT_WrongHeaderJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataPRT_WrongHeader");
			url = (String) getContactDataPRT_WrongHeaderJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getContactDataPRTWithWrongHeaderHeadersMap.put("accessToken1234",
//					(String) contactDataHeadersObject.get("accessToken1234"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////
	@When("I hit the endpoint for get Contact data portuguize without passing authToken")
	public void i_hit_the_endpoint_for_get_contact_data_portuguize_without_passing_auth_token() {
		jsonResponse = ClientProfileTestClass.getContactDataPRTWithoutAuth();
	}

	public static void loadContactDataPRTWithoutAuth() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataPRT_WithoutAuthJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataPRT_WithoutAuth");
			url = (String) getContactDataPRT_WithoutAuthJsonObject.get("url");
			System.out.println(url);
			// JSONObject contactDataHeadersObject = (JSONObject)
			// contactDataJsonObject.get("headers");
			// getContactDataPRTWithoutAuthHeadersMap.put("accessToken",
			// (String) contactDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for Test get Contact data portuguize by passing wrongUrl")
	public void i_hit_the_endpoint_for_test_get_contact_data_portuguize_by_passing_wrong_url() {
		jsonResponse = ClientProfileTestClass.getContactDataPRTWithWrongURL();

	}

	public static void loadContactDataPRTWithWrongURL() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataPRT_WithWrongURLJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataPRT_WithWrongURL");

			url = (String) getContactDataPRT_WithWrongURLJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getContactDataPRTWithWrongURLHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for Test get Contact data portuguize by passing wrong auth taken")
	public void i_hit_the_endpoint_for_test_get_contact_data_portuguize_by_passing_wrong_auth_taken() {
		jsonResponse = ClientProfileTestClass.getContactDataPRTWithWrongAuthToken();

	}

	public static void loadContactDataPRTWithWrongAuth() {
		try {

			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getContactDataPRT_WithWrongAuthTokenJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getContactDataPRT_WithWrongAuthToken");
			url = (String) getContactDataPRT_WithWrongAuthTokenJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) getContactDataPRT_WithWrongAuthTokenJsonObject.get("headers");
//			getContactDataPRTWithWrongAuthTokenHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for get Personal data Spain with wrong header")
	public void i_hit_the_endpoint_for_get_personal_data_spain_with_wrong_header() {
		jsonResponse = ClientProfileTestClass.getPersonalDataESPWithWrongHeader();
	}

	public static void loadPersonalDataESPWithWrongHeader() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getPersonalDataESP_WrongHeaderJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataESP_WrongHeader");
			url = (String) getPersonalDataESP_WrongHeaderJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getPersonalDataESPWithWrongHeaderHeadersMap.put("accessTokenasd",
//					(String) contactDataHeadersObject.get("accessTokenasd"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for get Personal data Spain without passing authToken")
	public void i_hit_the_endpoint_for_get_personal_data_spain_without_passing_auth_token() {
		jsonResponse = ClientProfileTestClass.getPersonalDataESPWithoutAuth();
	}

	public static void loadPersonalDataESPWithoutAuth() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getPersonalDataESP_WithoutAuthJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataESP_WithoutAuth");
			url = (String) getPersonalDataESP_WithoutAuthJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getPersonalDataESPWithoutAuthHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for Test get Personal data Spain by passing wrongUrl")
	public void i_hit_the_endpoint_for_test_get_personal_data_spain_by_passing_wrong_url() {
		jsonResponse = ClientProfileTestClass.getPersonalDataESPWithWrongURL();
	}

	public static void loadPersonalDataESPWithWrongURL() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject loadPersonalDataESPWithWrongURLJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataESP_WithWrongURL");
			url = (String) loadPersonalDataESPWithWrongURLJsonObject.get("url");
			System.out.println(url);
			/*
			 * JSONObject contactDataHeadersObject = (JSONObject)
			 * contactDataJsonObject.get("headers");
			 * getPersonalDataESPWithWrongURLHeadersMap.put("accessToken", (String)
			 * contactDataHeadersObject.get("accessToken"));
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for Test get Personal data Spain by passing wrong auth taken")
	public void i_hit_the_endpoint_for_test_get_personal_data_spain_by_passing_wrong_auth_taken() {
		jsonResponse = ClientProfileTestClass.getPersonalDataESPWithWrongAuthToken();
	}

	public static void loadPersonalDataESPWithWrongAuthToken() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getPersonalDataESP_WithWrongAuthTokenJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataESP_WithWrongAuthToken");
			url = (String) getPersonalDataESP_WithWrongAuthTokenJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getPersonalDataESPWithWrongAuthTokenHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for get Personal data portuguize with wrong header")
	public void i_hit_the_endpoint_for_get_personal_data_portuguize_with_wrong_header() {
		jsonResponse = ClientProfileTestClass.getPersonalDataPRTWithWrongHeader();

	}

	public static void loadPersonalDataPRTWithWrongHeader() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getPersonalDataPRT_WrongHeaderJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataPRT_WrongHeader");

			url = (String) getPersonalDataPRT_WrongHeaderJsonObject.get("url");
			System.out.println(url);
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getPersonalDataPRTWithWrongHeaderHeadersMap.put("accessTokenasd",
//					(String) contactDataHeadersObject.get("accessTokenasd"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for get Personal data portuguize without passing authToken")
	public void i_hit_the_endpoint_for_get_personal_data_portuguize_without_passing_auth_token() {
		jsonResponse = ClientProfileTestClass.getPersonalDataPRTWithoutAuth();

	}

	public static void loadPersonalDataPRTWithoutAuth() {
		try {

			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getPersonalDataPRT_WithoutAuthJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataPRT_WithoutAuth");
			url = (String) getPersonalDataPRT_WithoutAuthJsonObject.get("url");
			System.out.println(url);
			/*
			 * JSONObject contactDataHeadersObject = (JSONObject)
			 * contactDataJsonObject.get("headers");
			 * getPersonalDataPRTWithoutAuthHeadersMap.put("accessToken", (String)
			 * contactDataHeadersObject.get("accessToken"));
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////
	@When("I hit the endpoint for Test get Personal data portuguize by passing wrongUrl")
	public void i_hit_the_endpoint_for_test_get_personal_data_portuguize_by_passing_wrong_url() {
		jsonResponse = ClientProfileTestClass.getPersonalDataPRTWithWrongURL();

	}

	public static void loadPersonalDataPRTWithWrongURL() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getPersonalDataPRT_WithWrongURLJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataPRT_WithWrongURL");
			url = (String) getPersonalDataPRT_WithWrongURLJsonObject.get("url");
			System.out.println(url);
//
//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getPersonalDataPRTWithWrongURLHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	@When("I hit the endpoint for Test get Personal data portuguize by passing wrong auth taken")
	public void i_hit_the_endpoint_for_test_get_personal_data_portuguize_by_passing_wrong_auth_taken() {
		jsonResponse = ClientProfileTestClass.getPersonalDataPRTWithWrongAuthToken();

	}

	public static void loadPersonalDataPRTWithWrongAuthToken() {
		try {
			JSONObject clientProfileAPIJsonObject = (JSONObject) getClientProfileTestDataFileJsonObject
					.get("clientProfileAPIS");
			System.out.println("********************" + clientProfileAPIJsonObject);
			JSONObject getPersonalDataPRT_WithWrongAuthTokenJsonObject = (JSONObject) clientProfileAPIJsonObject
					.get("getPersonalDataPRT_WithWrongAuthToken");

			url = (String) getPersonalDataPRT_WithWrongAuthTokenJsonObject.get("url");
			System.out.println(url);

//			JSONObject contactDataHeadersObject = (JSONObject) contactDataJsonObject.get("headers");
//			getPersonalDataPRTWithWrongAuthTokenHeadersMap.put("accessToken",
//					(String) contactDataHeadersObject.get("accessToken"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////

}
