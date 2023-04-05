package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();
    @Given("user could access his account")
    public void homePage(){
        homePage.navigateToLogInPage();
        homePage.setEmailTextField("ahmedgamalalden@gmail.com");
        homePage.setPasswordTextField("123456789");
        homePage.clickLogInButton();
    }
    @When("user could use currencies for products")
    public void currenciesFunctionality(){
        homePage.setCustomerCurrency("Euro");
    }
    @Then("user could found currencies successfully")
    public void checkCurrencies(){
        homePage.getActualPrice();

    }
}
