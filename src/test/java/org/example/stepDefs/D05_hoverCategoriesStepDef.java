package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D05_hoverCategoriesStepDef {
    static String text = null;
    P03_homePage homePage = new P03_homePage();
    @When("user could hover over computers")
    public void hoverOverCategories(){
        homePage.hoverOverComputers();
        text = homePage.getTextDesktops();
        homePage.selectDesktops();
    }
    @Then("user could get desktops page")
    public void checkDeskTopsPage(){
        homePage.checkDeskTopPage();

    }

}
