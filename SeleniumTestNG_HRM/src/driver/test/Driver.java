package driver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Driver {

	public WebDriver driver;

	public BaseDriver(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

}
