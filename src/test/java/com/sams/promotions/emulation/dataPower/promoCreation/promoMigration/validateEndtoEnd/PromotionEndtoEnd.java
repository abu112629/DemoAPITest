package com.sams.promotions.emulation.dataPower.promoCreation.promoMigration.validateEndtoEnd;

import java.io.IOException;

import com.sams.promotions.emulation.test.base.BaseStep;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PromotionEndtoEnd extends BaseStep{
	
	public PromotionEndtoEnd() throws IOException {
		super();
	}

	@Given("^Validate Promo document for ISPROMO number in Cosmos$")
	public void validate_Promo_document_for_ISPROMO_number_in_Cosmos() throws Throwable {
		
		
	  
	}

	@Given("^Validate values are updated for Promo Id in DB$")
	public void validate_values_are_updated_for_Promo_Id_in_DB(int arg1) throws Throwable {
	    
	}

	@When("^Compare values for both DBs$")
	public void compare_values_for_both_DBs() throws Throwable {
	   
	}

	@When("^Send a request to Instant Savings Cert and InstantSavings Legacy$")
	public void send_a_request_to_Instant_Savings_Cert_and_InstantSavings_Legacy() throws Throwable {
	    
	}

	@Then("^Compare both the responses$")
	public void compare_both_the_responses() throws Throwable {
	    
	}

	@Then("^Validate Reserve DB in Cosmos for Instant Savings Cert$")
	public void validate_Reserve_DB_in_Cosmos_for_Instant_Savings_Cert() throws Throwable {
	  
	}

	@Then("^Validate CPN_TXN Table for Instant Savings Cert and InstantSavings Legacy$")
	public void validate_CPN_TXN_Table_for_Instant_Savings_Cert_and_InstantSavings_Legacy() throws Throwable {
	   
	}
	    


}
