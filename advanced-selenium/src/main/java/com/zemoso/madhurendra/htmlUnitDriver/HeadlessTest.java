package com.zemoso.madhurendra.htmlUnitDriver;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HeadlessTest {
    @Test
    public void testGoogleSearch() {

        // specify the browser - javascript support enabled
        // WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
        WebDriver driver = new HtmlUnitDriver();


        driver.get("http://www.google.com");

        driver.findElement(By.name("q"))
                .sendKeys("Selenium WebDriver");

        driver.findElement(By.name("q")).submit();



        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("selenium webdriver");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
