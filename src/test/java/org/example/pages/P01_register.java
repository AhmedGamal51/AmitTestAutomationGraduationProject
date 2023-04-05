package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class P01_register {
    public By maleRadioBox = By.id("gender-male");
    public By femaleRadioBox = By.id("gender-female");
    public By firstNameTextField = By.id("FirstName");
    public By lastNameTextField = By.id("LastName");
    public By dateOfBirthDay = By.name("DateOfBirthDay");
    public By dateOfBirthMonth= By.name("DateOfBirthMonth");
    public By dateOfBirthYear = By.name("DateOfBirthYear");
    public By emailTextField = By.id("Email");
    public By companyTextField = By.id("Company");
    public By newsLetter = By.id("Newsletter");
    public By passwordTextField = By.id("Password");
    public By confirmPasswordTextField = By.id("ConfirmPassword");
    public By registerButton= By.id("register-button");
    public By registerSuccess= By.cssSelector("div[class='result']");


    public void navigateToRegisterPage(){
        Hooks.driver.findElement(By.className("ico-register")).click();
    }


    public  void selectGenderRadioBox (String gender)  {

        switch (gender){
            case "male":
                Hooks.driver.findElement(maleRadioBox).click();
                break;
            case "female":
                Hooks.driver.findElement(femaleRadioBox).click();
                break;
        }
    }
    public void setFirstNameTextField(String fName){

        Hooks.driver.findElement(firstNameTextField).sendKeys(fName);
    }
    public void setLastNameTextField(String lName){

        Hooks.driver.findElement(lastNameTextField).sendKeys(lName);
    }
    public void setDateOfBirthDay(String dayIndex){
        Select dateOfBirthDayMenu= new Select(Hooks.driver.findElement(dateOfBirthDay));
        dateOfBirthDayMenu.selectByVisibleText(dayIndex);
    }
    public void setDateOfBirthMonth(String monthIndex){
        Select dateOfBirthMonthMenu= new Select(Hooks.driver.findElement(dateOfBirthMonth));
        dateOfBirthMonthMenu.selectByVisibleText(monthIndex);
    }
    public void setDateOfBirthYear(String yearIndex){
        Select dateOfBirthYearMenu= new Select(Hooks.driver.findElement(dateOfBirthYear));
        dateOfBirthYearMenu.selectByVisibleText(yearIndex);
    }
    public void setEmailTextField(String email){
        Hooks.driver.findElement(emailTextField).sendKeys(email);
    }
    public void setCompanyTextField(String company){
        Hooks.driver.findElement(companyTextField).sendKeys(company);
    }
    public void setNewsLetter(){
        Hooks.driver.findElement(newsLetter).click();
    }
    public void setPasswordTextField (String password){

        Hooks.driver.findElement(passwordTextField).sendKeys(password);
    }
    public void setConfirmPasswordTextField(String confirmPassword){
        Hooks.driver.findElement(confirmPasswordTextField).sendKeys(confirmPassword);
    }
    public void setRegisterButton(){
        Hooks.driver.findElement(registerButton).click();
    }
    public WebElement registerlink()
    {
        return Hooks.driver.findElement(registerSuccess);
    }
    public void getColor(){
        Assert.assertTrue(Color.fromString("rgba(76, 177, 124, 1)").asRgb().equals(registerlink().getCssValue("Color")));
    }

    public void getRegisterMessage(){

        Assert.assertEquals("Your registration completed",registerlink().getText());
    }
}
