package swagger.endpoint;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.security.PublicKey;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.matchers.JUnitMatchers.everyItem;

public class Brands extends  BaseAPI {
    private String brandName ;
    private int retrieveOneBrandSize ;
    private int retrieveBrandsSize;
    public RequestSpecification requestConfiguration(){
        RequestSpecification request = given().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
                                       .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                                       .header("Authorization", "Bearer " + Token);
        return request;
    }
    public Response retrieveBrands() {
        Response response = requestConfiguration().when().get(Retrieve_Brands_URL);
        return response;
    }
    public Response retrieveBrandById(String id) {
        Response response = requestConfiguration().when().get(String.format(Retrieve_Brand_BY_ID_URL,id));
        brandName = response.jsonPath().get("name");
        retrieveOneBrandSize= response.jsonPath().getList("$").size();
        return response;
    }

    public String getBrandName(){
        return brandName;
    }
    public int getRetrieveOneBrandSize(){
        return retrieveOneBrandSize;
    }

    public int getRetrieveBrandsSize() {
        return retrieveBrands().jsonPath().getList("$").size();
    }

    public ValidatableResponse checkAttributeNotNull(String attribute){
       return retrieveBrands().then().statusCode(200).body(attribute, everyItem(notNullValue()));
    }

}
