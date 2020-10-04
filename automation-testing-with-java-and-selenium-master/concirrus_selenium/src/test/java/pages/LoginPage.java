package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "user_login")
//    @CacheLookup
    WebElement username;

    @FindBy(how = How.ID, using = "user_pass")
//    @CacheLookup
    WebElement password;

    @FindBy(how = How.ID, using = "wp-submit")
//    @CacheLookup
    WebElement login;

    public void login(String use, String pass) {
        try {
            username.sendKeys(use);
            Thread.sleep(3000);
            password.sendKeys(pass);
            Thread.sleep(3000);
            login.click();
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
}
