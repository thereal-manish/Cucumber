package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObject.PageObjectManager;

public class BasicsForTest {
	public WebDriver driver;
	public String productName;
	public String productNameConfirmation;
	public PageObjectManager pageObjectManager;
	public Base base;
	public GenericUtils genericUtils;
	
	
	public BasicsForTest() throws IOException {
	
		base=new Base();
		pageObjectManager=new PageObjectManager(base.WebDriverManager());
		genericUtils=new GenericUtils(base.WebDriverManager());
	}
	
}
