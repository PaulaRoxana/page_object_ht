package org.example.amazon_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    protected WebDriver driver;
    @BeforeMethod
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

//    @AfterMethod
//    public void closeDriver(){
//        driver.quit();
//    }
}
