package org.learn;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainTest {

    @Test
    public void testViewRoom() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://localhost:4200");
        String title = webDriver.getTitle();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        Assert.assertEquals("LandonHotelApp", title);

        // Example selectors (change based on actual page structure)
        // Select 'From' date
        WebElement fromDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkin"))); // update ID as needed
//        fromDateInput.click();
        fromDateInput.clear();
        fromDateInput.sendKeys("11042025");

        WebElement toDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))); // update ID as needed
//        toDateInput.click();
        toDateInput.clear();
        toDateInput.sendKeys("12042025");
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", submit);
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
        webDriver.quit();

    }

    @Test
    public void waits(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        driver.quit();
    }

    @Test
    public void  actionOnElement() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        Thread.sleep(5000);
        textBox.sendKeys("Selenium");
        Thread.sleep(5000);
        submitButton.click();
        Thread.sleep(5000);


        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        driver.quit();
    }
}