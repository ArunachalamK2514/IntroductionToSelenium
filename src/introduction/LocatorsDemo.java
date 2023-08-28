package introduction;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("arunachalam");
		driver.findElement(By.name("inputPassword")).sendKeys("arunpassword");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		System.out.println(driver.findElement(By.xpath("//form/h2")).getText());
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("arunachalam");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("arunachalam@arun.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9854632155");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		String message = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(message);
		

	}

}
