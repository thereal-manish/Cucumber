package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObject.CheckoutPage;
import utils.BasicsForTest;

public class CheckoutPageStepDefinitions {
	public WebDriver driver;
	public String productName;
	public String productNameConfirmation;
	BasicsForTest testBasics;
	CheckoutPage checkoutPage;

	public CheckoutPageStepDefinitions(BasicsForTest testBasics) {
		this.testBasics = testBasics;
		this.checkoutPage = testBasics.pageObjectManager.getCheckoutPage();
	}


	

	@Then("^verify the promocode and placing order$")
	public void verify_the_promocode_and_placing_order() {
		
		//this below step moved to constructor to initialize the object first
		//checkoutPage = testBasics.pageObjectManager.getCheckoutPage();
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
	}
	
	@Then("^user proceeds to checkout and validate (.+) in checkout page$")
	public void add_something_items_of_the_selected_product_to_cart(String string) throws InterruptedException {
		
		checkoutPage.checkoutItems();
		
	}

}
