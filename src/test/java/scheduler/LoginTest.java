package scheduler;

import config.ConfigurationScheduler;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerscreens.LoginScreen;
import schedulerscreens.SplashScreen;

public class LoginTest extends ConfigurationScheduler {

    @Test
    public void loginSuccessTest(){

        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);

    }

    @Test
    public void loginStartLoginScreen(){
        new LoginScreen(driver)
                .fillEmail("cum@gmail.com")
                .fillPassword("Cc123456$")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
    }

    @Test
    public void loginAuthTest(){
        boolean isFabPresent =
                new LoginScreen(driver).loginComplex(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                        .skipWizard().isFabAddPresent();
        Assert.assertTrue(isFabPresent);

    }
    @Test
    public void loginComplexCheckErrorMessage(){
        boolean isLoginButtonPresent = new LoginScreen(driver).loginComplexErrorMessage(Auth.builder().email("noa@gmail.com").password("Nnoa123456").build())
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage()
                .isLoginButtonPresent();
        Assert.assertTrue(isLoginButtonPresent);


    }
}
