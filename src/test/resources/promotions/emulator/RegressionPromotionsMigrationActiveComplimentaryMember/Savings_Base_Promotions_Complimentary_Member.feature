Feature: Verify ACTIVE COMPLIMENTARY SAVINGS Base Member for all Promotions in the MetaData

@Primarycomplimentaryregression
  Scenario Outline: QuickSilver Promos for Regular Mix and Match Single Order Lines for Promo Items in MetaData with ACTIVE SAVINGS COMPLIMENTARY Base Member
    Given Minimum required for DataPower with <Channel>,<ClubId>,<ClubId2> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer for Complimentary Member
    When Post request to DataPower Endpoint for Complimentary Savings Member
    When Post request to Emulator Endpoint for Complimentary Savings Member
    When Request posted to DataPower and get the required discount for Complimentary Savings Member
    When Request posted to Emulator and get the required discount for Complimentary Savings Member
    Then Assert required to DataPower and get attributes for Complimentary Savings Member

    Examples: 
      | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Applied_Dates | ClubId2 |
      |           2 |        3000 |   4969 |          1 | POS     | FIRST_DATE    |    4702 |
      |           2 |        3500 |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |
      |           2 |        3500 |   4969 |          1 | POS     | LAST_DATE     |    4702 |