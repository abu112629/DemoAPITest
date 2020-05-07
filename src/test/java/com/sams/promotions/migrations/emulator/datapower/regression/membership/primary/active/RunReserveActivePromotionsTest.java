package com.sams.promotions.migrations.emulator.datapower.regression.membership.primary.active;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


					@RunWith(Cucumber.class)
					@CucumberOptions(
							
							monochrome=true,
							//dryRun=true,
							
							
							features= {"src/test/resources/promotions/emulator/RegressionPromotionsMigrationActivePrimaryMember/"},
							glue= {"com/sams/promotions/migrations/emulator/datapower/regression/membership/primary/active/"},
							tags= {"@Primaryactiveregression"},
							
							
							
							plugin= {"pretty",
									"html:target/cucumber-htmlreport",
									"json:target/cucumber-report.json"
							}
							
							)



public class RunReserveActivePromotionsTest {


	
}
