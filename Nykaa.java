package february;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Nykaa {

	ChromeDriver driver = new ChromeDriver();

	@BeforeMethod
	public void login() {
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void lOrealParis() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);
		builder.clickAndHold(driver.findElement(By.xpath("//a[text()='brands']"))).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal paris");
		driver.findElement(By.xpath("(//img[@alt='banner'])[5]")).click();
		
		String tittle=driver.getTitle();
		System.out.println("Tittle   "+tittle);
		
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();	
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	
		
		String text = driver.findElement(By.className("css-19j3ean")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//span[text()='MRP:']")).click();
		
		Set<String>windowHandles=driver.getWindowHandles();
		List<String>list =new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		
		String mrp= driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		System.out.println("price=  "+mrp);
		
		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
		driver.switchTo().frame(0);
		String grandtotal= driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']/span")).getText();
		System.out.println("GrandTottal=  "+grandtotal);

		
		driver.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d4']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).click();
		//driver.switchTo().defaultContent();

		String finalprice=driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		System.out.println("final price=  "+finalprice);
		
		if(finalprice.equals(grandtotal)) {
			System.out.println("Grand Total is same as final price");
		}
	}
	@AfterMethod
	public void closeAllWindows() {
		
		driver.quit();
	}
	

}
