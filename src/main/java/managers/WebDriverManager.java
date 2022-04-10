package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverManager {

    public WebDriverManager(String browserType) {
        this.browserType = browserType;
    }

    private WebDriver driver;
    private String browserType;

    private void initialiseDriver() {
        switch (browserType) {
            case "CHROME", "chrome", "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FIREFOX", "FireFox", "Firefox", "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "Microsoft Edge", "Edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Optiunea de web driver indicata nu este valabila. Mai incearca.");
        }
    }

    public WebDriver getDriver() {
        if(driver == null){
            initialiseDriver();
        }
        return this.driver;
    }
}
