
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features",
        glue = "stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = {},
        plugin = {"pretty", "html:target/cucumberreports"}
)
public class CucumberTestRunner {
}
