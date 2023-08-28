package introduction;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\\\Drivers\\\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (handle != parentWindow) {
				driver.switchTo().window(handle);
			}
		}
		String username = driver.findElement(By.cssSelector("p.im-para.red a")).getText().split("@")[1].split("\\.")[0];
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

	}

}
