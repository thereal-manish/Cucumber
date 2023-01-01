package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}

	public void switchToChild() {
		Set<String> set1=driver.getWindowHandles();
		Iterator<String> iterator1=set1.iterator();
		String parent=iterator1.next();
		String child=iterator1.next();
		driver.switchTo().window(child);
		
	}

}
