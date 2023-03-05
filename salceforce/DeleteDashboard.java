package salceforce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteDashboard extends Baseclss {
	
	@Test
	public void deleteDash() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']")).sendKeys("by Mr.Kathir");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//th[@data-label='Dashboard Name']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled ignore-click-ZvfV9I6B9 menuTrigger']")).click();
		driver.findElement(By.xpath("(//a[@role='menuitem'])[4]")).click();
		driver.findElement(By.xpath("//button[@id='modalBtn1']")).click();
		
		
		
		
		
		
	}
	

}
