package pageobjects;

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
}