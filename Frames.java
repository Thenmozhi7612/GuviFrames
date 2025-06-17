package seleniumTask;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Frames {
	
	

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.switchTo().frame("frame-top");
		List<WebElement> frames = driver.findElements(By.xpath("//frame"));
		Assert.assertEquals(frames.size(),3,"There should be three frames on the page.");
		
		driver.switchTo().frame("frame-left");
		
		WebElement leftFrameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		Assert.assertEquals(leftFrameText.getText(),"LEFT", "The left frame should have the visible text 'LEFT'.");
		System.out.println(driver.getTitle());

		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		
		WebElement middleFrameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		Assert.assertEquals(middleFrameText.getText(),"MIDDLE", "The middle frame should have the visible text 'MIDDLE'.");
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		
		WebElement rightFrameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		Assert.assertEquals(rightFrameText.getText(),"RIGHT", "The right frame should have the visible text 'RIGHT'.");
		
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		
driver.switchTo().frame("frame-bottom");
		
		WebElement bottomFrameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		Assert.assertEquals(bottomFrameText.getText(),"BOTTOM", "The bottom frame should have the visible text 'BOTTOM'.");
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-top");
		
		driver.quit();
	}

}
