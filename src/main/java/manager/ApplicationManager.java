package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{

//    WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;

    public void init(){
//        wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
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
