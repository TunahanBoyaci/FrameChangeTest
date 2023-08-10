package FrameChangeTest;

        import Utilities.BaseDriver;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import java.time.Duration;

public class FrameChangeTest extends BaseDriver {

    @Test
    public void test1(){
        driver.get("https://chercher.tech/practice/frames");

        // We are in the first frame
        WebElement iFrame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iFrame);

        // Do operation
        WebElement topicInbox = driver.findElement(By.cssSelector("input[type='text']"));
        topicInbox.sendKeys("USA");

        // One step back for changing frame
        driver.switchTo().parentFrame();

        // We are in the second frame
        WebElement iFrame2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(iFrame2);

        WebElement animalsSelect = driver.findElement(By.id("animals"));
        Select animals = new Select(animalsSelect);
        animals.selectByValue("avatar");

        waitAndQuit();
    }
}
