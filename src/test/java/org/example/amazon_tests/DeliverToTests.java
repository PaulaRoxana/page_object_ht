package org.example.amazon_tests;

import org.example.amazon_page_object.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.amazon_page_object.TopBar.expectedUpdatedDestination;
import static org.example.modules.ChooseYourLocationModule.specificCountry;


public class DeliverToTests extends BaseTests {


    @Test
    public void verifyThatDeliverToValueIsUpdated() {

        HomePage amazonHomePage = new HomePage(driver);
        String updatedDestination = amazonHomePage
                .openAmazonHomePageAndJustGoToTopBar()
                .openChooseYourLocation()
                .enterUSZipCodeForDestination("85001")
                .CheckTheDestinationIsUpdated();

        Assert.assertEquals(updatedDestination, expectedUpdatedDestination,
                "The new destination should be: Phoenix 85001");
    }

    @Test
    public void checkCountriesListContainsPoland() {
        HomePage amazonHomePage = new HomePage(driver);
        String chosenCountry = amazonHomePage
                .openAmazonHomePageAndJustGoToTopBar()
                .openChooseYourLocation()
                .checkThatTheListOfCountriesContainsASpecificCountry();

        Assert.assertEquals(chosenCountry.replace("[", "")
                .replace("]", ""), specificCountry, "The country should be" + specificCountry);

    }

    @Test
    public void checkShippingToCountry()  {

        HomePage amazonHomePage = new HomePage(driver);
        String shippingToPoland = amazonHomePage
                .openAmazonHomePageAndJustGoToTopBar()
                .openChooseYourLocation()
                .choosePolandFromTheListOfCountries()
                .withPolandAsDestination()
                .clickOnElectronicsCategory()
                .productsAreShippingToPoland();

               Assert.assertTrue(shippingToPoland.contains("Shipping to Poland"), "This product should ship to Poland");


    }

}
