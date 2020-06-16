import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class automateSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] addresses = {"430 West 6th Street Merced","905 West 8th Street Merced","909 West 8th Street Merced","945 West 8th Street Merced","956 West 8th Street Merced"  };
		
		driver.get("https://images.google.com/");
		WebElement elem = null;
		int i=0;
		while(i<4){
		elem = driver.findElement(By.name("q"));
		elem.sendKeys(addresses[i]);
		elem.sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).clear();
		i++;
		}
		Thread.sleep(10000);
	}

}
