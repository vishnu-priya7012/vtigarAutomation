package com.vtiger.VtigerAutomation;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusOfWebElement {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		
Capabilities c= driver.getCapabilities();
Map<String, Object> m= c.asMap();
m.forEach((key,value)->{
	System.out.println("key is: "+key+"   valuse is :  "+value);
});

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.get("http://localhost:8888/");

		 driver.findElement(By.name("user_name")).sendKeys("admin");
	       driver.findElement(By.name("user_password")).sendKeys("admin");
	      
	       driver.findElement(By.name("Login")).click();
	//       driver.findElement(By.partialLinkText("index.php?module=Campaigns&action=index&parenttab=Marketing")).click();
	
	driver.quit()
;	}

}
