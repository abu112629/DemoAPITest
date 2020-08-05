package com.sams.promotions.emulation.dataPower.emulator.allEndtoEndServices;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		tags= {"@smoke"},

		// tags= {"~@Regression"},
		features = { "src/test/resources/promotions/emulator/InstantSavings/" }, glue = {
				"com/sams/promotions/emulation/dataPower/emulator/allEndtoEndServices" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/DbValidationsTest.html" }

)

public class RunInstantSavingsPromoTest {

}
