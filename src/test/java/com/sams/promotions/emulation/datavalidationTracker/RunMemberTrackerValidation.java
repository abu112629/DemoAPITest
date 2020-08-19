package com.sams.promotions.emulation.datavalidationTracker;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		//tags= {"@memberTracker"},

		// tags= {"~@Regression"},
		features = { "src/test/resources/promotions/emulator/TrackerValidation/" }, glue = {
				"com/sams/promotions/emulation/datavalidationTracker" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/DataTracker.html" }

)

public class RunMemberTrackerValidation {

}
