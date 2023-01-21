package com.vtiger.VtigerAutomation;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(String[] args) 
		{
			
			try{
	            Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
	        }
	        catch(IOException io){
	            System.out.println(io.getMessage());
	        }
			
			
			File objfile=new File(("User.dir")+"\\Report.html");
			ExtentSparkReporter NewhtmlReport=new ExtentSparkReporter(objfile);

			ExtentReports extReport= new ExtentReports();
			ExtentTest TCReport=extReport.createTest("TC001");

			extReport.setSystemInfo("OS Name", System.getProperty("os.name"));
			extReport.setSystemInfo("User Name", System.getProperty("user,name"));
			extReport.setSystemInfo("Server name", "QA Surver");

			extReport.attachReporter(NewhtmlReport);

			ChromeDriver driver= new ChromeDriver();




			TCReport.log(Status.INFO, "Chrome Browser Successfully Launch");
			driver.get("http://localhost:8888/");
			TCReport.log(Status.INFO, "URL Naviagte: http://localhost:8888/ ");
		
			
		
		WebElement userName	=	driver.findElement(By.name("user_name"));
			boolean userNameDisplay=userName.isDisplayed();
			
			if(userNameDisplay==true) {
			
				TCReport.log(Status.INFO, "user name box is display");
			}else {
				TCReport.log(Status.INFO, "user name box is not display");
			}
				
			userName.sendKeys("admin");
			String userBoxValue=userName.getAttribute("Value");
			if(userBoxValue.equals(userName)) {
				TCReport.log(Status.INFO, "user is able to enter a value ");
				System.out.println("user is able to enter a value "+userName+" perfect");
			}else {
				TCReport.log(Status.INFO, "user is not able to enter a value");
				
				System.out.println("user is not able to enter a value "+userName+" some thing is wrong");
				
			}
			
			WebElement userPass	=	driver.findElement(By.name("user_password"));
			boolean userPassDisplay=userPass.isDisplayed();
			
			if(userPassDisplay==true) {
			
				TCReport.log(Status.INFO, "user password box is display");
			}else {
				TCReport.log(Status.INFO, "user Password box is not display");
			}
				
			userPass.sendKeys("admiin");
			String userPassBoxValue=userPass.getAttribute("Value");
			if(userPassBoxValue.equals(userPass)) {
				TCReport.log(Status.INFO, "user Pass is able to enter a value ");
				
				System.out.println("user Pass is able to enter a value "+userPass+" perfect");
			}else {
				TCReport.log(Status.INFO, "user Pass is not able to enter a value");
				
				System.out.println("user Pass is not able to enter a value "+userPass+" some thing is wrong");
				
			}
				
				
			WebElement clickBox=driver.findElement(By.name("Login"));
	boolean clickBoxDisplay=clickBox.isDisplayed();
			
			if(clickBoxDisplay==true) {
			
				TCReport.log(Status.INFO, "click box is display");
			}else {
				TCReport.log(Status.INFO, "click box is not display");
			}
		clickBox.click();
		boolean CheckDirplayMarketing1=	driver.findElement(By.xpath("//a[text()='Marketing']")).isDisplayed();

		if(CheckDirplayMarketing1==true) {
			TCReport.log(Status.PASS, "Marketing Bottan is displayed TC001 is pass");
		}else {
			TCReport.log(Status.FAIL, "Marketing Bottan is not displayed TC001 is Fail");
		}


				TCReport.log(Status.INFO, "Click performe successfully on login bottan ");

			  
			
			extReport.flush();
		
		}
	}

