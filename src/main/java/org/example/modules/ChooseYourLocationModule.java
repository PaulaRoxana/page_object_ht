package org.example.modules;

import org.example.amazon_page_object.BasePage;
import org.example.amazon_page_object.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ChooseYourLocationModule extends BasePage {
    public ChooseYourLocationModule(WebDriver driver) {
        super(driver);
    }

}