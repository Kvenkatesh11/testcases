package hrm;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.server.handler.GetAlertText;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase2 {
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
			
			clear.click();
			String username="qaplanet1";
			String password="lab1";
			
			lgin.sendKeys(username);
			pwd.sendKeys(password);
			
			Thread.sleep(1000);
			
			lginbtn.click();
			
			String wlcm=driver.findElementByXPath("//li[contains(text(),Welcome)]").getText();
			
			if(wlcm.equals("Welcome "+username))
					System.out.println("logged in correctly");
			
			driver.switchTo().frame("rightMenu");
			driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[1]")).click();
			Thread.sleep(1000);
			//driver.switchTo().frame("rightMenu");
			String em=driver.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText();
			if(em.equals("PIM : Add Employee"))
				System.out.println("addemployee page verified");
			
			String empid=driver.findElement(By.xpath("//*[@id='txtEmployeeId']")).getAttribute("value");
			System.out.println(empid);
			
			WebElement sav=driver.findElement(By.id("btnEdit"));
			sav.click();
			Alert a=driver.switchTo().alert();
			String msg=a.getText();
			System.out.println(msg);
			
			a.accept();
			driver.findElement(By.name("txtEmpLastName")).sendKeys("karthik");
			sav.click();
			String msg1=a.getText();
			System.out.println(msg1);
			
			a.accept();
			driver.findElement(By.name("txtEmpFirstName")).sendKeys("mudiyala");
			sav.click();
			
			String pd=driver.findElement(By.xpath("//*[@id='personal']/div[1]/div[2]/div[1]/h2")).getText();
			if(pd.equals("Personal Details"))
				System.out.println("personal details page verified");
			driver.switchTo().parentFrame();
			Actions a1=new Actions(driver);
			WebElement e=driver.findElementByXPath("//*[@id='pim']/a/span");
			a1.moveToElement(e).perform();
			Thread.sleep(1000);
			WebElement e1=driver.findElementByXPath("//*[@id='pim']/ul/li[1]/a/span");
			//a1.moveToElement(e1).click().perform();
			e1.click();
			Thread.sleep(2000);
			
			driver.switchTo().frame("rightMenu");
			List<WebElement> empids=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
			int siz=empids.size();
			System.out.println(siz);
			
			
			for(int i=1;i<=siz;i++){
				if(empids.get(i).getText().equals(empid)){
				System.out.println("employee added to record successfully");
				String empname=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a")).getText();
				System.out.println(empname);
				break;
				}
				
			}
			
			
			
			
			
			/*driver.switchTo().parentFrame();
			WebElement lgot=driver.findElementByLinkText("Logout");
			lgot.click();
			Thread.sleep(1000);
				
			System.out.println("logged out correctly");
			Thread.sleep(1000);
			
			String title2=driver.getTitle();
			Thread.sleep(1000);
			
			if(title2.equals("OrangeHRM - New Level of HR Management"))
				System.out.println("home page displayed");
			
			//driver.close();	
*/		

	}

}
