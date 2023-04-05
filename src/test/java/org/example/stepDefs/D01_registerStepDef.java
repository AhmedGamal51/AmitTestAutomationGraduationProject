package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;

public class D01_registerStepDef {
    P01_register register = new P01_register();


    @Given("user go to register page")
    public void navigateToRegisterPage(){
        register.navigateToRegisterPage();
    }
    @When("user enter valid credentials")
    public void enterValidData(){
        register.selectGenderRadioBox("male");
        register.setFirstNameTextField("automation");
        register.setLastNameTextField("tester");
        register.setDateOfBirthDay("25");
        register.setDateOfBirthMonth("March");
        register.setDateOfBirthYear("1998");
        register.setEmailTextField("test@example.com");
        register.setCompanyTextField("AMIT");
        register.setPasswordTextField("P@ssw0rd");
        register.setConfirmPasswordTextField("P@ssw0rd");
        register.setRegisterButton();

    }
    @Then("success message is displayed")
    public void checkData(){
        // Assert.assertEquals("Your registration completed",register.registerlink().getText());
        // Assert.assertTrue(Color.fromString("#4CB17C").asRgb().equals(register.registerlink().getCssValue("Color")));
        register.getRegisterMessage();
        register.getColor();

    }
}
