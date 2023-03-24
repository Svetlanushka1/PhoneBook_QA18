package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null) return false;
        else {
            wd.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            return true;
        }
    }

    public boolean isErrorFormatMessage(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password");
    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void fillLoginRegistrationForm(User user){
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void submitRegistration(){
        click(By.xpath("//button[2]"));
    }
    public void submitLogin(){
        click(By.xpath("//button[1]"));
    }

    public void openLoginRegistrationForm() {
//        wd.findElement(By.xpath("//a[@href='/login']")).click();
        click(By.xpath("//a[@href='/login']"));
    }

    public void logout(){
        click(By.xpath("//button[.='Sign Out']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

}
