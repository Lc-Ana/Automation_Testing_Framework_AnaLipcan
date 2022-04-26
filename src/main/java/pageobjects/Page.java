package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract  class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    private WebElement myAccountIcn;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement registerBtn;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    private WebElement loginBtn;


    public void navigateToRegisterPageViaHeader() {
        myAccountIcn.click();
        registerBtn.click();
    }

    public void navigateToLoginPage() {
        myAccountIcn.click();
        loginBtn.click();
    }

}