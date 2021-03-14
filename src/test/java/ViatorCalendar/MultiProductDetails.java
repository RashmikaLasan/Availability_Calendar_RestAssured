package ViatorCalendar;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class MultiProductDetails extends TestBase {

    private String url2 = EndPoints.VIATOR_ENDPOINT2;
    private static Response response2;


    @Test
    public void supplierCode1() {
        commonRequestAndResponse2();
        Assert.assertEquals(response2.jsonPath().
                getString("data[0].products[0].supplierCode"), "VT111661P2");
        logger.info("supplierCode1 Testcase Completed");
    }

    @Test
    public void supplierCode2() {
        commonRequestAndResponse2();
        Assert.assertEquals(response2.jsonPath().
                getString("data[0].products[1].supplierCode"), "VT12s596P7");
        logger.info("supplierCode2 Testcase Completed");
    }

//    @Test
//    public void supplierCode2() {
//    commonRequestAndResponse2();
//        Assert.assertEquals(response2.jsonPath().and().
//        body("data[0].products[1].supplierCode",equalTo("VT10706P48")).and().
//    logger.info("supplierCode2 Testcase Completed");
//}

    @Test
        public void commonRequestAndResponse2() {

        response2 = given().
                contentType(ContentType.JSON).when().get(url2).then().extract().response();


    }


}
