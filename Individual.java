package assessment2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Individual {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager for browser driver
		WebDriverManager.chromedriver().setup();

		//disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");	
		
		//Launch the browser
		ChromeDriver driver = new ChromeDriver(options);

		//Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");

		//maximize the window
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		//explicit wait
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));

		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");

		//click on the login button
		driver.findElement(By.id("Login")).click();

		//Click View All and click Individuals from App Launcher
		driver.findElement(By.className("slds-icon-waffle")).click();		
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		//scroll to individuals and then click
		WebElement eleIndividual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		Actions builder = new Actions(driver);	
		builder.scrollToElement(eleIndividual).perform();
		eleIndividual.click();

		//Click on the Dropdown icon in the Individuals tab
		driver.findElement(By.xpath("//span[text()='Individuals']")).click();		
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']/one-app-nav-bar-menu-button/a//lightning-primitive-icon")).click();
		
		//Click on New Individual
		WebElement eleNewIndividual = driver.findElement(By.xpath("//span[@class='slds-truncate']/span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", eleNewIndividual);
		Thread.sleep(3000);
		
		//Enter the Last Name as 'Kumar'			
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kumar");
		
		//.Click save and verify Individuals Name
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']/span[text()='Save']")).click();
		
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(text);	

	}

}
