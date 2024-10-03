package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.graphbuilder.curve.CatmullRomSpline;

public class DemoscriptwithDDT {

	public static void main(String[] args) throws IOException {
        //TO read from property file
		FileInputStream pfis=new FileInputStream(".\\src\\main\\resources\\commonDataPropertiies");
		Properties prop=new Properties();
		prop.load(pfis);
		
		String BROWSER = prop.getProperty("browser");
		String URL= prop.getProperty("url");
		String USERNAME=prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");
		
		//to read data from excel file
		FileInputStream efis=new FileInputStream(".\\src\\main\\resources\\Testdat5.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		String lastname=wb.getSheet("Contact").getRow(1).getCell(2).toString();
		
		
		//to test script
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
			}else if(BROWSER.equals("edge")) {
				driver= new EdgeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	//step-2:-login to applications with valid credentials
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
    //step-3:-navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
	//step-4:-create contact lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	//step-5:-create contacts with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
	//step-6:-save and verify
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    String orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(orgname.contains(lastname)) {
	    System.out.println(orgname+"--passed");
	    }else {
		System.out.println(orgname+"--failed");
				}
       
	    //step-7:-logout of application
         WebElement logoutele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         Actions action=new Actions(driver);
        action.moveToElement(logoutele).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        //step-9:-close the browser
        driver.quit();
		
		}
		
	}


