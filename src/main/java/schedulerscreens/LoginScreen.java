package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;



public LoginScreen fillEmail(String email){
    should(emailEditText,20);
    type(emailEditText,email);

    return this;
}
    public LoginScreen fillPassword(String password){

        type(passwordEditText,password);

        return this;
    }
    public WizardScreen clickLoginBtn(){

    hideKeyBoard();
    loginButton.click();
    return new WizardScreen(driver);
    }
    public WizardScreen loginComplex(Auth auth){
    should(emailEditText,20);
    type(emailEditText, auth.getEmail());
    type(passwordEditText, auth.getPassword());
    hideKeyBoard();
    loginButton.click();
    return new WizardScreen(driver);
    }
    public LoginScreen loginComplexErrorMessage(Auth auth){
        should(emailEditText,20);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());

        hideKeyBoard();
        loginButton.click();
        return this;
    }

    public LoginScreen checkErrorMessage(String text){
shouldHave(errorMessage,text,10);
return this;
    }
    public LoginScreen confirmErrorMessage(){
    okBtn.click();
    return this;
    }
    public  boolean isLoginButtonPresent(){
    return isDisplayedWithExp(loginButton);
    }




}

