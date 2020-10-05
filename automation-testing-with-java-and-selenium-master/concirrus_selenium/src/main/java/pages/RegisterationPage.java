package pages;

import entities.RegistrationDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterationPage {

    WebDriver driver;

    public RegisterationPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//input[@id='firstname']")
//    @CacheLookup
            WebElement firstname;

    @FindBy(how = How.ID, using = "surname")
//    @CacheLookup
            WebElement lastName;

    @FindBy(how = How.ID, using = "email")
//    @CacheLookup
            WebElement email;

    @FindBy(how = How.ID, using = "email2")
//    @CacheLookup
            WebElement reTypeEmail;

    @FindBy(how = How.ID, using = "password")
//    @CacheLookup
            WebElement password;

    @FindBy(how = How.ID, using = "password2")
//    @CacheLookup
            WebElement rePassword;

    @FindBy(how = How.ID, using = "telno1")
//    @CacheLookup
            WebElement telephoneNo;

   @FindBy(how = How.NAME, using = "registerButton")
//    @CacheLookup
            WebElement registerButton;


    public void register(RegistrationDetails registrationDetails) {
        try {
            firstname.getText();
            Thread.sleep(30000);
//            firstName.sendKeys(registrationDetails.getFirstName());
//            Thread.sleep(30000);
//            lastName.sendKeys(registrationDetails.getLastName());
//            Thread.sleep(30000);
//            password.sendKeys(registrationDetails.getPassword());
//            Thread.sleep(30000);
//            rePassword.sendKeys(registrationDetails.getPassword2());
//            Thread.sleep(30000);
//            email.sendKeys(registrationDetails.getEmail());
//            Thread.sleep(30000);
//            reTypeEmail.sendKeys(registrationDetails.getEmail2());
//            Thread.sleep(30000);
//            registerButton.click();
        }catch (InterruptedException e){
            System.out.println(" caught");
        }
    }
}
