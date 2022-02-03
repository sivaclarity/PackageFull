package extentreport;


import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;





public class ExtentReport {
	
	
	//public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;
//	public ExtentTest logger;
	
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/git/package/packagefull/ExtentReport.html", true);
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
	
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+ "/git/package/packagefull/"  + screenshotName 
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	
	
	/*
	 * @BeforeMethod public void setup(){
	 * 
	 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
	 * 
	 * driver.get("https://www.freecrm.com/");
	 * 
	 * }
	 */
	
	
	
	/*
	 * @Test public void TitleTest(){ extentTest =
	 * extent.startTest("Extent Report"); String title = driver.getTitle();
	 * System.out.println(title); Assert.assertEquals(
	 * title,"#1 Free CRM for Any Business: Online Customer Relationship Software123"
	 * ); }
	 * 
	 * @Test public void freemCRMLogoTest(){ extentTest =
	 * extent.startTest("freemCRMLogoTest"); boolean b = driver.findElement(By.
	 * xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"
	 * )).isDisplayed(); Assert.assertTrue(b); }
	 */
	
	
	
	
	
@Test
	public void screenshot(ITestResult result,WebDriver driver) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); 
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); 
			
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
	
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			 extent.flush();
		}
		
		
		extent.endTest(extentTest); 
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}