package assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Accounts {

	public static void main(String[] args) {
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

		//Click view All and click Sales from App Launcher
		driver.findElement(By.className("slds-icon-waffle")).click();		
		driver.findElement(By.xpath("//button[text()='View All']")).click();		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on Accounts tab 
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		
		//Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Swati");
		
		//Select Ownership as Public    
		WebElement eleOwnership = driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
		driver.executeScript("arguments[0].click();", eleOwnership);		
		driver.findElement(By.xpath("(//span[text()='Public'])[1]")).click();
		
		// Click save and verify Account name 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getAttribute("title");
		
		System.out.println(text);
		
		if(text.contains("Swati")) {
			System.out.println("Account verified");
		}
		else {
			System.out.println("Account not verified");
		}
	}

}
