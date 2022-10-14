package org.example.amazon_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BasePage{

    public static final By noResultsElement = By.xpath("//span[text()='No results for '] ");
    public static final By resultForProductToBeFound = By.xpath("//span[text()='\"laptop\"']");

    @FindBy (xpath="//a/span[contains(text(), 'Laptop') and contains(text(), 'Windows')]")
    public
    List<WebElement> actualFoundResults;
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String noResultsWereFound(){
        WebElement noResults = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(noResultsElement));
      return  noResults.getText();
    }


    public String resultsWereFound() {
        WebElement foundResults = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(resultForProductToBeFound));
        return foundResults.getText();
    }
}
