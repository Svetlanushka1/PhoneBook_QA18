package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

//    WebDriver wd;
//    FluentWait<WebDriver> wait;

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
////        wait = new FluentWait<>(wd);
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//    }


    @Test
    public void regPositiveTest(){

//        1. open login/registration form
        app.getUser().openLoginRegistrationForm();
//        WebElement loginBtn = wd.findElement(By.xpath("//a[@href='/login']"));
//        loginBtn.click();
//        2. fill login/registration form
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.com";
        String password = "$Abcd1234";
        app.getUser().fillLoginRegistrationForm(email, password);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc" + i + "@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcd1234");
//        3. submit by click registration button
//        wd.findElement(By.xpath("//button[2]")).click();
        app.getUser().submitRegistration();

//        pause(5);

//        4. assert
//        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));
    }

//    public void pause(int time){
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        FluentWait<WebDriver> wait = new FluentWait<>(wd);
//        wait.withTimeout(Duration.ofSeconds(time));
//    }

    @Test
    public void registrationWrongEmail(){
//        1. open login/registration form
//        WebElement loginBtn = wd.findElement(By.xpath("//a[@href='/login']"));
//        loginBtn.click();
        app.getUser().openLoginRegistrationForm();

//        2. fill login/registration form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc" + i + "def.com");
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "mail.com";
        String password = "$Abcd1234";
        app.getUser().fillLoginRegistrationForm(email, password);

//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcd1234");
//        3. submit by click registration button
//        wd.findElement(By.xpath("//button[2]")).click();
        app.getUser().submitRegistration();
//        4. assert
//        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));


    }

    @AfterMethod
    public void tearDown() {
//        wd.quit();
    }
}
