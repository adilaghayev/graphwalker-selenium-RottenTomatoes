package com.company;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Before;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@GraphWalker(value = "random(edge_coverage(100))", start = "Start")

public class SearchWatchlistRateTest extends ExecutionContext implements Test2 {

//    String title = "123xyz";

    @BeforeExecution
    public void setup() {
        Helper.setup();
    }

    @AfterExecution
    public void cleanup() {
        Helper.tearDown();
    }


    @Override
    public void v_FilmDetail() {

        if (!Helper.getInstance().findElements(By.cssSelector(".js-rating-wts-btn")).isEmpty()) {

            System.out.println("Film page located");
        }

        else

            System.out.println("Franchise page located");

    }

    @Override
    public void e_Search() {

        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        int row = Helper.getRandomInt(2);

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/nav/form/input")));
        Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/input")).click();
        Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/input")).clear();
        Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/input")).sendKeys(Character.toString(c));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/nav/form/div/div/section[1]/ul/li["+row+"]/a/div/div[2]/div[1]"))).click();


//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".star-display__desktop:nth-child(5) > .star-display__half--right"))).click();
//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rate-and-review > .rate-and-review__body .js-next-submit-btn"))).click();
//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rate-and-review > .verify-ticket__body .js-submit-review"))).click();
//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".js-multi-page-modal__sub-modal:nth-child(3) .js-submit-review-without-verification"))).click();
//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".js-rating-submission-message-drawer > .mobile-drawer__content > .js-mobile-drawer-backdrop-close-btn"))).click();



    }

//        if (Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/div[3]/header/nav/form/div/div/section[1]/h3/text(Movies)")))).toString().equals("Movies")){
//
//            Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/div/div/section[1]/ul/li[1]")).click();
//
//        }
//
//        else if (Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/div/div/section[2]/h3/text()")).toString().equals("Movies")){
//
//            Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/div/div/section[2]/ul/li[1]")).click();
//
//        }
//
//        else if (Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/div/div/section[3]/h3/text()")).toString().equals("Movies")){
//
//            Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/form/div/div/section[3]/ul/li[1]")).click();
//
//        }

//    @Override
//    public void e_CheckWantToSee() {
//
//        Helper.getInstance().navigate().refresh();
//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".js-rating-wts-btn button--wts")));
//        Actions action = new Actions(Helper.getInstance());
//        action.moveToElement(Helper.getInstance().findElement(By.cssSelector(".js-rating-wts-btn button--wts"))).click().build().perform();
//
//    }

//    @Override
//    public void v_Updated() {
//
//    }

    @Override
    public void v_HomePageLoggedIn() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.className("masthead-account__menu-name")));

    }

    @Override
    public void v_HomePage() {

        Assert.assertEquals("https://www.rottentomatoes.com/", Helper.getInstance().getCurrentUrl());
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("masthead-show-login-btn")));

    }

//    @Override
//    public void v_AddedWantToSee() {
//
//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".js-rating-wts-btn button--wts button--wts-selected")));
//
//    }

    @Override
    public void e_GoToProfile() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headerUserSection\"]"))).click();

    }

    @Override
    public void e_BackToHomePage() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/nav/div[1]/div[2]/div[1]/div[1]/a/img"))).click();

    }


//    @Override
//    public void e_CheckAdditions() {
//
//        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div[1]/div[2]/nav/ul/li[4]/a"))).click();
//        Helper.getInstance().navigate().refresh();
//        Helper.getInstance().findElement(By.className("wts-item__media-title")).toString().equals(title);
//
//    }

//    @Override
//    public void e_SearchAnother() {
//
//    }

    @Override
    public void e_StartBrowsing() {

        String baseUrl = "https://www.rottentomatoes.com/";

        Helper.getInstance().get(baseUrl);
        //maximize window
        Helper.getInstance().manage().window().maximize();

    }

    @Override
    public void e_SearchAgain() {

        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        int row = Helper.getRandomInt(2);

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fullscreen-search-term\"]")));
        Helper.getInstance().findElement(By.xpath("//*[@id=\"fullscreen-search-term\"]")).click();
        Helper.getInstance().findElement(By.xpath("//*[@id=\"fullscreen-search-term\"]")).clear();
        Helper.getInstance().findElement(By.xpath("//*[@id=\"fullscreen-search-term\"]")).sendKeys(Character.toString(c));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/nav/form/div/div/section[1]/ul/li["+row+"]/a/div/div[2]/div[1]"))).click();

    }

    @Override
    public void e_LogIn() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("masthead-show-login-btn"))).click();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username"))).clear();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username"))).sendKeys("adilaghayev@gmail.com");
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-password"))).clear();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-password"))).sendKeys("Rottentemporary123");
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-submit-btn"))).click();

    }

    @Override
    public void v_ProfilePage() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headerUserSection\"]")));

    }
}
