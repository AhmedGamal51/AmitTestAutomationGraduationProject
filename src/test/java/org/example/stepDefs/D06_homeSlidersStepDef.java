package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("user could click on {string}")
    public void homeSlider(String slider){
        switch (slider){
            case "iphone":
                homePage.clickIphoneHomeSlider();
                break;
            case "samsung":
                homePage.clickSamsungImage();
                break;
        }
    }
    @Then("check the current {string}")
    public void checkHomeSliderUrl(String slider){
        switch (slider){
            case "iphone":
                homePage.getIphonePageURL();
                break;
            case "samsung":
                homePage.getSamsungPageURL();
                break;
        }

    }
}
