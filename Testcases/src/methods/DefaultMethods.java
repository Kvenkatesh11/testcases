package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DefaultMethods {
	public static void hrminchrome(String a,String b,String c) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP30\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(a);
		driver.manage().window().maximize();
		WebElement loginid=driver.findElement(By.name("txtUserName"));
		WebElement password=driver.findElement(By.name("txtPassword"));
		WebElement loginbutton=driver.findElement(By.name("Submit"));
		WebElement clearbutton=driver.findElement(By.name("clear"));
		clearbutton.click();
		loginid.sendKeys(b);
		password.sendKeys(c);
		loginbutton.click();
		
	}
	
	public static void hrminfirefox(String a,String b,String c){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\QAP30\\Downloads\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get(a);
		WebElement loginid=driver.findElement(By.name("txtUserName"));
		WebElement password=driver.findElement(By.name("txtPassword"));
		WebElement loginbutton=driver.findElement(By.name("Submit"));
		WebElement clearbutton=driver.findElement(By.name("clear"));
		clearbutton.click();
		loginid.sendKeys(b);
		password.sendKeys(c);
		loginbutton.click();
	}
	
	public static void vtigerinchrome(String a,String b,String c){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP30\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(a);
		driver.manage().window().maximize();
		WebElement loginid=driver.findElement(By.name("user_name"));
		WebElement password=driver.findElement(By.name("user_password"));
		WebElement loginbutton=driver.findElement(By.id("submitButton"));
		loginid.sendKeys(b);
		password.sendKeys(c);
		loginbutton.click();
				
		
	}
	public static void vtigerinfirefox(String a,String b,String c){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\QAP30\\Downloads\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get(a);
		WebElement loginid=driver.findElement(By.name("user_name"));
		WebElement password=driver.findElement(By.name("user_password"));
		WebElement loginbutton=driver.findElement(By.id("submitButton"));
		loginid.sendKeys(b);
		password.sendKeys(c);
		loginbutton.click();
		driver.findElement(By.id("loc_code"));
				
	}

	/*public static void searchforemployee(String a,String b){
		Select s=new Select(driver.findElement(By.id("loc_code")));
		s.selectByVisibleText(a);
		
		
	}*/


}