package com.sams.promotions.emulator.datapower.regression.membership.allAnalyticPromotions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class MemberSelect {
	
	
	public String memberRequest(String memberRequest,String type,String tier) throws IOException {
		
		try(Stream<String> stream =Files.lines(Paths.get("src/test/resources/Emulation_Input/Members.txt"))){
			
			String requiredMembership="";
			
			switch(memberRequest) {
			
			case "primary":
				
				switch(type) {
			
						case "business":
							
							switch(tier) {
							
								case "Club":
									
									
									requiredMembership=stream.skip(9).findFirst().get();
									
									break;
							
								case "Plus":
									
									requiredMembership=stream.skip(8).findFirst().get();
									break;
							
							
							}
							
						   break;
							
						case "savings":
							
							switch(tier) {
							
									case "Club":
										
										requiredMembership=stream.skip(1).findFirst().get();

										break;
										
								
									case "Plus":
										
										requiredMembership=stream.findFirst().get();

										
										break;
									
							
							}
							break;					
					
					
			}
				break;
				
				case "complimentary":
				
				switch(type) {
			
						case "business":
							
							switch(tier) {
							
								case "Club":
									
									
									requiredMembership=stream.skip(10).findFirst().get();
									break;
							
								case "Plus":
									
									requiredMembership=stream.skip(11).findFirst().get();
									break;
							
							
							}
							
						   break;
							
						case "savings":
							
							switch(tier) {
							
									case "Club":
										
										
										requiredMembership=stream.skip(2).findFirst().get();
										
										break;
								
									case "Plus":
										
										requiredMembership=stream.skip(3).findFirst().get();
										break;
									
							
							}
							break;					
					
					
			}
				break;
				
				case "addon complimentary":
					
					switch(type) {
				
							case "business":
								
								switch(tier) {
								
									case "Club":
								
										requiredMembership=stream.skip(14).findFirst().get();
										
										break;
								
									case "Plus":
										
										requiredMembership=stream.skip(15).findFirst().get();
								
										break;
								
								
								}
								
							   break;
								
							case "savings":
								
								switch(tier) {
								
										case "Club":
											
									
											requiredMembership=stream.skip(6).findFirst().get();
											break;
									
										case "Plus":
											
											requiredMembership=stream.skip(7).findFirst().get();
											break;
										
								
								}
								break;					
						
						
				}
				break;
				
				
				case "addon":
					
					switch(type) {
				
							case "business":
								
								switch(tier) {
								
									case "Club":
										
										requiredMembership=stream.skip(12).findFirst().get();
										break;
								
									case "Plus":
							
										requiredMembership=stream.skip(13).findFirst().get();
										break;
								
								
								}
								
							   break;
								
							case "savings":
								
								switch(tier) {
								
										case "Club":
									
											requiredMembership=stream.skip(4).findFirst().get();
											break;
									
										case "Plus":
									
											requiredMembership=stream.skip(5).findFirst().get();

											break;
										
								
								}
								break;					
						
						
				}
				break;
			}
			
			stream.close();
			
			return requiredMembership;
			
			
			
			
			
		}
				
		
		
	}
	
		

}
