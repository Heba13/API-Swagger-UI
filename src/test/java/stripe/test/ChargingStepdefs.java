package stripe.test;

import stripe.endpoint.Balance;
import stripe.endpoint.BaseAPI;
import stripe.endpoint.Recharge;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ChargingStepdefs extends BaseAPI {
    public Recharge recharge = new Recharge();
    public Balance balance = new Balance();

    @When("create a charge with {string} with {string} using {string} with {string}")
    public void createAChargeWith(String amount, String currency, String source, String description) {
        recharge.createARecharge(amount, currency, source, description);
    }

    @When("retrieve balance")
    public void retrieveBalance() {
        balance.retrieveBalance();

    }

    @Then("check that balance is more than Zero")
    public void checkThatBalanceIsMorethanZero() {
        int currentBalance = recharge.chargeAmount;
        Assert.assertNotEquals(currentBalance, 0);
    }

    @Then("check that currency is in USD")
    public void checkThatCurrencyIsInUSD() {
        String currency = recharge.chargeCurrency;
        Assert.assertEquals(currency, "usd");
    }


    @Then("check that Authorized amount is {string}")
    public void checkThatAuthorizedAmountIs(String amount) {
        String authorizedAmount = recharge.amountAuthorized;
        Assert.assertEquals(authorizedAmount, amount);

    }

    @Then("check that card brand is {string}")
    public void checkThatCardBrandIs(String brand) {
        String cardBrand = recharge.cardBrand;
        Assert.assertEquals(cardBrand, brand);
    }

    @Then("check that Expiry month  should be {string}")
    public void checkThatExpiryMounthShouldBe(String month) {
        String expiryMonth = recharge.exp_month;
        Assert.assertEquals(expiryMonth, month);
    }

    @Then("check that Expiry year  should be {string}")
    public void checkThatExpiryYearShouldBe(String year) {
        String expiryYear = recharge.exp_year;
        Assert.assertEquals(expiryYear, year);
    }

    @Then("check that schema response is correct {string}")
    public void checkThatSchemaResponseIsCorrect(String path) {
        balance.validateBalanceResponseSchema(path);
    }

}


