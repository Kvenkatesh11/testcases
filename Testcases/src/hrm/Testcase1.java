package hrm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\QAP30\\Downloads\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
				
		String title=driver.getTitle();
		
		if(title.equals("OrangeHRM - New Level of HR Management"))
			System.out.println("title page verified");
		
		
			WebElement lgin=driver.findElementByName("txtUserName");
			WebElement pwd=driver.findElementByName("txtPassword");
			WebElement lginbtn=driver.findElementByName("Submit");
			WebElement clear=driver.findElementByName("clear");
			
			if(lgin.isDisplayed()&&lgin.isEnabled())
				System.out.println("login is available and editable");
			
			if(pwd.isDisplayed()&&pwd.isEnabled())
				System.out.println("password is available and editable");
						
			if(lginbtn.isDisplayed()&&lginbtn.isEnabled())
				System.out.println("loginbutton is available and clickable");
			
			if(clear.isDisplayed()&&clear.isEnabled())
				System.out.println("clear is available and clickable");
			
			lgin.clear();
			pwd.clear();
			
			String username="qaplanet1";
			String password="lab1";
			
			lgin.sendKeys(username);
			pwd.sendKeys(password);
			
			Thread.sleep(1000);
			
			lginbtn.click();
			
			String title1=driver.getTitle();
			
			if (title1.equals("OrangeHRM"))
				System.out.println("login successfull");
									
			String wlcm=driver.findElementByXPath("//li[contains(text(),Welcome)]").getText();
			
			if(wlcm.equals("Welcome "+username))
					System.out.println("logged in correctly");
				
			WebElement chpwd=driver.findElementByLinkText("Change Password");
			chpwd.click();
			Thread.sleep(1000);
			//driver.navigate().back();
			
			//driver.switchTo().parentFrame();
			WebElement lgot=driver.findElementByLinkText("Logout");
			lgot.click();
			Thread.sleep(1000);
				
			System.out.println("logged out correctly");
			
			String title2=driver.getTitle();
			
			if(title2.equals("OrangeHRM - New Level of HR Management"))
				System.out.println("home page displayed");
			
			driver.close();			

}
}