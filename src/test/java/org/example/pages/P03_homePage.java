package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.By.className;

public class P03_homePage {
    public By customerCurrency = By.id("customerCurrency");
    public By actualPrice = By.cssSelector("span[class='price actual-price']");
    public By emailTextField = By.id("Email");
    public By passwordTextField = By.id("Password");
    public By logInButton= By.xpath("//button[@class='button-1 login-button']");
    public By searchTextBox = By.id("small-searchterms");
    public By searchButton = By.cssSelector("button[class='button-1 search-box-button']");
    public By skuName = By.cssSelector("div span[class='value']");
    //    public By firstHomeSlider= By.xpath("//div[@id='nivo-slider']/a[1]");
//    public By secondHomeSlider = By.xpath("//div[@id='nivo-slider']/a[2]");
    public By firstHomeSlider = By.xpath("//div[@id='nivo-slider']/a/img[contains(@src,'_banner_01')]");
    public By secondHomeSlider = By.xpath("//div[@id='nivo-slider']/a/img[contains(@src,'_banner_02')]");
    public By imageBanner = By.id("nivo-slider");
    public By facebookLink = By.className("facebook");
    public By twitterLink = By.className("twitter");
    public By rssLink = By.className("rss");
    public By youtubeLink = By.className("youtube");
    public By addWishlistButton = By.cssSelector("div[data-productid='18'] button[class='button-2 add-to-wishlist-button']");
    public By barNotificationWishList = By.cssSelector("div[id='bar-notification'] div[class='bar-notification success']");
    public By wishListLink = By.className("ico-wishlist");
    public By quantityWishList = By.cssSelector("td[class='quantity'] input");

    public void setCustomerCurrency(String option) {
        Select customerDropDown = new Select(Hooks.driver.findElement(customerCurrency));
        customerDropDown.selectByVisibleText(option);
    }

    public void getActualPrice(){
        List<WebElement> elementPrices = Hooks.driver.findElements(actualPrice);
        int size = elementPrices.size();
        for (int i = 0; i < size; i++){
            WebElement elementPrice = elementPrices.get(i);
            Assert.assertTrue(elementPrice.getText().contains("€"));
        }
    }
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
    public void setSearchTextBox(String search){
        Hooks.driver.findElement(searchTextBox).sendKeys(search);
    }
    public String getSearchTextBox(){

        return Hooks.driver.findElement(searchTextBox).getText();
    }
    public void clickSearchButton(){
        Hooks.driver.findElement(searchButton).click();
    }
    public void getURL(){
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }
    public int getSearchSize(){
        int size =  Hooks.driver.findElements(By.className("item-box")).size();
        System.out.println(size);
        return size;
    }

