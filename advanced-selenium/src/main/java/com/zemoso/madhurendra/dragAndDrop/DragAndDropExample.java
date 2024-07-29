package com.zemoso.madhurendra.dragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragAndDropExample {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);


        try {
            driver.get("https://demo.automationtesting.in/Static.html");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            /*
            for ( int i = 1; i <= 3; i++ ) {
                String sourceXpath = "//div[@id='dragarea']//div[" + i +"]";
                System.out.println(sourceXpath);
                WebElement sourceElement = driver.findElement(By.xpath(sourceXpath));

                WebElement targetElement = driver.findElement(By.id("droparea"));

                Actions actions = new Actions(driver);

                actions.dragAndDrop(sourceElement, targetElement).perform();
            }
            */

            String sourceXpath = "//div[@id='dragarea']//div[1]";

            WebElement sourceElement = driver.findElement(By.xpath(sourceXpath));

            WebElement targetElement = driver.findElement(By.id("droparea"));

            Actions actions = new Actions(driver);

            actions.dragAndDrop(sourceElement, targetElement).perform();

            /*
            actions.clickAndHold(sourceElement)
                    .moveToElement(targetElement)
                    .release()
                    .build()
                    .perform();

            */
            WebElement droppedElement = wait.until(
                    ExpectedConditions.
                            presenceOfElementLocated(
                                    By.xpath("(//div[@id='droparea'])/img")
                            )
            );

            if (droppedElement.isDisplayed()) {
                System.out.println("PASS : The element was successfully dropped.");
            } else {
                System.out.println("FAIL : The element was not dropped.");
            }


        } finally {

            driver.quit();
        }
    }
}
