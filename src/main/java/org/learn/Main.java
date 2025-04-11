package org.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://localhost:4200");
        System.out.println(webDriver.getTitle());
    }
}