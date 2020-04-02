package com.sams.promotions.emulation.createMembers;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


					@RunWith(Cucumber.class)
					@CucumberOptions(
							
							monochrome=true,
							//dryRun=true,
							
							
							//tags= {"@MemberCreation"},
							features= {"src/test/resources/promotions/CreateMembers/"},
							glue= {"com/sams/promotions/emulation/createMembers/"},
							
							
							
							plugin= {"pretty",
									"html:target/cucumber-htmlreport",
									"json:target/cucumber-report.json"
							}
							
							)



public class RunCreateMemberTest {

						

	
}
