package ViatorCalendar;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class BasicProductDetails extends TestBase{

       String url1 = EndPoints.VIATOR_ENDPOINT1;
       public static Response response;

    @Test
    public void productDetailsFullResponse(){
        given()
                .contentType(ContentType.JSON).when().get(url1).
                then().extract().response().prettyPrint();
        logger.info("BasicProductDetails Testcase Completed");
    }
    @Test
    public void productCode() {
        commonRequestAndResponse1();
        Assert.assertEquals(response.jsonPath().
        getString("data[0].products[0].supplierCode"), "VT158308P3");
        logger.info("Product Code Testcase Completed");
    }
    @Test
    public void productName() {
        commonRequestAndResponse1();
        Assert.assertEquals(response.jsonPath().
                getString("data[0].products[0].supplierName"), "Luxury Private Vehicle Day Hire From & to London via Stonehenge & Windsor Castle");
        logger.info("Product Name Testcase Completed");
    }



    @Test
    public void PricingUnit() {
        commonRequestAndResponse1();
        Assert.assertEquals(response.jsonPath().
//                getString("data[0].products[0].dates[0].pricingUnit"), "per_vehicle");
        getString("data[0].products[0].dates[0].pricingUnit"), "PER_PERSON");
        logger.info("Pricing Unit Testcase Completed");
    }

//    @Test
//    public void MultiProductAvailbility() {
//        commonRequestAndResponse2();
//        Assert.assertEquals(response2.jsonPath().
//                getString("data[0].products[0].dates[0].pricingUnit"), "per_vehicle");
//        logger.info("Pricing Unit Testcase Completed");
//    }





    public void commonRequestAndResponse1() {

        response = given().
                contentType(ContentType.JSON).when().get(url1).then().extract().response();

    }
//    public void commonRequestAndResponse2() {
//
//        response2 = given().
//                contentType(ContentType.JSON).when().get(url2).then().extract().response();
//
//    }




}
