package com.sams.promotions.emulation.refundLookUpTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,
		//tags= {"@regressionBroadReach"},

		features = { "src/test/resources/promotions/emulator/RefundLookUp/" }, 
		glue = {"com/sams/promotions/emulation/refundLookUpTest/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReportRefundTest.html" }

)

public class RunRefundLookUpTest {

}
