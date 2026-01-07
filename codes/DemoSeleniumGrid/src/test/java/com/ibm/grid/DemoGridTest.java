package com.ibm.grid;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoGridTest {
    static String baseUrl, nodeUrl;
    static FirefoxOptions options;
    static RemoteWebDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        options = new FirefoxOptions();
        baseUrl = "https://practicetestautomation.com/practice-test-login/";
        nodeUrl = "http://localhost:4444";

        options.setPlatformName("Windows 11");

        driver = new RemoteWebDriver(URI.create(nodeUrl).toURL(), options);
        driver.get(baseUrl);
        System.out.println("Original Page title is: " + driver.getTitle());
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        System.out.println("Page title is: " + driver.getTitle());
        Thread.sleep(4000);
        driver.quit();
    }
}