    public void getSearchElement(){
        List <WebElement> searchElements = Hooks.driver.findElements(By.className("product-title"));
        int searchElementSize = searchElements.size();
        for (int i = 0; i <searchElementSize;i++){
            WebElement searchElement = searchElements.get(i);
            Assert.assertTrue(searchElement.getText().toLowerCase().contains(getSearchTextBox()));
        }
    }
    public WebElement clickProductName(){
        return Hooks.driver.findElement(By.cssSelector("h2 a"));
    }
    public void getSKUname(){
        Assert.assertTrue(Hooks.driver.findElement(skuName).getText().contains(getSearchTextBox()));
    }
    //    public String getFirstHomeSlidersPage() throws InterruptedException {
//        WebElement click = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(Hooks.driver.findElement(By.xpath("//div[@id='nivo-slider']/a[1]"))));
//        WebElement wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
//                .until(ExpectedConditions.visibilityOfElementLocated((firstHomeSlider)));
//          click.getAttribute("style").contains("none");
//         wait.click();
//        Thread.sleep(2000);
//        return Hooks.driver.getCurrentUrl();
//    }
//    public String getSecondHomeSlidersPage() throws InterruptedException {
//        WebElement wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(secondHomeSlider));
//        wait.click();
//        Thread.sleep(2000);
//        return Hooks.driver.getCurrentUrl();
//    }
    public void hoverOverComputers(){
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(Hooks.driver.findElement(By.linkText("Computers"))).perform();
        Hooks.driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }
    public String getTextDesktops(){
        return (Hooks.driver.findElement(By.cssSelector("ul[class='top-menu mobile'] a[href='/desktops']"))).getText();
    }
    public void selectDesktops(){
        (Hooks.driver.findElement(By.cssSelector("ul[class='top-menu notmobile'] a[href='/desktops']"))).click();
    }
    public String getHeaderDesktops(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText().trim().toLowerCase();
    }
    public void checkDeskTopPage(){
        Assert.assertEquals(getHeaderDesktops(),"desktops");
    }
    public void clickIphoneHomeSlider(){
        String link = Hooks.driver.findElement(firstHomeSlider).getAttribute("src");
        while (!(link.contains("01"))){
            link = Hooks.driver.findElement(firstHomeSlider).getAttribute("src");
        }
        if (link.contains("01")){
            Hooks.driver.findElement(imageBanner).click();
            System.out.println("link is "+ link);
        }
        // return Hooks.driver.getCurrentUrl();
    }
    public void clickSamsungImage(){
        String link = Hooks.driver.findElement(secondHomeSlider).getAttribute("src");
        while (!(link.contains("02"))){
            link = Hooks.driver.findElement(secondHomeSlider).getAttribute("src");
        }
        if (link.contains("02")){
            Hooks.driver.findElement(imageBanner).click();
            System.out.println(link + "link is");
        }
        // return Hooks.driver.getCurrentUrl();
    }
    public void getIphonePageURL() {
        Assert.assertEquals("https://demo.nopcommerce.com/","https://demo.nopcommerce.com/iphone-6");
    }
    public void getSamsungPageURL() {
        Assert.assertEquals("https://demo.nopcommerce.com/","https://demo.nopcommerce.com/nokia-lumia-1020");
    }
    public void clickOnFacebookLink(){
        Hooks.driver.findElement(facebookLink).click();
        Boolean wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab :" + Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

    }
    public void clickOnTwitterLink(){
        Hooks.driver.findElement(twitterLink).click();
        Boolean wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(7))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab :" + Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://twitter.com/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

    }
    public void clickOnRSSLink(){
        Hooks.driver.findElement(rssLink).click();
//        Boolean wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(7))
//                .until(ExpectedConditions.numberOfWindowsToBe(2));
//        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
//        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab :" + Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/new-online-store-is-open");
//        Hooks.driver.close();
//        Hooks.driver.switchTo().window(tabs.get(0));

    }
    public void clickOnYoutubeLink(){
        Hooks.driver.findElement(youtubeLink).click();
        Boolean wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(7))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab :" + Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }
    public void clickOnWishListButton(){
        Hooks.driver.findElement(addWishlistButton).click();
    }
    public Boolean getWishListMessageText(){
        WebElement wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(barNotificationWishList));
        return true;
    }
    public String getWishListMessageColor(){
        WebElement color = Hooks.driver.findElement(barNotificationWishList);
        String colorMessage = color.getCssValue("background-color");
        return Color.fromString(colorMessage).asHex();
    }
    public void checkWishListMessage(){
        Assert.assertTrue(getWishListMessageText());
        Assert.assertTrue(Color.fromString("#4bb07a").asHex().equals(getWishListMessageColor()));
    }
    public Boolean successMessageDisappear(){
        Boolean wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfElementLocated(barNotificationWishList));
        return true;
    }
    public void clickWishLestLink(){
        successMessageDisappear();
        Hooks.driver.findElement(wishListLink).click();
    }
    public String getWishListQuantity(){
        WebElement quantity = Hooks.driver.findElement(quantityWishList);
        String quantityNo = quantity.getAttribute("value");
        return quantityNo;
    }
    public void checkWishListQuantity(){
        Assert.assertNotEquals(getWishListQuantity(),"0");
    }
}
