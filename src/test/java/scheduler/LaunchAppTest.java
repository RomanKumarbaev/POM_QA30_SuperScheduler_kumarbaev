package scheduler;

import config.ConfigurationScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerscreens.SplashScreen;

public class LaunchAppTest extends ConfigurationScheduler {


@Test
    public void launchTest(){
logger.info("Start version 0.0.3");
   String version= new SplashScreen(driver).getCurrencyVersion();

    Assert.assertEquals(version,"0.0.3");
}

}
