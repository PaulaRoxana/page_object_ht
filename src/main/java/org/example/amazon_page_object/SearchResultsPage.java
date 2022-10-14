package org.example.amazon_page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//img[starts-with(@alt,\"Redragon S101\")]")
    private WebElement REDRAGON_KEYBOARD;
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    public ProductPage clickRedragon(){
        REDRAGON_KEYBOARD.click();
        return new ProductPage(driver);
    }

}
