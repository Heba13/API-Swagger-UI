package swagger.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/java/swaggere/test/Brands.feature",
            glue = {"swagger/test"},
            plugin = {"html:reports/Brands.html"},
            monochrome = true
    )

    public class BrandsRunner extends AbstractTestNGCucumberTests {
    }

