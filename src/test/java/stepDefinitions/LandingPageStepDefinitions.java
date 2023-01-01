package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import utils.BasicsForTest;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	public String productName;
	public String productNameConfirmation;
	BasicsForTest testBasics;
	LandingPage landingPage;

	public LandingPageStepDefinitions(BasicsForTest testBasics) {
		this.testBasics=testBasics;
		this.landingPage=testBasics.pageObjectManager.getLandingPage();
	}

	@Given("User is on greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		//These all moved to Base class
//		  System.setProperty("webtestBasics.driver.chrome.testBasics.driver",
//		  "C:\\Users\\manik\\Downloads\\chrometestBasics.driver_win32\\chrometestBasics.driver.exe"
//		  ); testBasics.driver = new ChromeDriver();
//		  testBasics.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		 
		//verifying title of the page
		Assert.assertTrue(landingPage.getPageTitle().contains("GreenKart"));
	}

	@When("^user search with short name (.+) and extracted actual name of the product$")
	public void user_search_with_short_name_and_extracted_actual_name_of_the_product(String string)
			throws InterruptedException {
		
		//LandingPage landingPage=new LandingPage(testBasics.driver);
		
		//below step is moved to constructor to declare it globally
		//LandingPage landingPage=testBasics.pageObjectManager.getLandingPage();
		landingPage.searchItem(string);
		//testBasics.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
		Thread.sleep(1000);
		testBasics.productName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testBasics.productName + " is extracted");
	}
	
	 @And("^add \"([^\"]*)\" items of the selected product to cart$")
	    public void add_something_items_of_the_selected_product_to_cart(String quantity) throws Throwable {
	 
		 landingPage.increment(Integer.parseInt(quantity));
	 
	 }

}
