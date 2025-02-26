package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.searchPage;
import util.driverFactory;

public class searchStepDefinitions {
    searchPage searchPage = new searchPage(driverFactory.getDriver());

    @Given("Akakce application opens")
    public void AkakceApplicationOpens() {
        searchPage.AkakceApplicationOpensPage();
    }

    @When("Continue without signing up")
    public void continueWithoutSigningUp() {
        searchPage.continueWithoutSigningUpPage();
    }

    @And("Search for laptop in the search bar")
    public void searchForLaptopInTheSearchBar() {
        searchPage.searchForLaptopInTheSearchBarPage();
    }

    @And("See Products filter is applied")
    public void SeeProductsFilterApplied() {
        searchPage.filteredPage();
    }

    @And("Category selection is made")
    public void categorySelectionIsMade() {
        searchPage.categorySelectionIsMadePage();
    }

    @And("The product with the highest price is selected")
    public void theProductWithTheHighestPriceIsSelected() {
        searchPage.theProductWithTheHighestPriceIsSelectedPage();
    }

    @Then("Go to seller button is verified")
    public void goToSellerButtonIsVerified() {
        searchPage.goToSellerButtonIsVerifiedPage();
    }
}
