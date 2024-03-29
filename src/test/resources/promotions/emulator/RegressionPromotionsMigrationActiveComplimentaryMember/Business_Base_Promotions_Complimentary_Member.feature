Feature: Verify ACTIVE COMPLIMENTARY BUSINESS Base Member for all Promotions in the MetaData

@Primarycomplimentaryregression
  Scenario Outline: QuickSilver Promos for Regular Mix and Match Single Order Lines for Promo Items in MetaData with ACTIVE BUSINESS COMPLIMENTARY Base Member
    Given Minimum required for DataPower with <Channel>,<ClubId>,<ClubId2> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer for Business Base Complimentary Member
    When Post request to DataPower Endpoint for Business Base Complimentary Member
    When Post request to Emulator Endpoint for Business Base Complimentary Member
    When Request posted to DataPower and get the required discount for Business Base Complimentary Member
    When Request posted to Emulator and get the required discount for Business Base Complimentary Member
    Then Assert required to DataPower and get attributes for Business Base Complimentary Member

    Examples: 
      | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Applied_Dates | ClubId2 |
      |           2 |        3000 |   4969 |          1 | POS     | FIRST_DATE    |    4702 |
      |           2 |        3500 |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |
      |           2 |        3500 |   4969 |          1 | POS     | LAST_DATE     |    4702 |