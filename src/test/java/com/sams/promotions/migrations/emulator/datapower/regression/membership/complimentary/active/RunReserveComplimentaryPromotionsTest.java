package com.sams.promotions.migrations.emulator.datapower.regression.membership.complimentary.active;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


					@RunWith(Cucumber.class)
					@CucumberOptions(
							
							monochrome=true,
							//dryRun=true,
							
							
							features= {"src/test/resources/promotions/emulator/RegressionPromotionsMigrationActiveComplimentaryMember/"},
							glue= {"com/sams/promotions/migrations/emulator/datapower/regression/membership/complimentary/active/"},
							
							tags= {"@Primarycomplimentaryregression"},
							
							plugin= {"pretty",
									"html:target/cucumber-htmlreport",
									"json:target/cucumber-report.json"
							}
							
							)



public class RunReserveComplimentaryPromotionsTest {


	
}
