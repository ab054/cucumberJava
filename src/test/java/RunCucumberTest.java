import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/my-report.html"},
        publish = false,
        features = {"src/test/resources/features/counter.feature"},
        glue = {"/hooks", "/steps", "/support"}
)
public class RunCucumberTest {
}
