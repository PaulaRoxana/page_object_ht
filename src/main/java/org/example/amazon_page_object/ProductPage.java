package org.example.amazon_page_object;

import org.example.modules.ConfirmationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{
    public static final By ADD_TO_CART = By.xpath("//input[@id=\"add-to-cart-button\"]");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmationMessage addToCart(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART))
                .click();
        return new ConfirmationMessage(driver);
    }
}
