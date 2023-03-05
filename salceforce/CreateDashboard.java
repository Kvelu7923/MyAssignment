package salceforce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateDashboard extends Baseclss {

	@Test
	public void newDashBoard() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();

		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Salceforce Automation by Mr.Kathir");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand submitBtn']")).click();
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String before = driver.getTitle();

		driver.findElement(By.xpath("//button[text()='Done']")).click();
		String after = driver.getTitle();

		if (before.equals(after)) {
			System.out.println("The New Dashboard is created Successfully");
		}
	}
	}
