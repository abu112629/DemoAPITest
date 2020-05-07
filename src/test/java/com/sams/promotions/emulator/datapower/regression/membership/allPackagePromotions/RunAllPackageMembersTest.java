
package com.sams.promotions.emulator.datapower.regression.membership.allPackagePromotions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, // dryRun=true,
		tags= {"@regressionPackage"},

		features = { "src/test/resources/promotions/emulator/PackageRegression/" }, 
		glue = {"com/sams/promotions/emulator/datapower/regression/membership/allPackagePromotions/" },

		plugin = { "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReportPackageTest.html" }

)

public class RunAllPackageMembersTest {

}
