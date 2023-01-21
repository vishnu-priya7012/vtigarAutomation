package com.vtiger.VtigerAutomation;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipaleWindowHandaling {

	public static void main(String[] args) throws InterruptedException, IOException {

  Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
		
		
		
		WebDriver driver=new ChromeDriver();
	
		driver.get("https://eportal.incometax.gov.in/iec/foservices/#/login");
		driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.name("Login")).click();
	
	driver.findElement(By.xpath("//a[text()='Feedback']")).click();
	driver.findElement(By.xpath("//a[text()='About Us']")).click();
	driver.findElement(By.xpath("//a[text()='Help']")).click();
	Set<String> setWindowHandles = driver.getWindowHandles();
	int windowCount=	setWindowHandles.size();
	for(String handleValue:setWindowHandles) {
		System.out.println(handleValue);
		driver.switchTo().window(handleValue);
		String windowTital=driver.getTitle();
		if(windowTital.equalsIgnoreCase("vtiger CRM 5 - Free, Commercial grade Open Source CRM")==true) {
		break;
	}
	}
	Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='close']")).click();
	Set<String> snewCall=driver.getWindowHandles();
	int newSize=snewCall.size();
	if(newSize==3) {
		System.out.println("passed");
	}else {
		System.out.println("failed");
	}
	
	
	
//	int windowCount=	setWindowHandles.size();
	for(String handleValue:setWindowHandles) {
		System.out.println(handleValue);
		driver.switchTo().window(handleValue);
		String windowTital=driver.getTitle();
		if(windowTital.equalsIgnoreCase("")==true) {
		break;
	}
	}
	}
}


