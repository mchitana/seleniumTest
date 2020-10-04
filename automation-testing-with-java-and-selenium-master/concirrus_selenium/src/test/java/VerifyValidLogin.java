

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;

public class VerifyValidLogin {

    @Test(description="Valid login")
    public void checkValidUser(){
        WebDriver driver = BrowserFactory.startBrowser("chrome", "http://demosite.center/wordpress/wp-login.php");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("admin", "demo123");

    }
}
