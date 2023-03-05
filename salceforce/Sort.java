package salceforce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Sort extends Baseclss{
	
	@Test
	public void sortDashboard() {
		
		
		String title = driver.getTitle();
		driver.findElement(By.xpath("//a[@data-navigation='enable']")).click();
		String title2 = driver.getTitle();
		
		if(title.equals(title2)) {
			System.out.println("descending ");
		}else {
			System.out.println("dashboard displayed by Ascending order");
		}
			
		
		
	}

}
