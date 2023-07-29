package webtable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class railtable {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://erail.in/");

		WebElement from = driver.findElement(By.xpath("//*[@id='txtStationFrom']"));
		from.clear();
		from.sendKeys("Tambaram", Keys.ENTER);

		Thread.sleep(3000);

		WebElement To = driver.findElement(By.xpath("//*[@id='txtStationTo']"));
		To.clear();
		To.sendKeys("CAPE", Keys.ENTER);

		/// click
		driver.findElement(By.xpath("//*[@id='buttonFromTo']")).click();

		// webtable
		Thread.sleep(2000);
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='tableTopMenu']"));
		System.out.println(table.size());

		// header
		List<WebElement> tableheader = driver.findElements(By.tagName("th"));
		System.out.println("Table header values " + tableheader.size());

		// printing header
		List<String> Headervariable = new ArrayList<String>();

		for (WebElement header : tableheader) {
			String H = header.getText();
			Headervariable.add(H);
		}
		// Header output
		System.out.println("Printing header values " + Headervariable);

		// Column<tr>

		List<WebElement> tablerow = driver.findElements(By.tagName("tr"));
		System.out.println("Table row values " + tablerow.size());

		tablerow = driver.findElements(
				By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr"));

		for (WebElement Row : tablerow) {
			String row = Row.getText();
			System.out.println(Row.getText());

		}

		
		//method normal for
		System.out.println(" %%^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^%%%%%% 1");

		System.out.println(" %%!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!%% 1");

		System.out.println(" %%%************************************%% 1");

		System.out.println("NORMAL FOR LOOP");
		for (int i = 0; i < tableheader.size(); i++) {
			WebElement Header = tableheader.get(i);
			List<WebElement> HD = Header.findElements(
					By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr"));

			String rowf = null;
			for (int j = 0; j < HD.size(); j++) {
				rowf = HD.get(j).getText();
				System.out.println(" %%%%%%% 1");
				System.out.println("for loop normal " + rowf);


			}

		}

	}
}
