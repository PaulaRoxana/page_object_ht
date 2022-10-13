//package org.example.modules;
//
//import org.example.amazon_page_object.BasePage;
//import org.example.amazon_page_object.HomePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//
//
//public class ChooseYourLocationModule extends BasePage {
//
//    private static final By zipCodeField = By.id("GLUXZipUpdateInput");
//    private static final String USZipCode = "85001";
//    /**
//     * US zip code list here -> https://vanwilson.info/2014/11/sample-zip-codes-50-states/
//     */
//    @FindBy(xpath = "//span[@id = 'GLUXZipUpdate']//input")
//    private WebElement applyButton;
//    private static final By continueButton = By.xpath("//div[@class='a-popover-footer']//input");
//
//    private static final By dropdownButton = By.xpath("//span[@role='radiogroup']");
//
//    @FindBy(xpath = "//div[contains(@class, 'a-popover-inner')][contains(@class, 'a-lgtbox-vertical-scroll')]//a")
//    private List<WebElement> allCountriesList;
//    public static final String specificCountry = "Poland";
//    public static final By Poland = By.xpath("//a[@id='GLUXCountryList_178']");
//
//    @FindBy(xpath = "//button[@name='glowDoneButton']")
//    private WebElement doneButton;
//
//
//    // public static final By shipToDestination =  By.xpath("//span[@id='glow-ingress-line2'][contains(text(),'Poland')]");
//
//
//    public ChooseYourLocationModule(WebDriver driver) {
//        super(driver);
//    }
//
//    public HomePage enterUSZipCodeForDestination() {
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(zipCodeField)).sendKeys(USZipCode);
//        applyButton.click();
//        new WebDriverWait(driver, Duration.ofSeconds(2))
//                .until(ExpectedConditions.presenceOfElementLocated(continueButton))
//                .click();
//        return new HomePage(driver);
//    }
//
//    public void clickOnCountriesDropDown() {
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(dropdownButton))
//                .click();
//    }
//
//    public String checkThatTheListOfCountriesContainsASpecificCountry() {
//        clickOnCountriesDropDown();
//        return allCountriesList
//                .stream()
//                .map(WebElement::getText)
//                .filter(s -> s.equals(specificCountry))
//                .toList()
//                .toString();
//    }
//
//    public HomePage choosePolandFromTheListOfCountries() {
//        clickOnCountriesDropDown();
//        WebElement polandOption = new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(ExpectedConditions.presenceOfElementLocated(Poland));
//        polandOption.click();
//        doneButton.click();
//        return new HomePage(driver);
//    }
//
//}
//
//
//
