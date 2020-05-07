
package com.sams.promotions.emulator.datapower.regression.membership.allBroadReachPromotions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,
		tags= {"@regressionBroadReach"},

		features = { "src/test/resources/promotions/emulator/BroadReachRegression/" }, 
		glue = {"com/sams/promotions/emulator/datapower/regression/membership/allBroadReachPromotions/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReportBroadReachTest.html" }

)

public class RunAllBroadReachMembersTest {

}
