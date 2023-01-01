package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.BasicsForTest;

public class Hooks {

	BasicsForTest testBasics;

	public Hooks(BasicsForTest testBasics) {
		this.testBasics = testBasics;
	}

	@After
	public void afterScenario() throws IOException {
		testBasics.base.WebDriverManager().quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			WebDriver driver=testBasics.base.WebDriverManager();
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileCintent=FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileCintent, "image/png", "image");
		}
		
	}
	

}
