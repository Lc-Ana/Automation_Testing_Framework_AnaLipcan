package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    private WebElement myAccountBtn;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement registerBtn;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    private WebElement loginBtn;
    @FindBy(xpath = "//*[@id=\"logo\"]/a/img")
    private WebElement logoutBtn;

    public void navigateToRegisterPageViaHeader() {
        myAccountBtn.click();
        registerBtn.click();
    }

    public void navigateToLoginPage() {
        myAccountBtn.click();
        loginBtn.click();
    }
    public void navigateToLogoutPage(){
        myAccountBtn.click();
        logoutBtn.click();
    }
}