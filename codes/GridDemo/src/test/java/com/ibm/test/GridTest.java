package com.ibm.test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {

	@Test
    public void runOnRemoteNode() throws Exception {

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new RemoteWebDriver(
                new URL("http://192.168.1.2:4444"),
                options
        );
        
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        driver.findElement(By.linkText("PRACTICE")).click();
        driver.findElement(By.partialLinkText("Login")).click();
        
        System.out.println("Title: " + driver.getTitle());

        Thread.sleep(4000);
        driver.quit();
    }

}
