package february;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazon {

	ChromeDriver driver = new ChromeDriver();

	@BeforeMethod
	public void login() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void oneplus() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String mobileprice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("1st mobile price=  " + mobileprice);

		String ratings = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
		System.out.println("Ratings  " + ratings);

		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));

		Thread.sleep(2000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/img.png");
		FileUtils.copyFile(screenshotAs, destination);

		driver.findElement(By.id("add-to-cart-button")).click();
		String subtotal = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("subtotal "+subtotal);

		if (subtotal.equals(mobileprice)) {
			System.out.println("verified");
		}
	}
	@AfterMethod
	public void closebrowser() {
		driver.quit();
		
	}
}
