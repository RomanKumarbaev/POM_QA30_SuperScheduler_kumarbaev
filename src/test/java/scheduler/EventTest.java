package scheduler;

import config.ConfigurationScheduler;
import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;
import schedulerscreens.SplashScreen;

public class EventTest extends ConfigurationScheduler {

    @BeforeMethod
    public void preCondition(){
        new LoginScreen(driver).loginComplex(Auth.builder().email("your2@gmail.com").password("Yy123456$").build())
                .skipWizard()
                .isFabAddPresent();

    }

    @Test
    public void createNewEventTest(){

        boolean isfabAddPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Event")
                        .type("new")
                        .breaks(2)
                        .wage(50)
                        .build())
                .isFabAddPresent();
        Assert.assertTrue(isfabAddPresent);

    }

@Test(enabled = false)
    public void createEventComplex(){

        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginComplex(Auth.builder().email("your2@gmail.com").password("Yy123456$").build())
                .skipWizard()
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Event")
                        .type("new")
                        .breaks(2)
                        .wage(500)
                        .build())
                .isFabAddPresent();
    }
}


