package com.sams.promotions.emulation.promoMigrationTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.PrimaryRequestHelper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;
import com.sams.promotions.emulator.datapower.regression.membership.allAnalyticPromotions.MemberSelect;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class PromoMigrationTest extends BaseStep {

	protected String membershipNbr;
	HeaderMapper headerMapper;
	protected long PromoNumber, Itemnumber, Mpq;
	protected ArrayList<String> arrList = new ArrayList<String>();
	protected float Discount;
	protected String StartDate, EndDate, arr[];
	protected int pro1, pro2;
	MemberSelect memberrequest;
	ClientConfigurationDatabase connection;
	SoftAssertions softAssertions;

	public PromoMigrationTest() throws IOException {
		super();

	}

	@Before
	public void beforeSetup() throws IOException {

		headerMapper = new HeaderMapper();
		helper = new Helper();
		membership = new Membership();
		reserveemulator = new ReserveEmulationHelper();
		memberrequest=new MemberSelect();
		primaryrequest = new PrimaryRequestHelper();
		connection=new ClientConfigurationDatabase();
		softAssertions=new SoftAssertions();
	}

	@Given("^Promotions Migrated Count and assert Total successful promotions$")
	public void Migrate_Assertion() throws Exception {
		
		
		
		
		String arrbroad = reserveemulator.QSPromoMetaData(prop.get("mercury.quicksilver").toString(),1);
		Map<String, String> mapx = Helper.getQSPromotionDetails(arrbroad);
		int qsp=Integer.valueOf(mapx.get("Total"));
		int i=0;
		
		while(i<qsp) {
			
			String arrqs = reserveemulator.QSPromoMetaData(prop.get("mercury.quicksilver").toString(),i);
			Map<String, String> mapqs = Helper.getQSPromotionDetails(arrqs);
			String VCN = mapqs.get("QSOfferId"); 
			connection.getPromos(VCN);
			
			i++;
			
		}
		
		softAssertions.assertAll();
	
	}
}
