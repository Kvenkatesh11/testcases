package hrm;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Testcase3 {
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
		
		driver.switchTo().frame("rightMenu");
		
		WebElement search=driver.findElement(By.name("loc_code"));
		Select se=new Select(search);
		se.selectByVisibleText("Emp. First Name");
		driver.findElement(By.name("loc_name")).sendKeys("mudiyala");
		driver.findElement(By.xpath("//*[@id='standardView']/div[2]/input[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'mudiyala')]")).click();
		//driver.findElement(By.partialLinkText("ravi  kumar")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("EditMain")).click();
		String empid=driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
		System.out.println(empid);
		/*driver.switchTo().parentFrame();*/
		/*Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@id='recruit']/a/span"))).perform();
		//a.moveToElement(driver.findElement(By.xpath("//*[@id='recruit']/ul/li[1]/a/span"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='recruit']/ul/li[1]/a/span")).click();
		*/
		driver.findElement(By.xpath("//a[@id='jobLink']/span")).click();
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		Thread.sleep(2000);
		a.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='jobLink']/span")).click();
		driver.findElement(By.name("EditMain")).click();	
		Select sa=new Select(driver.findElement(By.name("cmbType")));
		sa.selectByVisibleText("Associate");
		driver.findElement(By.className("savebutton")).click();
		driver.switchTo().parentFrame();
		Actions a1=new Actions(driver);
		a1.moveToElement(driver.findElement(By.xpath("//*[@id='pim']/a/span"))).perform();
		driver.findElement(By.xpath("//a[@class='l2_link emplist']/span")).click();
		
		List<WebElement> empids=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		int siz=empids.size();
		for(int i=1;i<=siz;i++){
			if(empids.get(i).getText().equals(empid)){
				String empst=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText();
				if(empst.equals("Associate"))
					System.out.println("employee status updated successfully");
			}
				
		}
		//driver.close();
		
 		
		
		
	}
	

}
