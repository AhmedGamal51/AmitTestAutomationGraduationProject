package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import static org.openqa.selenium.By.className;

public class P02_login {
    public By emailTextField = By.id("Email");
    public By passwordTextField = By.id("Password");
    public By rememberMeCheckBox = By.id("RememberMe");
    public By forgetPasswordLink = By.xpath("//span[@class='forgot-password']");
    public By logInButton= By.xpath("//button[@class='button-1 login-button']");
    public By loginSuccess= By.className("ico-account");
    public By registerFailMessage= By.cssSelector("div[class='message-error validation-summary-errors']");

    public void navigateToLogInPage(){
        Hooks.driver.findElement(className("ico-login")).click();
    }
    public void setEmailTextField(String email){
        Hooks.driver.findElement(emailTextField).sendKeys(email);
    }
    public void setPasswordTextField (String password){
        Hooks.driver.findElement(passwordTextField).sendKeys(password);
    }
    public void clickLogInButton(){
        Hooks.driver.findElement(logInButton).click();
    }
    public WebElement loginLink(){
        return Hooks.driver.findElement(loginSuccess);
    }
    public void getRegisterFailMessage(){
        Assert.assertTrue(Hooks.driver.findElement(registerFailMessage).getText().contains("Login was unsuccessful."));
    }
    public WebElement failLoginLink(){
        return Hooks.driver.findElement(registerFailMessage);
    }
    public void getRegisterFailMessageColor(){
        Assert.assertTrue(Color.fromString("rgba(228, 67, 75, 1)").asRgb().equals(failLoginLink().getCssValue("Color")));
    }
}
