package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Petrolprice {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.globalpetrolprices.com/diesel_prices/");

		Thread.sleep(2000);

		WebElement USA = driver.findElement(By.partialLinkText("USA*"));
		USA.click();
		Thread.sleep(2000);
		/*
		 * String Country = USA.getText(); System.out.println("Petrol Price of " +
		 * Country);
		 */

		List<WebElement> Table = driver.findElements(By.tagName("table"));
		Table.get(0);

		List<WebElement> Tableheader = driver.findElements(By.tagName("th"));

		for (WebElement TBLHEADER : Tableheader) {
			String header = TBLHEADER.getText();
			System.out.println(header);

		}

		List<WebElement> Td = driver.findElements(By.tagName("td"));

		for (WebElement Tdvalue : Td) {
			String row = Tdvalue.getText();
			System.out.println(row);

		}
	}
}