package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Created by krikar on 2015-02-01.
 */
public class Helper {
    /**
     * Random number generator.
     * Will be used to create random data used for input in test.
     */
    static private Random random = new Random(System.currentTimeMillis());

    /**
     * Timeout time in seconds used for waiting for element(s) to show up.
     */
    final static int timeOut = 10;

    /**
     * Generates a random number with 1 to max digits.
     *
     * @param max Maximum length of digits.
     * @return The random number
     */
    public static int getRandomInt(int max) {
        return random.nextInt(max) + 1;
    }

    public static void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Adil_Aghayev\\Desktop\\SWE550_GW\\chromedriver.exe");


    }

    public static void tearDown() {
        getInstance().quit();
    }

    private static class WebDriverHolder {
        private static final WebDriver INSTANCE = new ChromeDriver(ChromeDriverService.createDefaultService());
    }

    @SuppressWarnings( "deprecation" )
    public static WebDriverWait getWaiter() {
        return new WebDriverWait(getInstance(), 5);
    }


    public static WebDriver getInstance() {
        return WebDriverHolder.INSTANCE;
    }

}