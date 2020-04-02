package com.sams.promotions.emulation.createMembers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.test.base.BaseStep;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

@SpringBootTest

@RunWith(SpringRunner.class)

public class CreateMembers extends BaseStep {

	Membership_Types member;
	

	public CreateMembers() throws IOException {
		super();

	}

	@Before
	public void beforeSetup() throws IOException {

		member=new Membership_Types();
	}

	@Given("^Create Member$")
	public void Member_creation() throws Exception {
		
		 
		
		  String primarysavingsPlusmembershipNbr = member.getMembershipType("primary",
		  "savings", "Plus"); String primarysavingsClubmembershipNbr =
		  member.getMembershipType("primary", "savings", "Club"); String
		  complimentarysavingsClubmembershipNbr =
		  member.getMembershipType("complimentary", "savings", "Club"); String
		  complimentarysavingsPlusmembershipNbr =
		  member.getMembershipType("complimentary", "savings", "Plus"); String
		  addOnsavingsClubmembershipNbr = member.getMembershipType("addon", "savings",
		  "Club"); String addOnsavingsPlusmembershipNbr =
		  member.getMembershipType("addon", "savings", "Plus"); String
		  addOncomplimentarysavingsClubmembershipNbr =
		  member.getMembershipType("addon complimentary", "savings", "Club"); String
		  addOncomplimentarysavingsPlusmembershipNbr =
		  member.getMembershipType("addon complimentary", "savings", "Plus");
		  
		  
		  String primarybusinessPlusmembershipNbr = member.getMembershipType("primary",
		  "business", "Plus"); String primarybusinessClubmembershipNbr =
		  member.getMembershipType("primary", "business", "Club"); String
		  complimentarybusinessClubmembershipNbr =
		  member.getMembershipType("complimentary", "business", "Club"); String
		  complimentarybusinessPlusmembershipNbr =
		  member.getMembershipType("complimentary", "business", "Plus"); String
		  addOnbusinessClubmembershipNbr = member.getMembershipType("addon",
		  "business", "Club"); String addOnbusinessPlusmembershipNbr =
		  member.getMembershipType("addon", "business", "Plus"); String
		  addOncomplimentarybusinessClubmembershipNbr =
		  member.getMembershipType("addon complimentary", "business", "Club"); String
		  addOncomplimentarybusinessPlusmembershipNbr =
		  member.getMembershipType("addon complimentary", "business", "Plus");
		  
		  
		  
		  BufferedWriter writer = new BufferedWriter(new
		  FileWriter("src/test/resources/Emulation_Input/Promotions.txt"));
		  
		  writer.write(primarysavingsPlusmembershipNbr);
		  writer.newLine();
		  writer.write(primarysavingsClubmembershipNbr);
		  writer.newLine(); writer.write(complimentarysavingsClubmembershipNbr); 
		  writer.newLine();
		  writer.write(complimentarysavingsPlusmembershipNbr); writer.newLine();
		  writer.write(addOnsavingsClubmembershipNbr);
		  writer.newLine();
		  writer.write(addOnsavingsPlusmembershipNbr);
		  writer.newLine(); writer.write(addOncomplimentarysavingsClubmembershipNbr); writer.newLine();
		  writer.write(addOncomplimentarysavingsPlusmembershipNbr); writer.newLine();
		  
		  writer.write(primarybusinessPlusmembershipNbr);
		  writer.newLine();
		  writer.write(primarybusinessClubmembershipNbr);
		  writer.newLine(); writer.write(complimentarybusinessClubmembershipNbr); writer.newLine();
		  writer.write(complimentarybusinessPlusmembershipNbr); writer.newLine();
		  writer.write(addOnbusinessClubmembershipNbr);
		  writer.newLine();
		  writer.write(addOnbusinessPlusmembershipNbr);
		  writer.newLine(); writer.write(
		  addOncomplimentarybusinessClubmembershipNbr); writer.newLine();
		  writer.write(addOncomplimentarybusinessPlusmembershipNbr); writer.newLine();
		  
		  writer.close();
		 

	}


}
