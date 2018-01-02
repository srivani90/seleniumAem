package com.lbc.author;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import library.ExcelDataConfig;




public class LoginPage {

	WebDriver driver;

	@Test
	public void Login() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4502/aem/start.html");
		driver.manage().window().maximize();

		// signin page
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submit-button")).click();

		driver.findElement(By.xpath(".//*[@id='globalnav-start-home-collection']/coral-masonry-item[5]/div/coral-icon[2]")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='globalnav-start-home-collection']/coral-masonry-item[1]/div")).click();

		WebElement element = driver.findElement(By.xpath(".//*[@id='granite-shell-actionbar']/betty-titlebar-secondary/button"));

		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].click();", element);


	 driver.findElement(By.className("coral-BasicList-item-content")).click();	
		
		driver.findElement(By.xpath("html/body/form/div/coral-panelstack/coral-panel[1]/coral-panel-content/div/div/coral-masonry/coral-masonry-item/coral-card/coral-card-asset/img")).click();
		 driver.findElement(By.xpath("html/body/form/div/div/coral-panelstack/coral-panel[1]/coral-panel-content/div/button")).click();
	
		 //create page 
		 driver.findElement(By.name("./jcr:title")).sendKeys("OfferTitle");
		 driver.findElement(By.name("./offerWebLinkURL")).sendKeys("WebURL");
		 Select dd = new Select(driver.findElement(By.xpath(".//*[@id='coral-1']/div/section/section/div[3]/span/select")));
		        dd.selectByIndex(1);
		 driver.findElement(By.xpath(".//*[@id='coral-1']/div/section/section/div[4]/input")).sendKeys("MobileURL");
		  new Select(driver.findElement(By.xpath(".//*[@id='coral-1']/div/section/section/div[5]/span/select"))).selectByIndex(1);
		  driver.findElement(By.xpath(".//*[@id='coral-1']/div/section/section/div[6]/input")).sendKeys("ALTtext");
		  driver.findElement(By.xpath(".//*[@id='coral-1']/div/section/section/div[7]/input")).sendKeys("SelectionID");
		  driver.findElement(By.xpath(".//*[@id='coral-16']")).sendKeys("la");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath(".//*[@id='coral-15']/li[8]")).click();
		  
		  driver.findElement(By.id("coral-18")).sendKeys("la");
		  driver.findElement(By.xpath(".//*[@id='coral-17']/li[8]")).click();
		 
		 driver.findElement(By.xpath(".//*[@id='coral-20']")).sendKeys("2");
		 driver.findElement(By.xpath(".//*[@id='coral-22']")).sendKeys("Both");
		 driver.findElement(By.xpath("html/body/form/div/div/coral-panelstack/coral-panel[2]/coral-panel-content/div/button[2]")).click();
		 
		 driver.findElement(By.xpath("html/body/coral-dialog/div[2]/coral-dialog-footer/button[2]")).click();
		
	} 
	
	}
				