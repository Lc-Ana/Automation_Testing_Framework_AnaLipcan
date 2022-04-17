package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInputField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInputField;
    @FindBy(id = "input-email")
    private WebElement emailInputField;
    @FindBy(id = "input-telephone")
    private WebElement phoneInputField;
    @FindBy(id = "input-password")
    private WebElement pswInputField;
    @FindBy(id = "input-confirm")
    private WebElement pswConfInputField;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement submitBtn;

    public void populateRegisterFormWithData(String firstName, String lastName, String email, String phone,
                                             String psw, String pswConfirm) {
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        emailInputField.sendKeys(email);
        phoneInputField.sendKeys(phone);
        pswInputField.sendKeys(psw);
        pswConfInputField.sendKeys(pswConfirm);
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }
}