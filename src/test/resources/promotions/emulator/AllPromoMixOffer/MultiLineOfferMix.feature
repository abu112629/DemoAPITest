Feature: Verify Mix & Match MultiLines for Varied Offer Types 

Scenario Outline: QuickSilver Promos for All Promo Offer Types Regular Mix and Match Multi Order Lines for Promo Items with ACTIVE <type> <membership> <Tier> Member
    Given DataPower with a <membership>, <type>, <Tier>, and <Channel> with <ClubId> for InstantSavings and <ClubId2> for QuickSilver with Code <ChannelCode> and Price <RetailPrice> in <Applied_Dates> with Registration Number <RegistrationNumber> and TransactionId <TransactionId> to be Utilised to Get Mixed Offer
	
	
	   Examples: 
      | membership | type                | Tier | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | Applied_Dates | ClubId2 | RegistrationNumber | TransactionId |
			| business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
    