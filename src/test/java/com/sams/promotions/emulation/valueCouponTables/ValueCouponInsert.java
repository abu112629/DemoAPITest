package com.sams.promotions.emulation.valueCouponTables;

import java.io.IOException;
import java.sql.ResultSet;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ValueCouponInsert extends BaseStep{

	public ValueCouponInsert() throws IOException {
		super();
	}

	private ClientConfigurationDatabase connection;
	protected ResultSet rs,rs1,rs2;
	
	@Given("^Values to Update value coupon Table$")
	public void Values_to_Update_VAL_CPN_Table(DataTable dataTable) throws Exception {

		connection = new ClientConfigurationDatabase();
		rs = connection.PromotionsDB2(dataTable);
		
	}
	
	 @Then ("^Values to Update value coupon Items$")
	 
	 public void Values_to_Update_VAL_ITM_Table(DataTable dataTable) throws Exception {

			connection = new ClientConfigurationDatabase();
			rs1 = connection.Promotions_VAL_CPN_ITEM(dataTable);
			
		}
	 
	 
	 @Then ("^Values to Update value coupon Store$") 
	 public void Values_to_Update_VAL_STR_Table(DataTable dataTable) throws Exception {

			connection = new ClientConfigurationDatabase();
			rs2 = connection.Promotions_VAL_CPN_STORE(dataTable);
			
		}
	 
}
