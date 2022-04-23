import managers.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import java.util.concurrent.ThreadLocalRandom;

public class TestJunitRunner {
    WebDriverManager chDriverManager = new WebDriverManager("chrome");

    @BeforeEach
    public void configureTestPreconditions() {
        chDriverManager.getDriver().get("https://www.demo-opencart.com/");
        chDriverManager.getDriver().manage().window().maximize();
    }

    @AfterEach
    public void tearDownActivities() {
        chDriverManager.getDriver().close();
        chDriverManager.getDriver().quit();
    }

    @Test
    @DisplayName("The Registration Page can be accessed from navigation bar")
    public void registerPageIsOpened() throws InterruptedException {
        HomePage homePage = new HomePage(chDriverManager.getDriver());
        homePage.navigateToRegisterPageViaHeader();

        boolean containsCorrectUrlEndPoint =
                chDriverManager.getDriver().getCurrentUrl().contains("index.php?route=account/register");
        Assertions.assertTrue(containsCorrectUrlEndPoint, "The actual url does not contain the correct endpoint");
    }

    @Test
    @DisplayName("Correct error message is displayed when trying to create a user without checking the Privacy Policy")
    public void errorMessageIsDisplayedWhenCreatingAccountWithoutAcceptingThePrivacyPolicy() {
        HomePage homePage = new HomePage(chDriverManager.getDriver());
        homePage.navigateToRegisterPageViaHeader();

        RegisterPage registerPage = new RegisterPage(chDriverManager.getDriver());
        registerPage.populateRegisterFormWithData("Adrian", "Olaru", "adrian.o@gmail.com",
                "025478654", "psw321", "psw321");
        registerPage.clickSubmitBtn();

        WebElement errorMessageForLackOfPrivacyPolicy =
                chDriverManager.getDriver().findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));

        String expectedErrorText = " Warning: You must agree to the Privacy Policy!";
        String actualErrorResult = errorMessageForLackOfPrivacyPolicy.getText();

        Assertions.assertEquals(expectedErrorText.trim(), actualErrorResult,
                "The error message is not correct, please check the error that was displayed.");
    }

    @Test
    @DisplayName("The account is successful registered checking the Privacy Policy")
    public void creatingAnAccount(){
        String randomMail;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5000 + 1);
        HomePage homePage = new HomePage(chDriverManager.getDriver());
        homePage.navigateToRegisterPageViaHeader();
        randomMail = "adrian.o"+ randomNum +"@gmail.com";
        RegisterPage registerPage = new RegisterPage(chDriverManager.getDriver());
        registerPage.populateRegisterFormWithData("olaru", "adrian", randomMail,
                "5254584550", "adrian123", "adrian123");
        registerPage.acceptPrivacyPolicy();
        registerPage.clickSubmitBtn();
        System.out.println(randomMail);
    }

    @Test
    @DisplayName("An existing user can sign in with valid credentials")
    public void loginAccountWithExistingUser(){
        HomePage homePage = new HomePage(chDriverManager.getDriver());
        homePage.navigateToLoginPage();

        AccountPage accountPage = new AccountPage(chDriverManager.getDriver());
        accountPage.loginIntoAccount("adrian.o4652@gmail.com", "adrian123");
        accountPage.clickLOginBtn();

        boolean userSignInHisAccount =
                chDriverManager.getDriver().getCurrentUrl().contains("index.php?route=account/account");

        Assertions.assertTrue(userSignInHisAccount, "User is not redirected to the right link");
    }
}