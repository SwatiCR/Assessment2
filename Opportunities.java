package assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities {

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
		
		// Click on Opportunity tab 
		WebElement eleOpportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", eleOpportunities);
		
		//Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		//Enter Opportunity name as 'Salesforce Automation by *Your Name*,Get the text and Store it 
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Swati");
		
		// Choose close date as Today
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("8/4/2022");
		
		//Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		//click Save and VerifyOppurtunity Name
		driver.findElement(By.xpath("//button[text()='Save']")).click();		
		String text = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]/div")).getAttribute("title");
		
		System.out.println(text);
				
	}

}
