package com.sams.promotions.emulation.createPromotions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


					@RunWith(Cucumber.class)
					@CucumberOptions(
							
							monochrome=true,
							//dryRun=true,
							
							
							tags= {"@Sanity"},
							features= {"src/test/resources/promotions/emulator/CreatePromotions/"},
							glue= {"com/sams/promotions/emulation/createPromotions/"},
							
							
							
							plugin= {"pretty",
									"html:target/cucumber-htmlreport",
									"json:target/cucumber-report.json"
							}
							
							)



public class RunCreatePromoTest {

						

	
}
