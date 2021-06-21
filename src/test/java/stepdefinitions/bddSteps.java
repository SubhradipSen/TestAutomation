package stepdefinitions;


import automation.bemoblaze.bdd.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import static automation.bemoblaze.bdd.Utility.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
public class bddSteps {

	final static Logger logger = LoggerFactory.getLogger(bddSteps.class);
	public String sonyLaptopPrice = null;

    @Given("^User Opens Demoblaze website$")
    public void user_opens_demoblaze_website() throws Throwable {
		
    	//Launches the application under test.
    	launchURL(TestData.URL, TestData.browserToLaunch);

    }

    @When("^User Navigates through Product Categories Phone, Laptops and Monitors$")
    public void user_navigates_through_product_categories_phone_laptops_and_monitors() throws Throwable {
    	
    	//Clicks on 'Phones' tab and validates the prsence of product Galaxy S6
    	webElementClick(HomePage.phonesLink);
    	webElementPresent(HomePage.galaxyS6Link);
		
	    //Clicks on 'Laptops' tab and validates the prsence of product Sony Vaio i5
		webElementClick(HomePage.laptopsLink);
		webElementPresent(HomePage.sonyLink);
		
		//Clicks on 'Monitor' tab and validates the prsence of product Apple Monoitor 24
		webElementClick(HomePage.monitorsLink);
		webElementPresent(HomePage.appleMonitorLink);
    }

    @And("^User Selects Laptops to Buy$")
    public void user_selects_laptops_to_buy() throws Throwable {
    	
    	//Navigates to Laptops list and selects Sony Vaio i5
    	webElementClick(HomePage.laptopsLink);
       	webElementClick(HomePage.sonyLink);
       	
       	//Validates that appropriate product detail page is displayed
       	webElementPresent(HomePage.sonyText);
       	//waitFor(TestData.WAIT_TIME);
       	
		//Stores the price of Sony Vaio i5 in a variable for future validation of total price in Shopping Cart Page
    	retrievePrice(HomePage.laptopPrice);
		
		
		//Adds Sony Vaio i5 to shopping cart
    	webElementClick(HomePage.addToCartButton);
    	handleAlert(true);
    			
		//Navigates to Home Page and then to Laptops list and selects Dell i7 8GB 
    	webElementClick(HomePage.homeLink);
		webElementClick(HomePage.laptopsLink);
    	webElementClick(HomePage.dellLink);
		
		//Validates that appropriate product detail page is displayed
		webElementPresent(HomePage.dellText);
		
		//Adds Dell i7 8GB to shopping cart
    	webElementClick(HomePage.addToCartButton);

	    //Navigates to shopping cart page
		webElementClick(HomePage.cartLink);

    	
    }

    @Then("^The selected Laptops are displayed on Shopping Cart$")
    public void the_selected_laptops_are_displayed_on_shopping_cart() throws Throwable{
    	
    	//Verifies that both the laptops are visible on Shopping Cart page
    	webElementPresent(CartPage.sonyVaioText);
    	webElementPresent(CartPage.dellText);
		
    }

    @When("^User Removes One Item From Cart$")
    public void user_removes_one_item_from_cart() throws Throwable {
    	
        //Removes Dell i7 8GB Laptop from Shopping Cart
    	deleteItemFromCart(TestData.laptopName);
		
		//Verifies that Dell i7 8GB is no longer displayed in Shopping Cart. Also verifies Sony Vaio i5 is still present
		webElementPresent(CartPage.sonyVaioText);
		webElementNotExists(CartPage.dellText);
		
	    //Verifies that the price displayed on Shopping Cart page after removal of Dell i7 8GB laptop matches with the price of Sony Vaio i5 laptop
		validateCartValue(CartPage.cartValueText);
       
    }

    @And("^User Places an Order for The Remaining Item After Filling Out The Web Form$")
    public void user_places_an_order_for_the_remaining_item_after_filling_out_the_web_form() throws Throwable {
		
    	//Clicks on Place Order button 
    	webElementClick(CartPage.placeOrderButton);
    	
    	//Fills up the web forn with personal and credit card details to complete the purchase process
		webElementClick(CartPage.nameEdit);
		webElementClick(CartPage.cityEdit);
		webElementClick(CartPage.countryEdit);
		webElementClick(CartPage.creditCardEdit);
		webElementClick(CartPage.monthEdit);
		webElementClick(CartPage.yearEdit);
		
		//Clicks on Purchase button
		webElementClick(CartPage.purchaseButton);
    }
    
    @Then("^Corresponding Order Placement will be Successful$")
    public void corresponding_order_placement_will_be_successful() throws Throwable {
    	
    	//Prints the Order ID and Price 
    	logPurchaseInfo(CartPage.purchaseInfoText);
    }


}