import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@search",
        plugin = {"html:target/my-report.html"},
        publish = false,
        glue = {"/hooks", "/steps", "/support"}
)
public class RunCucumberTest {
}
