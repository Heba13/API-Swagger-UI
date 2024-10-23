package swagger.test;

import io.cucumber.java.en.And;
import org.testng.Assert;
import swagger.endpoint.BaseAPI;
import swagger.endpoint.Brands;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrandsStepdefs extends BaseAPI {
    public Brands brands = new Brands();

    @When("retrieve list of brands")
    public void retrieveListOfBrands() {
        brands.retrieveBrands();
    }

    @Then("retrieve brands response status code should be {int}")
    public void responseStatusCodeShouldBe(int code) {
     brands.retrieveBrands().then().statusCode(code);
    }

    @When("list of brands should have more than one entry")
    public void listOfBrandsShouldHaveMoreThanOneEntry() {
        Assert.assertTrue(brands.getRetrieveBrandsSize() > 1);
    }

    @Then("each brand object should contains {string} and {string} properties.")
    public void eachBrandObjectShouldContainsAndProperties(String name, String id) {
        Assert.assertTrue((brands.checkAttributeNotNull(name)!= null) && (brands.checkAttributeNotNull(id)!= null));
      //  Assert.assertTrue((brands.retrieveBrands().extract().body().jsonPath().get(name)!= null ) && (brands.retrieveBrands().extract().body().jsonPath().get(id)!= null)) ;
    }

    @When("retrieve brand by {string}")
    public void retrieveBrandBy(String id) {
        brands.retrieveBrandById(id);
    }

    @Then("brand name should match {string}")
    public void brandNameShouldMatch(String name) {
        Assert.assertEquals(brands.getBrandName(),name);
    }
    @Then("response for brand by id should contain one record")
    public void responseForBrandByIdShouldContainOneRecord() {
        Assert.assertTrue(brands.getRetrieveOneBrandSize()==1);
    }

    @When("create new brand record with {string} and {string}")
    public void createNewBrandRecordWithAnd(String arg0, String arg1) {
    }

    @Then("error message for duplicate creation should be returned in response {string}")
    public void errorMessageForDuplicateCreationShouldBeReturnedInResponse(String arg0) {
    }

    @And("error message for when retrieve not existing a brand should be returned in response {string}")
    public void errorMessageForWhenRetrieveNotExistingABrandShouldBeReturnedInResponse(String arg0) {
    }

    @When("update brand {string} and {string} by it's {string}")
    public void updateBrandAndByItS(String arg0, String arg1, String arg2) {
    }

    @When("delete brand by it's {string}")
    public void deleteBrandByItS(String arg0) {
    }



}


