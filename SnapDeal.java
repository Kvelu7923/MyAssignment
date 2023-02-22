package february;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SnapDeal  {
	
	ChromeDriver driver=  new ChromeDriver();

	@BeforeMethod
	public void launchUrl() {
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void purchase() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);
		builder.clickAndHold(driver.findElement(By.className("catText"))).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		String count = driver.findElement(By.xpath("//div[@class='sub-cat-count ']")).getText();
		System.out.println("Count of the shoes  "+count);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@data-index='0']")).click();
		String sortby = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		System.out.println("sortby"+sortby);
		
		WebElement findElement = driver.findElement(By.className("input-filter"));
		findElement.clear();
		findElement.sendKeys("900");
		
		WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		findElement2.clear();
		findElement2.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		driver.findElement(By.xpath("//a[text()=' Navy']")).click();
		
		String filter = driver.findElement(By.xpath("//a[@class='filter-name']")).getText();
		System.out.println("Filter "+filter);
	
		builder.moveToElement(driver.findElement(By.xpath("//img[@title='Columbus Navy Training Shoes']"))).perform();
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']")).click();
		
		String price = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		
		System.out.println("price&discount= "+price);
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snap/img.png");
		FileUtils.copyFile(screenshotAs, destination);

		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();	
	}
	@AfterMethod
	public void close() {
		driver.quit();
		
	}
	
}
