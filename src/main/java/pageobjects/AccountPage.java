package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    private WebElement emailInputField;
    @FindBy(id = "input-password")
    private WebElement pswInputField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement loginSubmitBtn;
    @FindBy(xpath = "//*[@id=\"search\"]/input")
    private WebElement searchInputField;
    @FindBy(xpath = "//*[@id=\"search\"]/span/button")
    private WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"content\"]/div[9]/div/div/div[2]/div[1]/h4/a")
    private WebElement foundItem;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")
    private WebElement wishBtn;
    @FindBy(xpath = "//*[@id=\"logo\"]/a/img")
    private WebElement homeBtn;
    @FindBy(linkText = "Logout")
    private WebElement logoutBtn;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    private WebElement myAccountBtn;
    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    private WebElement messageErrorBadCredentials;

    public void loginIntoAccount(String email, String psw) {
        emailInputField.sendKeys(email);
        pswInputField.sendKeys(psw);
    }

    public void clickLOginBtn() {
        loginSubmitBtn.click();
    }

    public void performSearchFor(String itemToSearch) {
        searchInputField.sendKeys(itemToSearch);
        searchBtn.click();
    }

    public void adItemToWishList() {
        foundItem.click();
        wishBtn.click();
    }

    public void goToHomePage() {
        homeBtn.click();
    }

    public void navigateToLogoutPage(){
        myAccountBtn.click();
        logoutBtn.click();
    }

    public void showErrorMessageWithBadCredentials(){
        String expectedErrorMessage = " Warning: No match for E-Mail Address and/or Password.";
        String actualErrorMessage = messageErrorBadCredentials.getText();
        Assertions.assertEquals(expectedErrorMessage.trim(), actualErrorMessage,
                "The actual result non corresponds to expected result, check it again.");
    }
}