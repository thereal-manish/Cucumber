package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import com.sun.jdi.Method;

import io.cucumber.java.en.Then;
import pageObject.LandingPage;
import pageObject.OffersPage;
import pageObject.PageObjectManager;
import utils.BasicsForTest;

public class OfferPageStepDefinitions {
	
	public String productNameConfirmation;
	BasicsForTest testBasics;
	PageObjectManager pageObjectManager;

public OfferPageStepDefinitions(BasicsForTest testBasics) {
	this.testBasics=testBasics;
}

	@Then("^user search for same (.+) in offers page$")
	public void user_search_for_same_shortname_in_offers_page_to_check_the_product_exist(String string) throws InterruptedException {

		switchTabs();
		OffersPage offersPage=testBasics.pageObjectManager.getOffersPage();
		
		//testBasics.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
		offersPage.searchItem(string);
		
		Thread.sleep(1000);
		productNameConfirmation=offersPage.getProductName();
		System.out.println(productNameConfirmation+" is from offer page");

	}
	
	public void switchTabs() {
		
		
		//below is ObjectFactory Method.class we can avoid this by using dependancy injection.
		//old code with factory
		//pageObjectManager=new PageObjectManager(testBasics.driver);
		//new code with DI
		//call with testBasics class and create constructor in testBasics class
		LandingPage landingPage=testBasics.pageObjectManager.getLandingPage();
				
		//LandingPage landingPage=new LandingPage(testBasics.driver);
				
		landingPage.swichToTopDealsTab();
		//testBasics.driver.findElement(By.linkText("Top Deals")).click();
//		Set<String> set1=testBasics.driver.getWindowHandles();
//		Iterator<String> iterator1=set1.iterator();
//		String parent=iterator1.next();
//		String child=iterator1.next();
		
		//moving all above steps into genericUtilsClass
		testBasics.genericUtils.switchToChild();

		
		
	}
	
	@Then("validate both names")
	public void validate_both_names() {
		System.out.println(testBasics.productName +"   "+ productNameConfirmation);
		Assert.assertEquals(productNameConfirmation, testBasics.productName);
	}
	
}
