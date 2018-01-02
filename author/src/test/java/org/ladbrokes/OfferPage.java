package org.ladbrokes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class OfferPage {

	WebDriver driver;

	@Test
	public void loginPage() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4502/aem/start.html");
		driver.manage().window().maximize();

		// signin page
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submit-button")).click();

		driver.findElement(By.xpath("(.//*[@icon='chevronRight'])[2]")).click();

	Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='globalnav-start-home-collection']/coral-masonry-item[1]/div")).click();

		WebElement element = driver.findElement(By.xpath(".//*[@title='Column View']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		driver.findElement(By.xpath(".//*[@id='coral-id-5']/coral-selectlist-item[3]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@value='en-gb']")).click();
		Thread.sleep(5000);
		driver.findElement(By
				.xpath(".//*[@class='granite-collection-create foundation-toggleable-control coral-Button coral-Button--primary']"))
				.click();

		driver.findElement(By.xpath("(.//*[@size='S'])[10]")).click();
		driver.findElement(
				By.xpath("//*[@src='/libs/cq/ui/widgets/themes/default/icons/240x180/page.png.thumb.319.319.png']"))
				.click();
		driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

		// offerpage form filling
		Thread.sleep(4000);
		driver.findElement(By.name("./jcr:title")).sendKeys("offertitle");
		driver.findElement(By.name("./selectionId")).sendKeys("selectionid");

		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon--sizeS coral-Icon--tags'])[1]")).click();
		driver.findElement(By.xpath(".//*[@title='Desktop']")).click();
		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon-sizeXS coral-Icon--check'])[1]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon--sizeS coral-Icon--tags'])[2]")).click();
		driver.findElement(By.xpath(".//*[@title='Football']")).click();
		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon-sizeXS coral-Icon--check'])[2]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon--sizeS coral-Icon--tags'])[3]")).click();
		driver.findElement(By.xpath(".//*[@title='3']")).click();
		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon-sizeXS coral-Icon--check'])[3]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon--sizeS coral-Icon--tags'])[4]")).click();
		driver.findElement(By.xpath(".//*[@title='New']")).click();
		driver.findElement(By.xpath("(.//*[@class='coral-Icon coral-Icon-sizeXS coral-Icon--check'])[4]")).click();

		defaultOfferPage();
		platinumOfferPage();
		createBanner();

	}

	// select other page

	public void defaultOfferPage() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@role='tab'])[4]")).click();

		driver.findElement(By.xpath("(//*[@class='coral-Form-field coral-Textfield'])[3]")).sendKeys("alttext");
		driver.findElement(By.xpath(".//*[@id='idoffermetainfo-default']/div[2]/input")).sendKeys("weburl");
		Select se = new Select(driver.findElement(By.xpath(".//*[@id='idoffermetainfo-default']/div[3]/span/select")));
		se.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='idoffermetainfo-default']/div[4]/input")).sendKeys("moburl");
		new Select(driver.findElement(By.xpath(".//*[@id='idoffermetainfo-default']/div[5]/span/select")))
				.selectByIndex(1);

		// enable terms and conditions
		driver.findElement(By.xpath(".//*[@id='webtandc-enable-default']")).click();

		driver.findElement(By.xpath(".//*[@id='idoffermetainfo-default']/div[8]/input")).sendKeys("webtc");
		driver.findElement(By.xpath(".//*[@id='idoffermetainfo-default']/div[9]/input")).sendKeys("mobtc");
		// select image
		driver.findElement(By.xpath(".//*[@id='idselpsd-default']/span/span/button")).click();
		driver.findElement(By.linkText("was_now_hero_consistentvTandCs.psd")).click();
		driver.findElement(By.xpath(".//*[@id='mod-guid-5']/div[1]/button[1]")).click();

	}

	

	public void platinumOfferPage() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@role='tab'])[5]")).click();
		driver.findElement(By.name("./platinum/altText")).sendKeys("webtext");
		driver.findElement(By.name("./platinum/offerWebLinkURL")).sendKeys("weblinkurl");
		Select se = new Select(driver.findElement(By.xpath(".//*[@id='idoffermetainfo-platinum']/div[3]/span/select")));
		se.selectByIndex(0);
		driver.findElement(By.xpath(".//*[@id='idoffermetainfo-platinum']/div[4]/input")).sendKeys("mob");
		new Select(driver.findElement(By.xpath(".//*[@id='idoffermetainfo-platinum']/div[5]/span/select")))
				.selectByIndex(0);
		driver.findElement(By.xpath(".//*[@id='webtandc-enable-platinum']")).click();
		driver.findElement(By.xpath(".//*[@id='idoffermetainfo-platinum']/div[8]/input")).sendKeys("abc");
		driver.findElement(By.xpath(".//*[@id='idoffermetainfo-platinum']/div[9]/input")).sendKeys("xyz");
		driver.findElement(
				By.xpath("(.//*[@class='js-coral-pathbrowser-button coral-Button coral-Button--secondary'])[2]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(.//*[@class='coral-ColumnView-item is-active'])[2]")).click();
		driver.findElement(By.xpath(".//*[@title='Confirm']")).click();

	}

	public void createBanner() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@class='coral-Button coral-Button--primary']")).click();

	}

	@AfterClass
	public void closeBrowser() {
		//driver.quit();
	}
}
