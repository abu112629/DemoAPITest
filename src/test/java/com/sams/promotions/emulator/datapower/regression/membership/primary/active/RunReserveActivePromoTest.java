
package com.sams.promotions.emulator.datapower.regression.membership.primary.active;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		features = { "src/test/resources/promotions/emulator/RegressionPromotionsActivePrimaryMember/" }, glue = {
				"com/sams/promotions/emulator/datapower/regression/membership/primary/active/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport6.html" }

)

public class RunReserveActivePromoTest {

}
