package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {
	public static void main(String[] args) {
		
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\QAP30\\Downloads\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	
	driver.get("https://www.vtiger.com/");
	String title=driver.getTitle();
	if(title.equals("CRM | Customer Relationship Management Software - Vtiger CRM")){
		driver.findElement(By.xpath("//a[@id='customloginlink']")).click();
		driver.close();	
		
	}
	
	
	}
}
