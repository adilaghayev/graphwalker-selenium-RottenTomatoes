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

public class TopMoviesTest extends ExecutionContext implements Test3 {

    @BeforeExecution
    public void setup() {
        Helper.setup();
    }

    @AfterExecution
    public void cleanup() {
        Helper.tearDown();
    }


    @Override
    public void v_MovieDetail() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topSection\"]")));

    }

    @Override
    public void e_ChangeGenre() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top_movies_main\"]/div/div[2]/button"))).click();

        int row = Helper.getRandomInt(15);

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top_movies_main\"]/div/div[2]/ul/li["+row+"]"))).click();

    }

    @Override
    public void e_ChooseGenre() {

        int row = Helper.getRandomInt(15);

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main_container\"]/div[3]/div[3]/section/div/ul/li[1]")));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main_container\"]/div[3]/div[3]/section/div/ul/li["+row+"]"))).click();

    }

    @Override
    public void v_HomePageLoggedIn() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.className("masthead-account__menu-name")));

    }

    @Override
    public void v_HomePage() {

        Assert.assertEquals("https://www.rottentomatoes.com/", Helper.getInstance().getCurrentUrl());
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("masthead-show-login-btn")));

    }

    @Override
    public void e_ChooseMovie() {

        int row = Helper.getRandomInt(40);

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top_movies_main\"]/div/table/tbody/tr[1]")));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top_movies_main\"]/div/table/tbody/tr["+row+"]/td[3]/a"))).click();

    }

    @Override
    public void e_BackToGenre() {

        Helper.getInstance().navigate().back();

    }

    @Override
    public void e_GoToTopMovies() {

        Helper.getInstance().navigate().to("https://www.rottentomatoes.com/top");


    }

    @Override
    public void e_BackToHomePage() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"original_rt_logo\"]"))).click();

    }

    @Override
    public void e_StartBrowsing() {

        String baseUrl = "https://www.rottentomatoes.com/";

        Helper.getInstance().get(baseUrl);
        //maximize window
        Helper.getInstance().manage().window().maximize();

    }

    @Override
    public void v_TopMovies() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));

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
    public void v_TopMoviesGenre() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top_movies_main\"]/div/div[2]/button")));

    }
}
