package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		// to convert properties file into inStream object
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src/test//resources//global.properties");
		// to get properties file
		Properties properties = new Properties();
		properties.load(fis);
		// to get a property
		String url = properties.getProperty("QAUrl");
		String browserProp=properties.getProperty("browser");
		String mavenBrowser=System.getProperty("browser");
		
		//use ternary operator to get value from terminal if present
		String browser = mavenBrowser!=null ? mavenBrowser : browserProp;
		
		
		System.out.println(url);

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//src/test//resources//chromedriver.exe");

				driver = new ChromeDriver();
			}
			
			if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//src//test//resources//msedgedriver.exe");
			driver=new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get(url);
		}
		return driver;
	}
}
