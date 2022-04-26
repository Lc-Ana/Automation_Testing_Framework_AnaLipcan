package stepdefinitions;

import pageobjects.RegisterPage;
import utils.TestContext;

public class RegistrationSteps {
    private TestContext context;
    private RegisterPage registerPage;

    public RegistrationSteps(TestContext testContext) {
        context = testContext;
        registerPage = new RegisterPage(context.getWebDriverManager().getDriver());
    }
}