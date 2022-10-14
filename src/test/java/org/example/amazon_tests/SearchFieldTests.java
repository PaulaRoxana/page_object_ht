package org.example.amazon_tests;

import org.example.amazon_page_object.HomePage;
import org.example.amazon_page_object.SearchResultsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchFieldTests extends BaseTests {

    @Test
    public void checkNoResultsForIncorrectInfoInSearchField() {
        HomePage amazonHomePage = new HomePage(driver);
        String noResultsVisibleText = amazonHomePage
                .openAmazonHomePageAndJustGoToTopBar()
                .searchMethod("ggdhtjydyfiuyoiupio[o;oi777777777777777.")
                .noResultsWereFound();

        assertEquals(noResultsVisibleText, "No results for", "The text should contain: No results for");
    }

    @Test
    public void checkResultsForCorrectInfoInSearchField() {
        HomePage amazonHomePage = new HomePage(driver);
        String resultsVisibleText = amazonHomePage
                .openAmazonHomePageAndJustGoToTopBar()
                .searchMethod("laptop")
                .resultsWereFound();

        assertEquals(resultsVisibleText, '"'+"laptop"+'"', "The text should contain: 'laptop'");

    }

    @Test
    public void checkFoundElementsContainSearchedInfo() {
        HomePage amazonHomePage = new HomePage(driver);
       List<WebElement>listOfActualResults = amazonHomePage
                .openAmazonHomePageAndJustGoToTopBar()
                .searchMethod("laptop")
                .actualFoundResults;

        assertTrue(listOfActualResults.stream()
                .filter(webElement -> webElement.getText().contains("Laptop")).count() >=10);
    }

}
