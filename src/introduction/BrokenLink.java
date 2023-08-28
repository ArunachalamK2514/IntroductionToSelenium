package introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		
		SoftAssert sa = new SoftAssert();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));

		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

		for (int i = 0; i < footerLinks.size(); i++) {
			String url = footerLinks.get(i).getAttribute("href");
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			
			sa.assertTrue(responseCode < 400, "The url " + url + " is broken with response code: " + responseCode);
			
		}
		sa.assertAll();

	}

}
