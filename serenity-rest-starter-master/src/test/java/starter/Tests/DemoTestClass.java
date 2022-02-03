package starter.Tests;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.IOUtils;
import starter.StepDefintions.DemoStepDefinitions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DemoTestClass {

    FileInputStream fileInputStream = new FileInputStream(new File("./src/test/resources/test-data/test-data.xml"));

    public DemoTestClass() throws FileNotFoundException {
    }

    @Step("Get OSB service charge exchange information")
    public void fetchOsbServiceChargeExchangeInformation() {
            DemoStepDefinitions.loadOsbData();
            SerenityRest.given().when().headers(DemoStepDefinitions.osbHeadersMap).contentType(ContentType.JSON).body(DemoStepDefinitions.jsonBodyObjectCommon).relaxedHTTPSValidation()
                    .post(DemoStepDefinitions.url);
    }

    @Step("verify number to word conversion details")
    public void fetchNumberToWordConversionDetails() throws IOException {
        SerenityRest.given().baseUri("https://www.dataaccess.com/webservicesserver").relaxedHTTPSValidation().header("Content-Type", "text/xml").
                when().body(IOUtils.toString(fileInputStream,"UTF-8")).post("/NumberConversion.wso");
    }

    @Step("Verify user information")
    public void getUserInfo() {
        SerenityRest.given().when().relaxedHTTPSValidation().get("https://reqres.in/api/users/2");
    }

}
