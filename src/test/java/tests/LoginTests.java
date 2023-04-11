package tests;

import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test(invocationCount = 1, groups = {"smoke"},
            dataProvider = "loginModelDto", dataProviderClass = ProviderData.class)
    public void loginPositiveTest(User user){
        //              new User().
//        User user = User.builder()
//                .email("abc@def.com")
//                .password("$Abcdef12345")
//                .build();

//        String email = "abc@def.com";
//        String password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }
    @Test(groups = {"smoke","regress"})
    public void loginNegativeTestWrongEmail(){
        User user = User.builder()
                .email("abcdef.com")
                .password("$Abcdef12345")
                .build();
//        String email = "abcdef.com";
//        String password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }
    @Test(groups = {"regress"})
    public void loginNegativeTestWrongPass(){
        User user = User.builder()
                .email("abc@def.com")
                .password("Abcdef12345")
                .build();
//        String email = "abcdef.com";
//        String password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }
}
