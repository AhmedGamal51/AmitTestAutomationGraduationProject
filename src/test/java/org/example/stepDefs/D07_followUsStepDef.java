package org.example.stepDefs;

import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("user could click on facebook link")
    public void followUsFBLinks(){
        homePage.clickOnFacebookLink();
    }
    @When("user could click on twitter link")
    public void followUsTwitterLinks(){
        homePage.clickOnTwitterLink();
    }
    @When("user could click on rss link")
    public void followUsRssLinks(){
        homePage.clickOnRSSLink();
    }
    @When("user could click on youtube link")
    public void followUsYoutubeLinks(){
        homePage.clickOnYoutubeLink();
    }
}
