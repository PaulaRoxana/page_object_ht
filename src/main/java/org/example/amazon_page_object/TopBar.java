package org.example.amazon_page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBar extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    public TopBar(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchMethod(String searchedElement) {
        searchBar.sendKeys(searchedElement);
        searchBar.submit();
        return new SearchResultsPage(driver);

    }

}
