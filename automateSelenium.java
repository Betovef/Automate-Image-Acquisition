import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class automateSelenium {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		//set up scanner
		Scanner scanIn = null;
		String InputLine = "";
		String[] addresses = new String[886];
		String xfileLocation = "C:\\Users\\Alberto\\Desktop\\REU\\PythonProject\\Automate-Image-Acquisition\\addresses.csv";
		
		scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));
		
		int i = 0;
		while(scanIn.hasNextLine()) {
			InputLine = scanIn.nextLine();
			addresses[i] = InputLine;
			System.out.println(addresses[i]);
			i++;
		}
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		String[] addresses = {"430 West 6th Street Merced","905 West 8th Street Merced","909 West 8th Street Merced","945 West 8th Street Merced","956 West 8th Street Merced"  };
		
		driver.get("https://images.google.com/");
//		driver.get("https://www.redfin.com/");
//		driver.get("https://www.zillow.com/");
		WebElement elem = null;
		i = 0;
		while(i<addresses.length){
		elem = driver.findElement(By.name("q"));
		elem.sendKeys(addresses[i]);
		elem.sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).clear();
		i++;
		}
		Thread.sleep(10000);
	}

}
