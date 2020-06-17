import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;
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
		String[] addresses = new String[886]; //size of the number of addresses
		String xfileLocation = "C:\\Users\\Alberto\\Desktop\\REU\\PythonProject\\Automate-Image-Acquisition\\addresses.csv";
		
		scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));
		
		// importing data from csv file to a string array
		int i = 0;
		while(scanIn.hasNextLine()) {
			InputLine = scanIn.nextLine();
			addresses[i] = InputLine;
			System.out.println(addresses[i]); //we don't need to print 
			i++;
		}
		
		// setting up web driver
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/maps");
//		driver.get("https://www.redfin.com/");
//		driver.get("https://www.zillow.com/");
		
		WebElement elem = null;
		i = 0;
		
		// setting up csv file writer
		
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
		String text = "";
		while(i<addresses.length){
		elem = driver.findElement(By.id("searchboxinput"));
		elem.sendKeys(addresses[i]);
		elem.sendKeys(Keys.ENTER);
//		text = elem.getAttribute("src");
//		img = driver.findElement(By.)
		Thread.sleep(4000);
		elem = driver.findElement(By.xpath("/html/body/jsl/div[3]/div[9]/div[8]/div/div[1]/div/div/div[1]/div[1]/button/img"));
		System.out.println(elem.getAttribute("src"));
		driver.findElement(By.name("q")).clear();
		i++;
		}
	}

}
