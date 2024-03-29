Feature: Verify Trigger Promotions in the MetaData for Active Members with Single and Double Order Lines

  #mvn test -Denv=stage -Dcucumber.options="--tags @Primaryactiveregression"
  @regressionTrigger
  Scenario Outline: QuickSilver Promos for Trigger Regular Mix and Match Double Order Lines for Promo Items with ACTIVE <type> <membership> <Tier> Member
    Given DataPower with a <membership>, <type>, <Tier>, and <Channel> with <ClubId> for InstantSavings and <ClubId2> for QuickSilver with Code <ChannelCode> and Price <RetailPrice> and Single OrderLine <OrderLines>, Second Order Line <SecondOrderLine> in <Applied_Dates> with Registration Number <RegistrationNumber> and TransactionId <TransactionId> to be Utilised to Get Trigger Offer

    # add negative tests for membership length of 16,17
     Examples: 
      | membership | type                | Tier | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | Applied_Dates | ClubId2 | RegistrationNumber | TransactionId |
			| business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
    
      
 
  @regressionTrigger
  Scenario Outline: QuickSilver Promos for Trigger Regular Mix and Match Single Order Lines for Promo Items with ACTIVE <type> <membership> <Tier> Member
    Given DataPower with a <membership>,<type>,<Tier>, and <Channel> with <ClubId> for InstantSavings and <ClubId2> for QuickSilver with code <ChannelCode> and Price <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> with Registration Number <RegistrationNumber> and TransactionId <TransactionId> to be Utilised to Get Trigger Offer

    Examples: 
      | membership | type                | Tier | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Applied_Dates | ClubId2 | RegistrationNumber | TransactionId |
	  	| business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
     