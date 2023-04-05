package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("user click on wishlist button")
    public void wishListButton(){
        homePage.clickOnWishListButton();
    }
    @Then("check wishlist functionality")
    public void checkWishListFunctionality(){
        homePage.checkWishListMessage();
    }
    @When("user click on wishlist link")
    public void wishListLink(){
        homePage.clickOnWishListButton();
        homePage.clickWishLestLink();
    }
    @Then("check wishlist link functionality")
    public void checkWishListLinkFunctionality(){
        homePage.checkWishListQuantity();
    }

}
