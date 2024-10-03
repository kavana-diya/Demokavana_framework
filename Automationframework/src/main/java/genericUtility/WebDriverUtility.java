package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this class is to write methods in web driver
 * @author kavan
 *
 */

public class WebDriverUtility {
	
/**
 * 
 * to maximize the browser	
 * @param driver
 */
	
public void toMaximize(WebDriver driver)
{
	driver.manage().window().maximize();
	
}
/**
 * 
 * to minimize the browser
 * @param driver
 */
public void toMinimize(WebDriver driver) {
	driver.manage().window().minimize();
	
}
/**
 * 
 * methods are user to wait untill web elements are load
 * @param driver
 */
public void waitForElements(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
/**
 * 
 * this method will wait until element is clickable
 */
public void elementToBeClickable(WebDriver driver,WebElement element) {
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}
/**
 * 
 * this method will wait visibility of elements
 */
public void visibilityofelements(WebDriver driver,WebElement element) {
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOf(element));
	
	
}
/**
 * 
 * to handle drop down by using int
 * @param element
 * @param index
 */
public void toHandleDropDown(WebElement element,int index) {
	Select select = new Select(element);
	select.selectByIndex(index);
}
/**
 * 
 * to handle dropdown by using string
 * @param element
 * @param value
 */
public void toHandleDropDown(WebElement element,String value) {
	Select select = new Select(element);
	select.selectByValue(value);
}
/**
 *  * to handle dropdown by using string

 * @param text
 * @param element
 */
public void toHandleDropDown(String text,WebElement element) {
	Select select = new Select(element);
	select.selectByVisibleText(text);
}
/**
 * 
 * method is used to handle id
 * @param driver
 * @param index
 */
public void toHandleFrames(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
/**
 * 
 * methods used to handle strings
 * @param driver
 * @param id_name
 */

public void toHandleFrame(WebDriver driver,String id_name) {
	driver.switchTo().frame(id_name);
}
/**
 * 
 * methods used to handle elements
 * @param driver
 * @param element
 */
public void toHandleFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * 
 * this method is used to perform doubleclick
 * 
 */
public void toDoubleClick(WebDriver driver,WebElement element) {
	Actions action=new Actions(driver);
	action.doubleClick(element).perform();
}
/**
 * this method is to perform right click
 */
public void toRightClick(WebDriver driver,WebElement element) {
	Actions action=new Actions(driver);
	action.contextClick(element).perform();
}
/**
 * 
 * this method is used to mouse hover on the webelement
 */
public void toMouseHover(WebDriver driver,WebElement element) {
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();

}
 public void todraganddrop(WebDriver driver,WebElement src,WebElement target) {
	 Actions action=new Actions(driver);
	 action.dragAndDrop(src, target).perform();
}

}

















