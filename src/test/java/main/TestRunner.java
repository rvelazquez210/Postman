package main;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/Usuario/Documents/CapacitacionPostman/api-qa/src/test/java/features/libros.feature",
		glue = {"step_definitions"},
		dryRun = false,
		plugin = {"pretty","html:test-output"},
		tags = {""},
		strict = true)

public class TestRunner{
	
	
}