package org.example.amazon_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),\"$0.00\")]")
    private WebElement PRICE_IS_ZERO;
    public static final By DELETE_FROM_CART_BUTTON = By.xpath("//input[@value=\"Delete\"]");
    public static final By CART_EMPTY_MESSAGE = By.xpath("//h1[contains(text(),\"Your Amazon Cart is empty.\")]");

    public CartPage deleteFromCartButton(){
        WebElement deleteFromCartButton = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(DELETE_FROM_CART_BUTTON));
        deleteFromCartButton.click();
        return new CartPage(driver);
    }

    public String cartEmptyMessage(){
        WebElement cartEmptyMessage = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(CART_EMPTY_MESSAGE));
        return cartEmptyMessage.getText();
    }

    public String cartSum(){
        return PRICE_IS_ZERO.getText();
    }
}
