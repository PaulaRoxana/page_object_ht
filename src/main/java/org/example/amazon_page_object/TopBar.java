package org.example.amazon_page_object;

import org.example.modules.ChooseYourLocationModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopBar extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(css = "#glow-ingress-line1")
    public WebElement deliverToButton;

    WebElement destinationBtn;
    public static final By destinationButton = By.xpath("//span[contains(text(), 'Phoenix 85001\u200C')]");
    public static final String expectedUpdatedDestination = "Phoenix 85001\u200C";

    public static final By shipToDestination = By.xpath("//span[@id='glow-ingress-line2'][contains(text(),'Poland')]");

    public static final By productsCategory = By.xpath("//div//img[@alt='Electronics']");


    public TopBar(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchMethod(String searchedElement) {
        searchBar.sendKeys(searchedElement);
        searchBar.submit();
        return new SearchResultsPage(driver);

    }

    public ChooseYourLocationModule openChooseYourLocation() {
        deliverToButton.click();
        return new ChooseYourLocationModule(driver);
    }

    public String CheckTheDestinationIsUpdated() {
        destinationBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(destinationButton));
        return destinationBtn.getText();
    }

    public HomePage withPolandAsDestination() {
        WebElement shippingDestinationBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(shipToDestination));

        return new HomePage(driver);
    }

}
