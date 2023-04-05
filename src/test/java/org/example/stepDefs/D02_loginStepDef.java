package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.Assert;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    @Given("user go to login page")
    public void navigateToLoginPage(){
        login.navigateToLogInPage();
    }
    @When("user login with valid credentials")
    public void loginWithValidCredentials(){
        login.setEmailTextField("ahmedgamalalden@gmail.com");
        login.setPasswordTextField("123456789");
        login.clickLogInButton();
    }
    @Then("user login to the system successfully")
    public void registerSuccess(){
        Assert.assertTrue(login.loginLink().isDisplayed());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

    }
    @When("user login with invalid credentials")
    public void loginWithInValidCredentials(){
        login.setEmailTextField("ahmedgamal555@gmail.com");
        login.setPasswordTextField("123456789");
        login.clickLogInButton();
    }
    @Then("user could not login to the system")
    public void registerFail(){
        login.getRegisterFailMessage();
        login.getRegisterFailMessageColor();

    }

}
