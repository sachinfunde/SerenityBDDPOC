package starter.Tests;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import io.restassured.response.Response;

public class DemoTestClass {
    JSONParser parser = new JSONParser();
    private Response response;
    @Step("Get OSB service charge exchange information")
    public void fetchOsbServiceChargeExchangeInformation() {
        try {
            JSONObject fileJsonObject = (JSONObject)parser.parse(new FileReader("./src/test/resources/test-data/test-data.json"));
            JSONObject osbJsonObject = (JSONObject) fileJsonObject.get("osb");
            String url= (String)osbJsonObject.get("url");
            JSONObject osbHeadersObject=(JSONObject) osbJsonObject.get("headers");
            JSONObject osbBodyObject=(JSONObject) osbJsonObject.get("body");
            HashMap<String,String> osbHeadersMap=new HashMap<String,String>();
            osbHeadersMap.put("accept",(String) osbHeadersObject.get("accept"));
            osbHeadersMap.put("sessionId",(String) osbHeadersObject.get("sessionId"));
            osbHeadersMap.put("x-b3-traceId",(String) osbHeadersObject.get("x-b3-traceId"));
            osbHeadersMap.put("x-b3-spanId",(String) osbHeadersObject.get("x-b3-spanId"));
            osbHeadersMap.put("x-b3-sampled",(String) osbHeadersObject.get("x-b3-sampled"));
            osbHeadersMap.put("x-b3-parentSpanId",(String) osbHeadersObject.get("x-b3-parentSpanId"));
            osbHeadersMap.put("x-forwarded-for",(String) osbHeadersObject.get("x-forwarded-for"));
            osbHeadersMap.put("channel",(String) osbHeadersObject.get("channel"));
            osbHeadersMap.put("customerId",(String) osbHeadersObject.get("customerId"));
            osbHeadersMap.put("country",(String) osbHeadersObject.get("country"));
            osbHeadersMap.put("product",(String) osbHeadersObject.get("product"));
            osbHeadersMap.put("customerIdType",(String) osbHeadersObject.get("customerIdType"));
            SerenityRest.given().when().headers(osbHeadersMap).contentType(ContentType.JSON).body(osbBodyObject.toJSONString()).relaxedHTTPSValidation()
                    .post(url);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
