package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();
    @Given("user could login to his account")
    public void userHomePage(){
        homePage.navigateToLogInPage();
        homePage.setEmailTextField("ahmedgamalalden@gmail.com");
        homePage.setPasswordTextField("123456789");
        homePage.clickLogInButton();
    }
    @When("user could search using product name")
    public void searchForProduct(){
        homePage.setSearchTextBox("book");
        homePage.clickSearchButton();
    }
    @Then("user could found product successfully")
    public void productShownSuccessfully(){
        homePage.getURL();
        homePage.getSearchSize();
        homePage.getSearchElement();
    }
    @When("user could search for product using {string}")
    public void searchUsingSKU(String sku) {
        homePage.setSearchTextBox(sku);
        homePage.clickSearchButton();
        homePage.clickProductName().click();
    }
    @Then("user could found specific product successfully")
    public void checkSKUNameSuccessfully(){
        homePage.getSKUname();
    }
}
