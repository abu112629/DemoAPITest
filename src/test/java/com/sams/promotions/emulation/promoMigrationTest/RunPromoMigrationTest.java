package com.sams.promotions.emulation.promoMigrationTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


					@RunWith(Cucumber.class)
					@CucumberOptions(
							
							monochrome=true,
							//dryRun=true,
							
							
				
							features= {"src/test/resources/promotions/emulator/PromoMigrationTest/"},
							glue= {"com/sams/promotions/emulation/promoMigrationTest/"},
							
							
							
							plugin= {"pretty",
									"html:target/cucumber-htmlreport",
									"json:target/cucumber-report.json",
									"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReportPromoTest.html" 
							}
							
							)



public class RunPromoMigrationTest {

						

	
}
