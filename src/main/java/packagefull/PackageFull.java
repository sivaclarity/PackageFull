package packagefull;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.SearchItem;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FifthPackage.Fifth;
import FourthPage.Fourth;
import SearchPage.Search;
import SecondPage.Second;
import ThirdPage.Third;
import paymentpage.Payment;
import extentreport.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PackageFull {
<<<<<<< HEAD
	public WebDriver driver = null;

=======
	public WebDriver driver=null;
	private String baseUrl;
>>>>>>> a823669ced5816ad11d2237802df1fa50b092106
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;
	public String parent = null;
	String child =null;
	
	@Test
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(Search.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
	}

<<<<<<< HEAD
	@Test(dependsOnMethods = "setup")
	public void SearchPage() throws Exception {

		driver.findElement(Search.HotelButton).click();
		driver.findElement(Search.HotelRadio).click();
		driver.findElement(Search.TextBox).click();
		driver.findElement(Search.TextBox).clear();
		driver.findElement(Search.TextBox).sendKeys("yyz");
		driver.findElement(Search.TextOptions).click();
		driver.findElement(Search.FromDate).click();
		driver.findElement(Search.ToDate).click();
		driver.findElement(Search.Done).click();
		driver.findElement(Search.SearchButton).click();
	}

	@Test(dependsOnMethods = "SearchPage")
	public void SecondPage() throws InterruptedException {

		WebDriverWait waits = new WebDriverWait(driver, 30);
		waits.until(ExpectedConditions.visibilityOfElementLocated(Second.LinkText));

		driver.findElement(Second.FreeBreakfast).click();
//		WebDriverWait wait =new WebDriverWait(driver ,30);
//		wait.until(ExpectedConditions.elementToBeClickable(Second.PriceCheckBox));
		WebElement element = driver.findElement(Second.PriceCheckBox);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(Second.PriceCheckBox).click();
		driver.findElement(Second.HealthCheckBox).click();
		driver.findElement(Second.LinkText).click();
		driver.findElement(Second.BusinessProperty).click();
		driver.findElement(Second.AvailabeRooms).click();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = "SecondPage")
	public void ThirdPage() {

		driver.findElement(Third.Book).click();

	}

	@Test(dependsOnMethods = "ThirdPage")
	public void FourthPage() throws InterruptedException {
		driver.findElement(Fourth.FirstName).click();
		driver.findElement(Fourth.FirstName).clear();
		driver.findElement(Fourth.FirstName).sendKeys("siva");
		driver.findElement(Fourth.LastName).click();
		driver.findElement(Fourth.LastName).clear();
		driver.findElement(Fourth.LastName).sendKeys("ka");
		driver.findElement(Fourth.Tel).click();
		driver.findElement(Fourth.Tel).clear();
		driver.findElement(Fourth.Tel).sendKeys("8838737525");
		Thread.sleep(3000);
		driver.findElement(Fourth.WheelChair).click();
		driver.findElement(Fourth.Email).click();
		driver.findElement(Fourth.Email).clear();
		driver.findElement(Fourth.Email).sendKeys("siva@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(dependsOnMethods = "FourthPage")
	public void FifthPage() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Fifth.city));
		driver.findElement(Fifth.AddressLine).click();
		driver.findElement(Fifth.AddressLine).clear();
		driver.findElement(Fifth.AddressLine).sendKeys("155");
		driver.findElement(Fifth.CountryClick).click();
		driver.findElement(Fifth.CountrySelect).click();
		driver.findElement(Fifth.Pincode).clear();
		driver.findElement(Fifth.Pincode).sendKeys("605004");
		driver.findElement(Fifth.StateClick).click();
		driver.findElement(Fifth.StateSelect).click();
		driver.findElement(Fifth.city).clear();
		driver.findElement(Fifth.city).sendKeys("pondy");
		driver.findElement(Fifth.Confirm).click();
		driver.findElement(Fifth.Submit).click();
		Thread.sleep(5000);
	}
 @Test(dependsOnMethods = "FifthPage")
 public void Payment() throws InterruptedException {
	
	 Thread.sleep(3000);
//		String = driver.getWindowHandle();
		 
	
		  Set <String> handles =driver.getWindowHandles();
		  Iterator<String> it = handles.iterator(); 
		  //iterate through your windows 
		 // while (it.hasNext()){
		
		   parent = it.next(); 
		   child = it.next();
		 
		  if(!parent.equals(child)) {
			  driver.switchTo().window(child); 
		  }
		//		  System.out.println("SecondPage is :"+ driver.getTitle());
			  driver.findElement(Payment.CardClick).click();
			  driver.findElement(Payment.CardEnter). sendKeys("4111111111111111"); 
			  driver.findElement(Payment.ExpiryMonth).sendKeys("10");;
			  driver.findElement(Payment.ExpiryYear).sendKeys("26");
			  driver.findElement(Payment.Cvv).sendKeys("123");
			  driver.findElement(Payment.Submit).click() ;
			  driver.findElement(Payment.Success).click(); 
			  Thread.sleep(2000);
			 
		  }
		 
	/*
	 * @Test(dependsOnMethods = "FifthPage") public void ExtentReporter() throws
	 * InterruptedException, IOException { ExtentReport r1 = new ExtentReport();
	 * r1.setExtent(); r1.screenshot(null, driver);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
=======
	@Test
	public void testUntitledTestCase() throws Exception {
		driver.get("https://b2cui2.tltid.com/pa");
		driver.manage().window().maximize();
		String parentHandle = driver.getWindowHandle();
		System.out.println("FirstPage is :" + driver.getTitle());

		driver.findElement(By.xpath("//span[contains(text(),'Hotels')]")).click();
		driver.findElement(By.xpath("//span[text()='Hotel']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter a Hotel Name or Destination']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter a Hotel Name or Destination']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter a Hotel Name or Destination']")).sendKeys("yyz");
		driver.findElement(By.xpath("//span[contains(text(),'Toronto, ON, Canada (YYZ-Pearson Intl.) ')]")).click();

		driver.findElement(By.xpath("//div[@date='2022-02-14']")).click();
		// driver.findElement(By.xpath("//button[@aria-label='Move forward to switch to
		// the next month.']")).click();
		driver.findElement(By.xpath("//div[@date='2022-02-28']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		WebDriverWait waits = new WebDriverWait(driver, 30);
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Themes/Types")));
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Free breakfast']/parent::*")).click();
		driver.findElement(By.xpath("//div[3]/div/div/div[2]/div/fieldset[4]/div/div/label")).click();
		driver.findElement(By.xpath("//div[7]/fieldset/div/div/label")).click();
		driver.findElement(By.linkText("Themes/Types")).click();
		driver.findElement(By.xpath("//div[9]/div[2]/fieldset[2]/div/div/label")).click();
		driver.findElement(By.xpath("//div[8]/div/div/div[2]/div/div/div[3]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Book Now']")).click();
		driver.findElement(By.xpath("//input")).click();
		driver.findElement(By.xpath("//input")).clear();
		driver.findElement(By.xpath("//input")).sendKeys("siva");
		driver.findElement(By.xpath("//div[2]/div/div/input")).click();
		driver.findElement(By.xpath("//div[2]/div/div/input")).clear();
		driver.findElement(By.xpath("//div[2]/div/div/input")).sendKeys("ka");
		driver.findElement(By.xpath("//input[@type='tel']")).click();
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("8838737525");
		driver.findElement(By.xpath("//fieldset/div/div/div[2]/label")).click();
		driver.findElement(By.xpath("//div[3]/div/div/div/div/input")).click();
		driver.findElement(By.xpath("//div[3]/div/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div/div/div/div/input")).sendKeys("siva@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/div/div/input")));
		driver.findElement(By.xpath("//div[2]/div/div/input")).click();
		driver.findElement(By.xpath("//div[2]/div/div/input")).clear();
		driver.findElement(By.xpath("//div[2]/div/div/input")).sendKeys("155");
		driver.findElement(By.xpath("//div[@class='multiselect__tags']")).click();
		driver.findElement(By.xpath("//span[text()='Afghanistan']")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[5]")).clear();
		driver.findElement(By.xpath("(//input[@class='form-control'])[5]")).sendKeys("605004");
		driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Badakhshan']")).click();
		driver.findElement(By.xpath("//div[6]/div/div/input")).clear();
		driver.findElement(By.xpath("(//input[@class='form-control'])[4]")).sendKeys("pondy");
		driver.findElement(By.xpath("//div[@class='custom-control custom-checkbox']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.quit();
	
	}
	@AfterClass(alwaysRun = true)
	
	public void close()
	{
		if(driver!=null)
		driver.quit();
	}

	
	/*
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].scrollIntoView(true);");
	 */
	/*
	 * WebElement card
	 * =driver.findElement(By.xpath("//div[@class='_3-zL border-global']")); String
	 * print = card.getText(); System.out.println("Text: "+print);
	 */
	/*
	 * Alert alert = driver.switchTo().alert();
	 * 
	 * // Capturing alert message. String alertMessage=
	 * driver.switchTo().alert().getText();
	 * 
	 * // Displaying alert message System.out.println(alertMessage);
	 * Thread.sleep(5000);
	 */
	// Switch to new window opened

	/*
	 * for(String winHandle : driver.getWindowHandles()){
	 * driver.switchTo().window(winHandle);
	 * 
	 * System.out.println("Text: "+driver.getCurrentUrl()); }
	 * 
	 * int scroll=0; do { try {
	 * 
	 * WebElement elem = driver.findElement(By.
	 * xpath("//main[@class='h100 fb-wrap-content-padding auto-overflow']"));
	 * elem.click(); elem.sendKeys(Keys.PAGE_DOWN);
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 5);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("//div[@class='_3-zL border-global']"))); break; } catch(Exception e) {
	 * 
	 * } WebElement elem =driver.findElement(By.xpath("//div[@class='box-title']"));
	 * elem.click(); elem.sendKeys(Keys.PAGE_DOWN); scroll++; } while (scroll<6);
	 */
	// get the current window handle

	/*
	 * for (String handle: driver.getWindowHandles()) { if
	 * (!parentHandle.equals(handle)) driver.switchTo().window(handle); }
	 */
	/*
	 * Set <String> handles =driver.getWindowHandles(); Iterator<String> it =
	 * handles.iterator(); //iterate through your windows while (it.hasNext()){
	 * String parent = it.next(); String newwin = it.next();
	 * driver.switchTo().window(newwin); }
>>>>>>> a823669ced5816ad11d2237802df1fa50b092106
	 */
	/*
	 * driver.getWindowHandles().size(); driver.switchTo().window[3];
	 * 
	 * System.out.println("SecondPage is :"+ driver.getTitle());
	 * driver.findElement(By.xpath("//div[@class='_3-zL border-global']")).click();
	 * driver.findElement(By.xpath("//input[@placeholder='Card Number']")).
	 * sendKeys("4111 1111 1111 1111 111"); driver.findElement(By.
	 * xpath("//div[@class='_3cLE  border-global xs-form-ctrl on-focus']")).sendKeys
	 * ("1026");
	 * driver.findElement(By.xpath("//input[@placeholder='CVV']")).sendKeys("123");
	 * driver.findElement(By.
	 * xpath("(//button[@class='btn btn-primary w100 pos-r _2fNU   '])[2]")).click()
	 * ; driver.findElement(By.xpath("//button[@onclick='submitSuccess()']")); //
	 * ERROR: Caught exception [unknown command []]
	 */ // ERROR: Caught exception [unknown command []]

	
	  @AfterSuite(alwaysRun = true)
	  
	  public void close() { if (driver != null) driver.quit(); }
	 

	/*
<<<<<<< HEAD
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].scrollIntoView(true);");
	 */
	/*
	 * WebElement card
	 * =driver.findElement(By.xpath("//div[@class='_3-zL border-global']")); String
	 * print = card.getText(); System.out.println("Text: "+print);
	 */
	/*
	 * Alert alert = driver.switchTo //if(driver!=null) //driver.quit(); ().alert();
	 * 
	 * // Capturing alert message. String alertMessage=
	 * driver.switchTo().alert().getText();
	 * 
	 * // Displaying alert message System.out.println(alertMessage);
	 * Thread.sleep(5000);
	 */
	// Switch to new window opened

	/*
	 * for(String winHandle : driver.getWindowHandles()){
	 * driver.switchTo().window(winHandle);
	 * 
	 * System.out.println("Text: "+driver.getCurrentUrl()); }
	 * 
	 * int scroll=0; do { try {
	 * 
	 * WebElement elem = driver.findElement(By.
	 * xpath("//main[@class='h100 fb-wrap-content-padding auto-overflow']"));
	 * elem.click(); elem.sendKeys(Keys.PAGE_DOWN);
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 5);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("//div[@class='_3-zL border-global']"))); break; } catch(Exception e) {
	 * 
	 * } WebElement elem =driver.findElement(By.xpath("//div[@class='box-title']"));
	 * elem.click(); elem.sendKeys(Keys.PAGE_DOWN); scroll++; } while (scroll<6);
	 */
	// get the current window handle

	/*
	 * for (String handle: driver.getWindowHandles()) { if
	 * (!parentHandle.equals(handle)) driver.switchTo().window(handle); }
	 */
	/*
	 * Set <String> handles =driver.getWindowHandles(); Iterator<String> it =
	 * handles.iterator(); //iterate through your windows while (it.hasNext()){
	 * String parent = it.next(); String newwin = it.next();
	 * driver.switchTo().window(newwin); }
	 */
	/*
	 * driver.getWindowHandles().size(); driver.switchTo().window[3];
	 * 
	 * System.out.println("SecondPage is :"+ driver.getTitle());
	 * driver.findElement(By.xpath("//div[@class='_3-zL border-global']")).click();
	 * driver.findElement(By.xpath("//input[@placeholder='Card Number']")).
	 * sendKeys("4111 1111 1111 1111 111"); driver.findElement(By.
	 * xpath("//div[@class='_3cLE  border-global xs-form-ctrl on-focus']")).sendKeys
	 * ("1026");
	 * driver.findElement(By.xpath("//input[@placeholder='CVV']")).sendKeys("123");
	 * driver.findElement(By.
	 * xpath("(//button[@class='btn btn-primary w100 pos-r _2fNU   '])[2]")).click()
	 * ; driver.findElement(By.xpath("//button[@onclick='submitSuccess()']")); //
	 * ERROR: Caught exception [unknown command []]
	 */ // ERROR: Caught exception [unknown command []]

	/*
=======
>>>>>>> a823669ced5816ad11d2237802df1fa50b092106
	 * @AfterClass(alwaysRun = true)
	 * 
	 * public void tearDown() throws Exception { // driver.quit();
	 * 
	 * String verificationErrorString = verificationErrors.toString(); if
	 * (!"".equals(verificationErrorString)) { fail(verificationErrorString);
	 * 
	 * }
	 * 
	 * // }
	 * 
	 * private boolean isElementPresent(By by) { try { driver.findElement(by);
	 * return true; } catch (NoSuchElementException e) { return false; } }
	 */
	/*
	 * private boolean isAlertPresent() { try { driver.switchTo().alert(); return
	 * true; } catch (NoAlertPresentException e) { return false; } }
	 * 
	 * 
	 * /* private String closeAlertAndGetItsText() { try { Alert alert =
	 * driver.switchTo().alert(); String alertText = alert.getText(); if
	 * (acceptNextAlert) { alert.accept(); } else { alert.dismiss(); } return
	 * alertText; } finally { acceptNextAlert = true; }
	 */
 
}
