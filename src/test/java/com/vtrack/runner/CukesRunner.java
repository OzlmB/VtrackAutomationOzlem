package com.vtrack.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/feature",
        glue = "com/vtrack/setep_Definition",
        dryRun = true ,
        tags = "@Ozl"


)
public class CukesRunner {
}
