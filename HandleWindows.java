package seleniumTask;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {

	public static void main(String[] args) {	
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		
		// Get set of windows
		
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		
		// Convert Set to List
		
	
		
for(String window: allWindow) {
			
			if(!window.equals(parentWindow)) {
				
				driver.switchTo().window(window);
				break;
			}
			
		}
		
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}

}