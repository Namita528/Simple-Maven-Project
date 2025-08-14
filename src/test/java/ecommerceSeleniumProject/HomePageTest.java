package ecommerceSeleniumProject;
import org.openqa.selenium.TimeoutException; 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest2 {
	
	@Test
	
	public void homePageTest() {
		System.out.println(" perform mouse hover action on menu option Pages");
		WebElement pagesMenu = driver.findElement(By.linkText("Pages"));
		Actions actions = new Actions(driver);
		actions.moveToElement(pagesMenu).perform();
		
		// Action: Click on "Contact" link
		 try {
		        // Action: Click on "Contact" link
		        WebElement contactLink = driver.findElement(By.linkText("Contact"));
		        contactLink.click();

		        // Wait for up to 10 seconds for an alert to be present
		        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		        // An alert was found, so we accept it
		        if (alert != null) {
		            System.out.println("Alert with message '" + alert.getText() + "' found and accepted.");
		            alert.accept();
		        }

		        
		 } catch (TimeoutException e) {
		        // This block will execute if no alert appears within 10 seconds.
		        // It's not an error if no alert is expected.
		        System.out.println("No alert was present. Continuing with the test.");
		      
		 }
	}
}
