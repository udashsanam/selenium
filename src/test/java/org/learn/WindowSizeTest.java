package org.learn;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class WindowSizeTest {

    private WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void closeUp(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException, IOException {
        driver.get("https://google.com");

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        System.out.println(width);
        System.out.println(height);
        Dimension size = driver.manage().window().getSize();
        Assertions.assertEquals(size.width, width);
        Assertions.assertEquals(size.height, height);
        driver.manage().window().setSize(new Dimension(width + 200, height + 400));

        Point point = driver.manage().window().getPosition();
        System.out.println(point.x);
        System.out.println(point.y);
        driver.manage().window().setPosition(new Point(point.x + 10,point.y + 10));

       File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./image"+ Math.random()+".png"));

        Thread.sleep(2000);

    }

    @Test
    public void javaScriptExecutor() throws InterruptedException {
        driver.get("https://google.com");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(By.cssSelector(".gNO89b"));
        WebElement search = driver.findElement(By.cssSelector(".gLFyf"));
        javascriptExecutor.executeScript("arguments[0].value = 'Aashish'; arguments[1].click(); ",search, button);
        Thread.sleep(5000);


    }
}
