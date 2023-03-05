package salceforce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditDashboard extends Baseclss{
	
	@Test
	
	public void editDashboard() throws InterruptedException {
		
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']")).sendKeys("by Mr.Kathir");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//th[@data-label='Dashboard Name']")).click();
		Thread.sleep(8000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Edit']")).click();
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
		Thread.sleep(8000);
		//driver.switchTo().frame(0);	
		 String before = driver.getTitle();  
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("salceforce");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand submitBtn']")).click();	
		driver.findElement(By.xpath("//button[@class='slds-button doneEditing']")).click();
		driver.findElement(By.xpath("//button[@id='modalBtn2']")).click();
	    String after = driver.getTitle();

	    if(before.equals(after)) {
	    	   System.out.println("The Dashboard is Edited Successfully");

	}

	}
}