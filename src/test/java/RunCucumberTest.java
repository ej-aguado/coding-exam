import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.assurity.exam",
        monochrome = true,
        glue = "stepDefinitions",
        strict = true,
        plugin = {"pretty"}
)
public class RunCucumberTest {
}