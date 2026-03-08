package testRunnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

  @CucumberOptions( 
   plugin = { "pretty","html:target/MyReport/report.html"},
  features = { "src/test/resources/testFeatures"}, 
    glue ={"testWebStepDefination", "appHooks" }, 
    tags = "@WomenDressTest01",
    dryRun =false 
    //monochrome= true 
    )
 

public class ScenarioTest {

}

