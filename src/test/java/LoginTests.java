import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        String email = "abc@def.com";
        String password = "$Abcdef12345";
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
    }


}
