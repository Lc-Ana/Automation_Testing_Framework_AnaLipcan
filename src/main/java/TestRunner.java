import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {

//        WebDriverManager FfDriverManager = new WebDriverManager("firefox");
//        FfDriverManager.getDriver().get("https://www.mozilla.org/ro/firefox/");
//        FfDriverManager.getDriver().close();

//        WebDriverManager ChDriverManager = new WebDriverManager("chrome");
//        ChDriverManager.getDriver().get("https://www.google.com/");
//        ChDriverManager.getDriver().close();

        WebDriverManager EgDriverManager = new WebDriverManager("Edge");
        EgDriverManager.getDriver().get("https://www.msn.com/en-xl/");
        EgDriverManager.getDriver().close();
    }
}
