package starter.Tests;

import java.io.FileNotFoundException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import starter.StepDefintions.TestStepDefinitions;

public class TestKunal {

	public TestKunal() throws FileNotFoundException {
	}

	@Step("Getting user data")
	public String getUserData() {
		// TODO Auto-generated method stub
		TestStepDefinitions.loadKunalData();
		Response response = SerenityRest.given().when().relaxedHTTPSValidation().get(TestStepDefinitions.url);

		// Response response =
		// SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/1");

		System.out.println("************************************************" + response.getBody().asString());
		return response.getBody().asString();

	}

}
