
package com.sams.promotions.emulation.dataPower.emulator.allEndtoEndServices;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		// tags= {"@Important"},

		// tags= {"~@Regression"},
		features = { "src/test/resources/promotions/emulator/InstantSavings/" }, glue = {
				"com/sams/promotions/emulation/dataPower/emulator/allEndtoEndServices" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport3.html" }

)

public class RunInstantSavingsPromoTest {

}
