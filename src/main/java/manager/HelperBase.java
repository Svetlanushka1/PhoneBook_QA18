package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text){
        if(text != null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        return (wd.findElements(locator).size() > 0);
    }

        public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        FluentWait<WebDriver> wait = new FluentWait<>(wd);
//        wait.withTimeout(Duration.ofSeconds(time));
    }

    public void takeScreenShot(String link){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(link);

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
