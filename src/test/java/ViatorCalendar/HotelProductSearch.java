package ViatorCalendar;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HotelProductSearch extends TestBase {

    String url3 = EndPoints.HTL_ENDPOINT2;
    public static Response response;

    @Test
    public void productDetailsFullResponse() {
        given()
                .contentType(ContentType.JSON).when().get(url3).
                then().extract().response().prettyPrint();
        logger.info("BasicProductDetails Testcase Completed");
    }

    public void commonRequestAndResponse1() {

        response = given().
                contentType(ContentType.JSON).when().get(url3).then().extract().response();

    }


}
