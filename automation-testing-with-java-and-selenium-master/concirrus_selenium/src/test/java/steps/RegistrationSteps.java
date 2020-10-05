package steps;

import clients.RegistrationClient;
import cucumber.api.java.en.Given;
import entities.RegistrationDetails;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterationPage;

public class RegistrationSteps extends TestBase {
    RegistrationClient registrationClient;
    private static String FIRST_NAME = "firstName";
    private static String LAST_NAME = "lastName";
    private static String PASSWORD = "password";
    private static String PASSWORD2 = "password2";
    private static String EMAIL = "email";
    private static String EMAIL2 = "email2";

    RegisterationPage registerationPage;

    public RegistrationSteps() {
        RegisterationPage loginPage = PageFactory.initElements(driver, RegisterationPage.class);
    }


    @Given("^all the registration detail$")
    public void allTheRegistrationDetail() {
        RegistrationDetails registrationDetails = RegistrationDetails.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .password2(PASSWORD2)
                .password(PASSWORD)
                .email(EMAIL)
                .email2(EMAIL2)
                .build();
        registerationPage.register(registrationDetails);
    }
}
