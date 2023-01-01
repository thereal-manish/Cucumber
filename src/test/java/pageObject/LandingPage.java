package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By switchTabs = By.linkText("Top Deals");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");

	public void searchItem(String string) {
		driver.findElement(search).sendKeys(string);
	}

	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void swichToTopDealsTab() {
		driver.findElement(switchTabs).click();
	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public void increment(int quantity) {

		int i = quantity - 1;
		while (i > 0) {

			driver.findElement(increment).click();
			i--;
		}

	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
