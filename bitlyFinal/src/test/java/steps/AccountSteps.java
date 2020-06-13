package steps;

import api.EndPoints;
import io.cucumber.java.en.Given;

public class AccountSteps {

    private static final String accessToken = "8d57695d54d27cca8107ad7a0ed0ba69b02176fa";
    private EndPoints endPoints;

    public AccountSteps(EndPoints endPoints) {
        this.endPoints = endPoints;
    }

    @Given("^I am an authorized bitly user$")
    public void iAmAnAuthorizedBitlyUser() {
        endPoints.authenticateUser(accessToken);
    }

}