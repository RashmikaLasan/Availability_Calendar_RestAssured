package ViatorCalendar;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MultiProductDetails extends TestBase {

          String url2 = EndPoints.VIATOR_ENDPOINT2;
         public static Response response2;


    @Test
    public void supplierCode1() {
        commonRequestAndResponse2();
        Assert.assertEquals(response2.jsonPath().
                getString("data[0].products[0].supplierCode"), "VT158308P3");
        logger.info("supplierCode1 Testcase Completed");
    }

    @Test
    public void supplierCode2() {
        commonRequestAndResponse2();
        Assert.assertEquals(response2.jsonPath().
                getString("data[0].products[1].supplierCode"), "VT10706P48");
        logger.info("supplierCode2 Testcase Completed");
    }

//    @Test
//    public void supplierCode2() {
//    commonRequestAndResponse2();
//        Assert.assertEquals(response2.jsonPath().and().
//        body("data[0].products[1].supplierCode",equalTo("VT10706P48")).and().
//    logger.info("supplierCode2 Testcase Completed");
//}


        public void commonRequestAndResponse2() {

        response2 = (Response) given().
                contentType(ContentType.JSON).when().get(url2).then().extract().response();
//        contentType(ContentType.JSON).when().get(url2).then().assertThat().statusCode(200).contentType(ContentType.JSON).and();


    }


}
