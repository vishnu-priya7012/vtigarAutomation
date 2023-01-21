package com.vtiger.VtigerAutomation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


// lAUNCH BROWSER URL PRINTING , TITAL,HTML PAGE, PRINTING'
//

public class Login{ 

	public static void main( String[] args ) throws InterruptedException
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


		System.out.println("Lauch browser url is =="+driver.getCurrentUrl());
		System.out.println("Lauch browser tital is =="+driver.getTitle()); //
		System.out.println("Lauch browser HTML page is =="+driver.getPageSource());

		extReport.setSystemInfo("Lauch browser url is ==", driver.getCurrentUrl());
		extReport.setSystemInfo("Lauch browser Tital is ==", driver.getTitle());

		driver.findElement(By.name("user_name")).sendKeys("admin");
		TCReport.log(Status.INFO, "user name successfuly Entered");


		driver.findElement(By.name("user_password")).sendKeys("admin");
		TCReport.log(Status.INFO, "user Password successfuly Entered");


		Select theme=new Select(driver.findElement(By.name("login_theme")));
		theme.selectByVisibleText("alphagrey");
		TCReport.log(Status.INFO, "Theme color successfully selected: alphagrey");

		driver.findElement(By.name("Login")).click();
		TCReport.log(Status.INFO, "Click performe successfully on login bottan ");


		System.out.println("home page usl is =="+driver.getCurrentUrl());
		System.out.println("home page tital is =="+driver.getTitle());



		extReport.setSystemInfo("Lauch browser url is ==", driver.getCurrentUrl());
		extReport.setSystemInfo("Lauch browser Tital is ==", driver.getTitle());

		boolean CheckDirplayMarketing=	driver.findElement(By.xpath("//a[text()='Marketing']")).isDisplayed();

		if(CheckDirplayMarketing==true) {
			TCReport.log(Status.PASS, "Marketing Bottan is displayed TC001 is pass");
		}else {
			TCReport.log(Status.FAIL, "Marketing Bottan is not displayed TC001 is Fail");
		}


		
		driver.get("http://localhost:8888/");
		
		
		  ExtentTest TCReport1=extReport.createTest("TC002");
	WebElement userName	=	driver.findElement(By.name("user_name"));
		boolean userNameDisplay=userName.isDisplayed();
		
		if(userNameDisplay==true) {
		
			TCReport1.log(Status.INFO, "user name box is display");
		}else {
			TCReport1.log(Status.INFO, "user name box is not display");
		}
			
		userName.sendKeys("admin");
		String userBoxValue=userName.getAttribute("Value");
		if(userBoxValue.equals(userName)) {
			TCReport1.log(Status.INFO, "user is able to enter a value ");
			System.out.println("user is able to enter a value "+userName+" perfect");
		}else {
			TCReport1.log(Status.INFO, "user is not able to enter a value");
			
			System.out.println("user is not able to enter a value "+userName+" some thing is wrong");
			
		}
		
		WebElement userPass	=	driver.findElement(By.name("user_password"));
		boolean userPassDisplay=userPass.isDisplayed();
		
		if(userPassDisplay==true) {
		
			TCReport1.log(Status.INFO, "user password box is display");
		}else {
			TCReport1.log(Status.INFO, "user Password box is not display");
		}
			
		userPass.sendKeys("admin");
		String userPassBoxValue=userPass.getAttribute("Value");
		if(userPassBoxValue.equals(userPass)) {
			TCReport1.log(Status.INFO, "user Pass is able to enter a value ");
			
			System.out.println("user Pass is able to enter a value "+userPass+" perfect");
		}else {
			TCReport1.log(Status.INFO, "user Pass is not able to enter a value");
			
			System.out.println("user Pass is not able to enter a value "+userPass+" some thing is wrong");
			
		}
			
			
		WebElement clickBox=driver.findElement(By.name("Login"));
boolean clickBoxDisplay=clickBox.isDisplayed();
		
		if(clickBoxDisplay==true) {
		
			TCReport1.log(Status.INFO, "click box is display");
		}else {
			TCReport1.log(Status.INFO, "click box is not display");
		}
	clickBox.click();
	boolean CheckDirplayMarketing1=	driver.findElement(By.xpath("//a[text()='Marketing']")).isDisplayed();

	if(CheckDirplayMarketing1==true) {
		TCReport.log(Status.PASS, "Marketing Bottan is displayed TC001 is pass");
	}else {
		TCReport.log(Status.FAIL, "Marketing Bottan is not displayed TC001 is Fail");
	}


			TCReport1.log(Status.INFO, "Click performe successfully on login bottan ");

		  
		
		extReport.flush();
	}
}
