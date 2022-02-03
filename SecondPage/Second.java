package SecondPage;

import org.openqa.selenium.By;

public class Second {
	public static By LinkText = By.linkText("Themes/Types");
	public static By FreeBreakfast = By.xpath("//*/text()[normalize-space(.)='Free breakfast']/parent::*");
	public static By PriceCheckBox=By.xpath("//label[contains(text(),'CAD  400 to CAD  800 ')]");
	public static By HealthCheckBox =By.xpath("//span[text()='Health & Safety']");
	public static By BusinessProperty =By.xpath("//label[contains(text(),'Business property')]");
	public static By AvailabeRooms=By.xpath("(//span[contains(text(),'See Available Rooms')])[8]");
}
