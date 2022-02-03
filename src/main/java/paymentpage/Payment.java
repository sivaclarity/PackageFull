package paymentpage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment {

		 public static By CardClick = By.xpath("//div[@class='_3-zL border-global']");
		 public static By CardEnter = By.xpath("//input[@placeholder='Card Number']"); 
		 public static By ExpiryMonth =By.id("mm");
		 public static By ExpiryYear=By.id("yy");
		 public static By Cvv=By.xpath("//input[@placeholder='CVV']");
		 public static By Submit =By.xpath("(//button[@class='btn btn-primary w100 pos-r _2fNU   '])[2]");
		 public static By Success =By.xpath("//button[@onclick='submitSuccess()']"); 
	
		 
	  }
	 

