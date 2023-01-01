package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By bag = By.xpath("//img[@alt='Cart']");
	By checkout = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promocode = By.xpath("//button[@class='promoBtn']");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

	public void checkoutItems() throws InterruptedException {
		driver.findElement(bag).click();
		Thread.sleep(1000);
		driver.findElement(checkout).click();
	}

	public boolean verifyPromoButton() {
		return driver.findElement(promocode).isDisplayed();
	}

	public boolean verifyPlaceOrderButton() {
		return driver.findElement(placeOrder).isDisplayed();
	}
}
