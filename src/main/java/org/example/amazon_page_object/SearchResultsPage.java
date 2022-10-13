package org.example.amazon_page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//span[contains(@class, 'a-size-mini')][contains(@class, 'a-spacing-none')][contains(@class, 'a-color-base')][contains(@class, 's-line-clamp-2')]")
    private List<WebElement> pageObjectSearchResultsForSonyLocator;
    @FindBy(xpath = "//*[contains(@class, 'a-size-base')][text() = 'Sony']//preceding-sibling::*")
    private WebElement sonyLocator;
    @FindBy(xpath = "//*[contains(text(),'$200 & Above')]")
    private WebElement priceLocator;
    @FindBy(xpath = "//div[contains(@class,'puis-include-cont')]//span[contains(@class,'a-price-whole')]")
    private List<WebElement> searchResultsAccordingToPriceLocator;
    @FindBy(className = "a-dropdown-label")
    private WebElement sortLocator;
    @FindBy(xpath = "//*[@id=\"s-result-sort-select_1\"]")
    private WebElement sortFromLowToHighLocator;
    @FindBy(className="a-dropdown-prompt")
    private WebElement assertionElementAfterSorting;
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage clickOnSony(){
        sonyLocator.click();
        return new SearchResultsPage(driver);
    }
    public List<WebElement> returnSearchResultsForSony(){
        return pageObjectSearchResultsForSonyLocator;
    }
    public SearchResultsPage clickOnPriceRangeOption(){

        priceLocator.click();
        return new SearchResultsPage(driver);
    }
    public List<WebElement> returnSearchResultsForPriceRangeOption(){

        return searchResultsAccordingToPriceLocator;
    }
    public SearchResultsPage clickOnSort(){

        sortLocator.click();
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage clickOnSortFromLowToHigh(){

        sortFromLowToHighLocator.click();
        return new SearchResultsPage(driver);
    }
    public String getTextOfAssertionElementAfterSorting(){

        return assertionElementAfterSorting.getText();
    }

}
