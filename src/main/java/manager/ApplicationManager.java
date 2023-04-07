package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    //    WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;

    public void init(){
//        wd = new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Testing on Chrome Driver");
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Testing on Firefox Driver");
        }
        wd.register(new MyListener());
        user = new HelperUser(wd);
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void stop(){
        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }
}
