import managers.WebDriverManager;
import pageobjects.AccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) throws Exception{

        WebDriverManager ChDriverManager = new WebDriverManager("chrome");
        ChDriverManager.getDriver().get("https://www.demo-opencart.com/");
        ChDriverManager.getDriver().manage().window().maximize();
      
        //First action - registration
        HomePage homePage = new HomePage(ChDriverManager.getDriver());
        homePage.navigateToRegisterPageViaHeader();
        RegisterPage registerPage = new RegisterPage(ChDriverManager.getDriver());
        registerPage.populateRegisterFormWithData("ana", "lipcan", "lipcanana1997@gmail.com",
                "12345678", "password123", "password123");
        registerPage.clickSubmitBtn();

        //Second action - login in an existing account (created in the task_01 webelements_register_flow)
        AccountPage accountPage = new AccountPage(ChDriverManager.getDriver());
        accountPage.navigateToLoginPage();
        accountPage.loginIntoAccount("lipcanana@mail.ru", "password123");
        accountPage.clickLOginBtn();
        Thread.sleep(1000);

        //Third action - search in item, add to wish list and logout
        accountPage.performSearchFor("HP LP3065");
        accountPage.adItemToWishList();
        accountPage.goToHomePage();
        accountPage.navigateToLogoutPage();
        Thread.sleep(2000);

        ChDriverManager.getDriver().close();
        ChDriverManager.getDriver().quit();
    }
}