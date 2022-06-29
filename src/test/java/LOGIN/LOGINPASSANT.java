package LOGIN;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LOGINPASSANT {
	private static final String WebDriverManager = null;
	private WebDriver driver;	

	  @Test
	  public void Login() {
		    driver.get("http://preview.moros.horus.lan/app_dev.php/login");
		  //  driver.navigate().refresh();
		    
		    	
		    	  try{
		    			WebElement Email =  driver.findElement(By.name("_username"));
		    			WebElement Pwd =  driver.findElement(By.name("_password"));
		    			WebElement Login =  driver.findElement(By.id("login-page-submit-btn"));
		    			WebDriverWait wait = new WebDriverWait(driver, 5);
		    			wait.until(ExpectedConditions.elementToBeClickable(Email));
		    			wait.until(ExpectedConditions.elementToBeClickable(Pwd));
		    			wait.until(ExpectedConditions.elementToBeClickable(Login));
		    			
		    			Email.sendKeys("preview",Keys.ENTER);
		    			Pwd.sendKeys("preview",Keys.ENTER);
		    			
		    			String ActualEmail = Email.getAttribute("value");
		    			String ActualPwd = Pwd.getAttribute("value");
		    			String ExpectedEmail = "preview";
		    			String ExpectedPwd = "preview";
		    			Assert.assertEquals(ExpectedEmail, ActualEmail);
		    			Assert.assertEquals(ExpectedPwd, ActualPwd);		
		    				
		    			Login.click();			    					
		    		   					
		    			String ActualTitle = driver.getTitle();
		    			System.out.println(ActualTitle);
		    			String ExpectedTitle = "Preview";
		    			Assert.assertEquals(ExpectedTitle, ActualTitle);			   
		    	  }
		    	  catch(Exception e){		    	    
		    	     System.out.println(e.getMessage());
		    	  }
		    	}
	    
 
			  
	  @BeforeTest
	  public void beforeTest() {
		  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\DOS REIS\\eclipse-workspace\\FNAC-DARTY\\src\\test\\resources\\drivers\\chromedriver.exe"); 
		  //driver = new ChromeDriver();
		  //System.setProperty("webdriver.gecko.driver", "C:\\Users\\DOS REIS\\eclipse-workspace\\FNAC-DARTY\\src\\test\\resources\\drivers\\geckodriver.exe"); 
		  //driver = new FirefoxDriver();
		  
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\DOS REIS\\eclipse-workspace\\FNAC-DARTY\\src\\test\\resources\\drivers\\msedgedriver.exe"); 
		  driver = new EdgeDriver();
		  	  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();		  
	  }

	  @AfterTest
	  public void afterTest() {		 
		  
		// driver.quit();
	  }
	

}
