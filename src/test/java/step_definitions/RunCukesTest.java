package step_definitions;

import modules.HotelsData;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		tags = {"@hotel"}
		)
public class RunCukesTest{
	public static String browser = "chrome";
	public static boolean remote = true;
	public static String url = "https://hotels-staging.eurostar.com";
	public static HotelsData hotelsData = new HotelsData();
}