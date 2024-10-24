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
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.matchers.JUnitMatchers.everyItem;

public class Brands extends  BaseAPI {
    private String brandName ;
    private String createNewBrandErrorMessage ;
    private String retrieveBrandErrorMessage ;
    private int retrieveOneBrandStatusCode ;
    private int createBrandStatusCode ;
    private int updateBrandStatusCode ;
    private int deleteBrandStatusCode ;
    private String updateBrandErrorMessage ;
    private String deleteBrandErrorMessage ;

    public RequestSpecification requestConfiguration(){
        RestAssured.baseURI= BaseURL ;
        RequestSpecification request = given().config(RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC))).header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Token);
        return request;
    }
    public Response retrieveBrands() {
        Response response = requestConfiguration().when().get(Retrieve_Brands_URL);

        return response;
    }

    public Response retrieveBrandById(String id) {
        Response response = requestConfiguration().when().get("/brands/"+id);
        brandName = response.jsonPath().get("name");
        retrieveOneBrandStatusCode = response.statusCode();
        System.out.println(retrieveOneBrandStatusCode);
        if(retrieveOneBrandStatusCode==422){
            retrieveBrandErrorMessage=response.jsonPath().get("error");
        }
        return response;
    }

    public String getBrandName(){
        return brandName;
    }

    public int getRetrieveOneBrandStatusCode() {
        return retrieveOneBrandStatusCode;
    }

    public int getRetrieveBrandsSize() {
        return retrieveBrands().jsonPath().getList("$").size();
    }

    public ValidatableResponse checkAttributeNotNull(String attribute) {
        Response response =retrieveBrands();
     return response.then().body(attribute, everyItem(notNullValue()));
    }

    public Response createNewBrand(String nameBrand){
          Response response = requestConfiguration().queryParam("name",nameBrand).queryParam("description", "").when().post(BrandsEndPoint);
          response.then().log().all();
        System.out.println(response.asString());
        createBrandStatusCode= response.statusCode();
        if(createBrandStatusCode==422){
        createNewBrandErrorMessage =response.jsonPath().get("error");
        }
        return response;
    }

    public Response updateBrand(String nameBrand,String description ,String id ){
        Response response = requestConfiguration().queryParam("name",nameBrand).queryParam("description", description).when().put("/brands/"+id);
        updateBrandStatusCode= response.statusCode();
        System.out.println(updateBrandStatusCode);
        if(updateBrandStatusCode==422){
            updateBrandErrorMessage = response.jsonPath().get("error");
            System.out.println(updateBrandErrorMessage);
        }
        return response;
    }

    public Response deleteBrand(String id ){
        Response response = requestConfiguration().when().delete("/brands/"+id);
        deleteBrandStatusCode= response.statusCode();

        if(createBrandStatusCode!=200){
            deleteBrandErrorMessage =response.jsonPath().get("error");
        }
        return response;
    }

    public int getCreateBrandStatusCode() {
        return createBrandStatusCode;
    }

    public String getCreateNewBrandErrorMessage() {
        return createNewBrandErrorMessage;
    }

    public String getRetrieveBrandErrorMessage() {
        return retrieveBrandErrorMessage;
    }

    public int getUpdateBrandStatusCode() {
        return updateBrandStatusCode;
    }

    public String getUpdateBrandErrorMessage() {
        return updateBrandErrorMessage;
    }


    public String getDeleteBrandErrorMessage() {
        return deleteBrandErrorMessage;
    }

    public int getDeleteBrandStatusCode() {
        return deleteBrandStatusCode;
    }
}
