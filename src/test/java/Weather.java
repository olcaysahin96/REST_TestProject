import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;

public class Weather {
    @Test
    public void testApiWeather() {
        RestAssured.baseURI = "https://www.mgm.gov.tr/";
        RequestSpecification request = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));
        Response response = request.when().get("?il=Istanbul")

                .then()
                .statusCode(200)
                .extract().response();

        int responseCode = response.getStatusCode();
        ResponseBody responseBody = response.getBody();

        System.out.println("Status Code: " + responseCode);
        assert responseBody.asString() != null;

    }
}