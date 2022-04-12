import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {

        WebDriverManager EgDriverManager = new WebDriverManager("Edge");
        EgDriverManager.getDriver().get("https://www.msn.com/en-xl/");
        EgDriverManager.getDriver().close();
        EgDriverManager.getDriver().quit();
    }
}
