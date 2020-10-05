package steps;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.RegisterationPage;
import steps.TestBase;

public class VerifyValidLogin extends TestBase {

    @Test(description="Valid login")
    public void checkValidUser(){
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        RegisterationPage loginPage = PageFactory.initElements(driver, RegisterationPage.class);
//        loginPage.login("admin", "demo123");

    }
}
