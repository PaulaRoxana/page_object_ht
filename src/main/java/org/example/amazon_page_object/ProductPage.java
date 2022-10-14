package org.example.amazon_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{

//    @FindBy(xpath = "//span[contains(text(), 'Amazon Basics 48 Count (Pack of 1)')]")
//    public WebElement aProductToShip;

  //  public static final By shippingDestination = By.xpath("(//span[text()=' No Import Fees Deposit & $14.02 Shipping to Poland '])[3]");

    @FindBy(xpath = "(//span[contains(text(), 'Fiodio Mechanical Gaming Keyboard')])[1]")
    public static WebElement aProductToShip;

    public  static final By shippingDestination = By.xpath("(//span[contains(text(), 'Shipping to Poland')])[1]");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public String productsAreShippingToPoland(){
        aProductToShip.click();
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(shippingDestination)).getText();

    }

}
