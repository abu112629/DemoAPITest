
package com.sams.promotions.emulator.regression.metaData;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,

		features = { "src/test/resources/promotions/emulator/MetadataPromotions/" }, glue = {
				"com/sams/promotions/emulator/regression/metaData/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport3.html" }

)

public class RunMetaDataPromotionsTest {

}
