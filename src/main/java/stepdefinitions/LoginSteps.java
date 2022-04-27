package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.AccountPage;
import utils.TestContext;

public class LoginSteps {

    private TestContext context;
    private AccountPage accountPage;

    public LoginSteps(TestContext testContext) {
        context = testContext;
        accountPage = new AccountPage(context.getWebDriverManager().getDriver());
    }

    @When("^user clicks on login button from navigation bar$")
    public void userClicksOnLoginButtonFromNavigationBar() {
        accountPage.navigateToLoginPage();
        accountPage.clickLOginBtn();
    }

    @And("^insert valid credentials$")
    public void insertValidCredentials() {
        userClicksOnLoginButtonFromNavigationBar();
        accountPage.loginIntoAccount("lipcanana@mail.ru", "password123");
        accountPage.clickLOginBtn();
    }

    @And("^insert invalid credentials$")
    public void insertInvalidCredentials() {
        userClicksOnLoginButtonFromNavigationBar();
        accountPage.loginIntoAccount("lipcanana@mail.ru", "pass");
        accountPage.clickLOginBtn();
    }

    @Then("^an error message is showed$")
    public void anErrorMessageIsShowed() {
        accountPage.showErrorMessageWithBadCredentials();
    }

    @When("^user clicks on logout button from navigation bar$")
    public void userClicksOnLogoutButtonFromNavigationBar() {
        accountPage.navigateToLogoutPage();
    }

    @Given("^user is logged in open cart webpage$")
    public void userIsLoggedInOpenCartWebpage() throws InterruptedException {
        userClicksOnLoginButtonFromNavigationBar();
        insertValidCredentials();
    }
}