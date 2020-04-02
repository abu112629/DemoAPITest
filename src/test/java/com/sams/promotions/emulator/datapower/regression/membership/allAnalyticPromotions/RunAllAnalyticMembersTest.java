
package com.sams.promotions.emulator.datapower.regression.membership.allAnalyticPromotions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,
		//tags= {"regressionAnalytic"},

		features = { "src/test/resources/promotions/emulator/allPromotionsMembers/" }, 
		glue = {"com/sams/promotions/emulator/datapower/regression/membership/allAnalyticPromotions/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReportTest.html" }

)

public class RunAllAnalyticMembersTest {

}
