
package com.sams.promotions.migrations.emulator.datapower.regression.membership.addon.complimentary.active;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		features = {
				"src/test/resources/promotions/emulator/RegressionPromotionsMigrationActiveAddOnComplimentaryMember/" }, glue = {
						"com/sams/promotions/migrations/emulator/datapower/regression/membership/addon/complimentary/active/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport4.html" }

)

public class RunReserveAddOnComplimentaryPromotionsTest {

}
