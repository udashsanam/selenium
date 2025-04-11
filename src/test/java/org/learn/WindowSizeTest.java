package org.learn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSizeTest {

    private WebDriver webDriver;
    @BeforeEach
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void closeUp(){
        webDriver.quit();
    }
}
