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

public class LoginTest extends ExecutionContext implements Login {

    @BeforeExecution
    public void setup() {
        Helper.setup();
    }

    @AfterExecution
    public void cleanup() {
        Helper.tearDown();
    }

    @Override
    public void e_StartBrowsing() {


        String baseUrl = "https://www.rottentomatoes.com/";

        Helper.getInstance().get(baseUrl);
        //maximize window
        Helper.getInstance().manage().window().maximize();

    }

    @Override
    public void v_ChangeSuccess() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[4]/section/div/div")));

    }

    @Override
    public void e_SubmitForm() {

        Helper.getInstance().findElement(By.id("personal_info_submit")).click();

    }

    @Override
    public void v_HomePageLoggedOut() {

        Assert.assertEquals("https://www.rottentomatoes.com/", Helper.getInstance().getCurrentUrl());
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("masthead-show-login-btn")));
    }

    @Override
    public void v_CountrySelector() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[4]/section/div/form/div[4]/div/select")));

    }

    @Override
    public void e_EditPerInfo() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/main/div[1]/section/div/div/ul/li[1]/h4/a"))).click();

    }

    @Override
    public void e_LogOut() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/nav/ul/li[4]")));
        Actions action = new Actions(Helper.getInstance());
        WebElement we = Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/ul/li[4]/a"));
        action.moveToElement(we).moveToElement(Helper.getInstance().findElement(By.xpath("/html/body/div[3]/header/nav/ul/li[4]/ul/li[4]/a"))).click().build().perform();

    }

    @Override
    public void v_AccountSettings() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/main/div[1]/section/h2")));

    }

    @Override
    public void v_HomePageLoggedin() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.className("masthead-account__menu-name")));

    }

    @Override
    public void v_PersonalInformation() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[4]/section/div/form/div[4]/label")));

    }

    @Override
    public void e_CredentialsValid() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username"))).clear();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username"))).sendKeys("adilaghayev@gmail.com");
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-password"))).clear();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-password"))).sendKeys("Rottentemporary123");
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-submit-btn"))).click();
    }

    @Override
    public void e_GoToProfile() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.className("masthead-account__menu-name"))).click();

    }

    @Override
    public void v_LoginPage() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username")));


    }

    @Override
    public void e_CredentialsInvalid() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username"))).clear();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username"))).sendKeys("adilagha@gmail.com");
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-password"))).clear();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-password"))).sendKeys("Rottentemporary12");
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-submit-btn"))).click();
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div/div/form/ul/div")));
    }

    @Override
    public void e_SelectCountry() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[4]/section/div/form/div[4]/div/select"))).click();

        if (Helper.getRandomInt(3) == 1) {

            Helper.getInstance().findElement(By.xpath("/html/body/div[5]/div[4]/section/div/form/div[4]/div/select/option[215]")).click();

        } else if (Helper.getRandomInt(3) == 2) {

            Helper.getInstance().findElement(By.xpath("/html/body/div[5]/div[4]/section/div/form/div[4]/div/select/option[23]")).click();

        } else {

            Helper.getInstance().findElement(By.xpath("/html/body/div[5]/div[4]/section/div/form/div[4]/div/select/option[2]")).click();

        }


    }

    @Override
    public void e_ManageAccount() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/section[1]/div/div[2]/a[1]"))).click();

    }

    @Override
    public void e_SuccessTrue() {

        Helper.getInstance().navigate().refresh();

    }

    @Override
    public void e_GoToHomePage() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]/div[1]/div[1]/a/img"))).click();

    }


    @Override
    public void e_Login() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("masthead-show-login-btn"))).click();
    }

    @Override
    public void v_ProfilePage() {

        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/section[1]/div/div[2]/a[1]")));

    }
}
