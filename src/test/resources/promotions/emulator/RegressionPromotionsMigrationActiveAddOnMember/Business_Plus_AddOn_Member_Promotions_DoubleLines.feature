Feature: Verify ACTIVE ADDON BUSINESS Plus Member Double Lines for all Promotions in the MetaData

 @PrimaryAddOnregression
  Scenario Outline: QuickSilver Promos for Regular Mix and Match Double Order Lines for Promo Items with ACTIVE PRIMARY Business Plus ADDON Member
    Given DataPower with <Channel>,<ClubId>,<ClubId2> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> and Double Order Line <SecondOrderLine> in <Applied_Dates> to be Utilised to Get Offer for Business Plus AddOn Member
    Given DataPower with Second Item and <ClubId>,<ClubId2> with <RetailPrice> and Second OrderLine <SecondOrderLine> in <Applied_Dates> to be Utilised to Get Offer for Business Plus AddOn Member
    When DataPower Endpoint POST request for Business Plus AddOn Member
    When Post the request to Emulator Endpoint for Business Plus AddOn Member
    When Response for DataPower and get the required discount for Business Plus AddOn Member
    When Response for Emulator and get the required discount for Business Plus AddOn Member
    Then Assert on DataPower request and get attributes for Business Plus AddOn Member

    Examples: 
      | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | Applied_Dates | ClubId2 |
      |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      |           2 |        3500 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      |           2 |        3500 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
