import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Setting chrome driver path and Invoking chrome driver
//		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_104.exe");
//		WebDriver driver = new ChromeDriver();
		
		// Setting gecko driver path and Invoking gecko driver
//		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		// Setting edge driver path and Invoking edge driver
		System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
				
				
		driver.get("https://rahulshettyacademy.com/");
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.close();

	}

}
