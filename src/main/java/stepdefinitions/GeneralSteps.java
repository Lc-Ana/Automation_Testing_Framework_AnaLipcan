package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.TestContext;

public class GeneralSteps {
    private TestContext context;

    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String UrlAddress) throws Throwable {
        context.getWebDriverManager().getDriver().get(UrlAddress);
    }

    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String keyWord) throws Throwable {
        boolean containsCorrectUrlEndPoint = context.getWebDriverManager().getDriver().getCurrentUrl().contains(keyWord);
        Assertions.assertTrue(containsCorrectUrlEndPoint, "The actual url does not contain the correct endpoint");
    }
}
