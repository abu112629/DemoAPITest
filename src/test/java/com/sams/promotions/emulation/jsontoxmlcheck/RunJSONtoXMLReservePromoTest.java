package com.sams.promotions.emulation.jsontoxmlcheck;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


					@RunWith(Cucumber.class)
					@CucumberOptions(
							
							monochrome=true,
							//dryRun=true,
							
									tags= {"@Regression"},
							features= {"src/test/resources/promotions/emulator/JSONtoXMLReserveConverter/"},
							glue= {"com/sams/promotions/emulation/jsontoxmlcheck/"},
							
							
							
							plugin= {"pretty",
									"html:target/cucumber-htmlreport",
									"json:target/cucumber-report.json",
									"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport5.html"
							}
							
							)



public class RunJSONtoXMLReservePromoTest {

						
						

	
}
