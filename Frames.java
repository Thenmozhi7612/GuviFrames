package seleniumTask;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> parentFrames = driver.findElements(By.xpath("//frame"));

		for (WebElement parentFrame : parentFrames) {
			driver.switchTo().frame(parentFrame);
			List<WebElement> frames = driver.findElements(By.xpath("//frame"));
			int i = frames.size();
			if (i == 3) {
				System.out.println("Three frames on the page");
				for (WebElement frame : frames) {
					driver.switchTo().frame(frame);
					String pageSource = driver.getPageSource();
					if (pageSource.contains("LEFT")) {
						System.out.println("IN LEFTFRAME");
					}
					if (pageSource.contains("MIDDLE")) {
						System.out.println("IN MIDDLEFRAME");
					}
					if (pageSource.contains("RIGHT")) {
						System.out.println("IN RIGHTFRAME");
					}
					driver.switchTo().parentFrame();
				}
			} else {
				String pageSource = driver.getPageSource();
				if (pageSource.contains("BOTTOM")) {
					System.out.println("IN BOTTOMFRAME");
				}
			}

			driver.switchTo().parentFrame();
		}

	}
}
