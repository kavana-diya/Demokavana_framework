package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demoscript4 {
	
	public static void main(String[] args) {
		//step-1:-launch the browser
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
		//step-2:-login to applications with valid credentials
			driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("KAV@12qw12");
			driver.findElement(By.id("submitButton")).click();
			
        //step-3:-navigate to contacts
			driver.findElement(By.linkText("Contacts")).click();
			
		//step-4:-create contact lookup image
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
		//step-5:-create contacts with mandatory fields
			driver.findElement(By.name("lastname")).sendKeys("patil");
			
	    //step-6:-select organization from organization look up image
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		    driver.findElement(By.name("accountname")).sendKeys("qspider");
		
			
			 //step-7:-save and verify
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    String orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		    if(orgname.contains("qspider")) {
		    System.out.println(orgname+"--passed");
		    }else {
			System.out.println(orgname+"--failed");
					}
	       
		    //step-8:-logout of application
	         WebElement logoutele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	         Actions action=new Actions(driver);
	        action.moveToElement(logoutele).perform();
	        driver.findElement(By.linkText("Sign Out")).click();
	        //step-9:-close the browser
	        driver.quit();
	}		
			
}
