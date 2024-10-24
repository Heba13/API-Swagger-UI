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
     Assert.assertEquals(brands.retrieveBrands().statusCode(),code);
    }

    @Then("retrieve specific brand response status code should be {int}")
    public void retrieveSpecificBrandResponseStatusCodeShouldBeCode(int code) {
        Assert.assertEquals(brands.getRetrieveOneBrandStatusCode(),code);
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
    public void retrieveBrandBy(String id){
        brands.retrieveBrandById(id);
    }

    @Then("brand name should match {string}")
    public void brandNameShouldMatch(String name) {
        Assert.assertEquals(brands.getBrandName(),name);
    }

    @When("create new brand record with {string}")
    public void createNewBrandRecordWithAnd(String name) {
        brands.createNewBrand(name);
    }

    @Then("error message for duplicate creation should be returned in response {string}")
    public void errorMessageForDuplicateCreationShouldBeReturnedInResponse(String error) {
        Assert.assertEquals(brands.getCreateNewBrandErrorMessage(),error);
    }

    @And("error message for when retrieve not existing a brand should be returned in response {string}")
    public void errorMessageForWhenRetrieveNotExistingABrandShouldBeReturnedInResponse(String error) {
        Assert.assertEquals(brands.getRetrieveBrandErrorMessage(),error);
    }

    @When("update brand {string} and {string} by it's {string}")
    public void updateBrandAndByItS(String name, String description, String id) {
        brands.updateBrand(name,description,id);
    }

    @When("delete brand by it's {string}")
    public void deleteBrandByItS(String id) {
        brands.deleteBrand(id);
    }

    @Then("create new brand response status code should be {int}")
    public void createNewBrandResponseStatusCodeShouldBeCode(int code) {
       Assert.assertEquals(brands.getCreateBrandStatusCode(),code);
    }


    @Then("update specific brand response status code should be {int}")
    public void updateSpecificBrandResponseStatusCodeShouldBeCode(int code) {
        Assert.assertEquals(brands.getUpdateBrandStatusCode(),code);
    }

    @Then("delete specific brand response status code should be {int}")
    public void deleteSpecificBrandResponseStatusCodeShouldBeCode(int code) {
        Assert.assertEquals(brands.getDeleteBrandStatusCode(),code);

    }

    @And("error message for when update not existing a brand should be returned in response {string}")
    public void errorMessageForWhenUpdateNotExistingABrandShouldBeReturnedInResponse(String error) {
        Assert.assertEquals(brands.getUpdateBrandErrorMessage(),error);

    }

    @And("error message for when delete not existing a brand should be returned in response {string}")
    public void errorMessageForWhenDeleteNotExistingABrandShouldBeReturnedInResponse(String error) {
        Assert.assertEquals(brands.getDeleteBrandErrorMessage(),error);

    }
}


