package introduction;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrollhandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", ".\\\\Drivers\\\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=2000");

		int rowCount = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr")).size();

		int sum = 0;

		for (int i = 1; i <= rowCount; i++) {
			int value = Integer.parseInt(driver
					.findElement(By.xpath("//div[@class='tableFixHead']/table/tbody/tr[" + i + "]/td[4]")).getText());
			sum = sum + value;
		}
		int totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1]);
		Assert.assertEquals(sum, totalAmount, "Value does not match!");

	}

}
