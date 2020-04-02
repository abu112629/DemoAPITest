
package com.sams.promotions.emulation.xmltojsoncheck;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		// tags= {"@Regression"},
		features = { "src/test/resources/promotions/emulator/XMLtoJSONReserveConverter/" }, glue = {
				"com/sams/promotions/emulation/xmltojsoncheck/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport7.html" }

)

public class RunXMLtoJsonReservePromoTest {

}
