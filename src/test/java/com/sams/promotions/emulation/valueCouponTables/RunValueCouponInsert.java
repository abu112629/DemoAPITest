
package com.sams.promotions.emulation.valueCouponTables;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		// tags= {"@Regression"},
		features = { "src/test/resources/promotions/emulator/valueCouponTables/" }, glue = {
				"com/sams/promotions/emulation/valueCouponTables/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json"}

)

public class RunValueCouponInsert {

}
