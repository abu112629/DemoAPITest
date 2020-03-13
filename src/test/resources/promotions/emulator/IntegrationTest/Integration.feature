Feature: Integration Test
@Sanity
  Scenario: Verify Integrated Test for DataPower Savings
    Given Request Sent for ClubId 4969
    When Get XML Response from DataPower EndPoint
    Then Validate with DB2 tables for ItemNumber "7934" and StoreID "4969" and ValueCoupon "722543"
    Then Get XML Response
	
	
	 | Expected 				  | Values																												|
   | Offer Description  | OFFER 18																											|
   | GS1Code            | 0040980099526																									|
   | Offer Id 				  | 76466																													|
   | Gtin            		| 980099526																											|
  
  @Sanity
  Scenario: Verify Integrated Test for Emulator Savings
    Given XML Request Conversion JSON
    When Request Sent for ClubId 4702
    Then Get JSON Response QuickSilver
    Then Validate with CosmosDB with generated OrderID
    Then Convert Response from JSON into XML
    Then Get the XML Response
	
	
	 | Expected 				  | Values																												|
   | Offer Description  | Spend $25 on San Pellegrino and save $10 off									|
   | GS1Code            | 1111																													|
   | Offer Id 				  | b34153e6-c76a-4962-aa8f-0c5673b9868d													|
   | Gtin            		|  	0																														|
  