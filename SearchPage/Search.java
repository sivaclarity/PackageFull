package SearchPage;

import org.openqa.selenium.By;

public class Search {
	
	public static String url ="https://b2cui2.tltid.com/pa";
	public static By HotelButton = By.xpath("//span[contains(text(),'Hotels')]");
	public static By HotelRadio = By.xpath("//span[text()='Hotel']");
	public static By TextBox =By.xpath("//input[@placeholder='Enter a Hotel Name or Destination']");
	public static By TextOptions = By.xpath("//span[contains(text(),'Toronto, ON, Canada (YYZ-Pearson Intl.) ')]");
    public static By FromDate = By.xpath("//div[@date='2022-02-14']");
    public static By ToDate = By.xpath("//div[@date='2022-02-28']");
    public static By  Done = By.xpath("//span[contains(text(),'Done')]");
    public static By SearchButton =By.xpath("//button[contains(text(),'Search')]");
    
}
