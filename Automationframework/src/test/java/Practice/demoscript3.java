package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class demoscript3 {

	public static void main(String[] args) {
		
		//step-1:-launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       
		//step-2:-login to application with valid credentials
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("KAV@12qw12");
		driver.findElement(By.id("submitButton")).click();
       
		//step-3:-navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
       
		//step-4:-click on create organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
       
		//step-5:-create contact with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("test003");
       
		
		//step-6:-select chemicals in the industry DropDown
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		industrydropdown.click();
		 Select industryselect=new Select(industrydropdown);
		 industryselect.selectByVisibleText("Chemicals");
       
		 
		 //step-7:-save and verify
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    String orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(orgname.contains("test003")) {
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


