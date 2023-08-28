package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		
		
		// Enter the URL in the format http://username:password@siteUrl
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.partialLinkText("Basic Auth")).click();
		
		driver.close();

	}

}
