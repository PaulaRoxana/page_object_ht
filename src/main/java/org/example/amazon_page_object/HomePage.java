package org.example.amazon_page_object;


import org.example.modules.ChooseYourLocationModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{


    @FindBy(css = "#glow-ingress-line1")
    private WebElement deliverToButton;

    public static final By destinationButton = By.xpath("//span[contains(text(), 'Phoenix 85001\u200C')]");

    WebElement destinationBtn;

    public static final String expectedUpdatedDestination = "Phoenix 85001\u200C";

    public static final By shipToDestination = By.xpath("//span[@id='glow-ingress-line2'][contains(text(),'Poland')]");

 public static final By productsCategory = By.xpath("//div//img[@alt='Electronics']");

                //By.xpath("//div//img[@alt='Electronics']");

////img[@src='https://m.media-amazon.com/images/I/81cg9myC9kL._AC_SY400_.jpg']
//div[@id='nav-swmslot']//a[text()='Shop top categories']

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openAmazonHomePage() {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        return this;
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

//    public ElectronicsPage withPolandAsDestinationClickOnElectronicsCategory() {
//        WebElement shippingDestinationBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(shipToDestination));
//        new WebDriverWait(driver, Duration.ofSeconds(15))
//                .until(ExpectedConditions.presenceOfElementLocated(productsCategory)).click();
//        return new ElectronicsPage(driver);
//    }


}
