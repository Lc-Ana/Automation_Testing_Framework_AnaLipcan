import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestRunner {
    public static void main(String[] args) throws Exception{


        WebDriverManager ChDriverManager = new WebDriverManager("chrome");
        ChDriverManager.getDriver().get("https://www.demo-opencart.com/");
        ChDriverManager.getDriver().manage().window().maximize();

        WebElement myAccIcon = ChDriverManager.getDriver().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
        myAccIcon.click();

        //Actions did on the registration page
//        WebElement registerOption = ChDriverManager.getDriver().findElement(By.linkText("Register"));
//        Thread.sleep(1000);
//        WebElement firstNameInputField = ChDriverManager.getDriver().findElement(By.id("input-firstname"));
//        WebElement lastNameInputField = ChDriverManager.getDriver().findElement(By.id("input-lastname"));
//        WebElement emailInputField = ChDriverManager.getDriver().findElement(By.id("input-email"));
//        WebElement phoneInputField = ChDriverManager.getDriver().findElement(By.id("input-telephone"));
//        WebElement pswInputField = ChDriverManager.getDriver().findElement(By.id("input-password"));
//        WebElement pswConfInputField = ChDriverManager.getDriver().findElement(By.id("input-confirm"));
//        WebElement newsletterCheck = ChDriverManager.getDriver().findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"));
//        WebElement privacyPolicyCheck = ChDriverManager.getDriver().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
//        WebElement submitBtn = ChDriverManager.getDriver().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
//
//        registerOption.click();
//        firstNameInputField.sendKeys("Ana");
//        lastNameInputField.sendKeys("Lipan");
//        emailInputField.sendKeys("lipcanana@mail.ru");
//        phoneInputField.sendKeys("865275421");
//        pswInputField.sendKeys("password123");
//        pswConfInputField.sendKeys("password123");
//        newsletterCheck.click();
//        privacyPolicyCheck.click();
//        submitBtn.click();
//        Thread.sleep(3000);
        
        //Actions did for Login/Logout
        WebElement loginOption = ChDriverManager.getDriver().findElement(By.linkText("Login"));
        loginOption.click();
        WebElement emailInputField = ChDriverManager.getDriver().findElement(By.id("input-email"));
        emailInputField.sendKeys("lipcanana@mail.ru");
        WebElement pswInputField = ChDriverManager.getDriver().findElement(By.id("input-password"));
        pswInputField.sendKeys("password123");
        WebElement loginBtn = ChDriverManager.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        loginBtn.click();
        Thread.sleep(1500);
        WebElement myAccIcon2 = ChDriverManager.getDriver().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]"));
        myAccIcon2.click();
        WebElement logoutOption = ChDriverManager.getDriver().findElement(By.linkText("Logout"));
        logoutOption.click();
        Thread.sleep(1500);

        ChDriverManager.getDriver().close();
        ChDriverManager.getDriver().quit();
    }
}
