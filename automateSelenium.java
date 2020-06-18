import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class automateSelenium {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		//set up scanner
		Scanner scanIn = null;
		String InputLine = "";
		String[] addresses = new String[971]; //size of the number of addresses
		String xfileLocation = "C:\\Users\\Alberto\\Desktop\\REU\\PythonProject\\Automate-Image-Acquisition\\LotCurrentAddressImages.csv"; //path where the data is located
		
		scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));
		
		// importing data from csv file to a string array
		int i = 0;
		while(scanIn.hasNextLine()) {
			InputLine = scanIn.nextLine();
			addresses[i] = InputLine;
//			System.out.println(addresses[i]); //print addresses 
			i++;
		}
		
		// setting up web driver
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe"); //path to where the chrome driver is located
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);

		driver.get("https://www.google.com/maps");
//		driver.get("https://www.redfin.com/");
//		driver.get("https://www.zillow.com/");
		
		WebElement elem = null;
		i = 0;
		
		// setting up csv file writer (for created csv files and data extraction)
		
//		try {
//			PrintWriter pw = new PrintWriter(new File("C:\\Users\\Alberto\\Desktop\\REU\\PythonProject\\Automate-Image-Acquisition\\ImagesDatasetTest1.csv"));
//			StringBuilder sb = new StringBuilder();
//			
////			sb.append("Address");
////			sb.append("\r\n");
//			
//			while(i<addresses.length) {
//				sb.append(addresses[i]);
//				sb.append("\r\n");
//				i++;
//			}
//			pw.write(sb.toString());
//			pw.close();
//			
//		} catch (Exception e) {
//			
//		}
		
//		 automating... 
		while(i < addresses.length){
			try {
				elem = driver.findElement(By.id("searchboxinput"));
				elem.sendKeys(addresses[i]);
				elem.sendKeys(Keys.ENTER);
				Thread.sleep(2500);
				
				//Code to obtain image address
//				elem = driver.findElement(By.xpath("/html/body/jsl/div[3]/div[9]/div[8]/div/div[1]/div/div/div[1]/div[1]/button/img")); //xpath can be obtained form inspect
//				System.out.println(elem.getAttribute("src"));
				
				//Code to obtain text from web 
				act.moveToElement(driver.findElement(By.xpath("/html/body/jsl/div[3]/div[9]/div[8]/div/div[1]/div/div/div[1]/div[1]/button/img"))).click().build().perform();
				Thread.sleep(3000);
				elem = driver.findElement(By.xpath("/html/body/jsl/div[3]/div[9]/div[25]/div/div[1]/div/div/span[7]/span/span/span"));
				System.out.println(elem.getText());
				
				act.moveToElement(driver.findElement(By.xpath("/html/body/jsl/div[3]/div[9]/div[8]/div/div[1]/div/div/div[1]/button[1]/div/img"))).click().build().perform();
				Thread.sleep(2000);
				driver.findElement(By.name("q")).clear();
			} catch(NoSuchElementException e) {
				System.out.println("Element does not exist");
				driver.findElement(By.name("q")).clear();
			}
		i++;
		}
	}

}
