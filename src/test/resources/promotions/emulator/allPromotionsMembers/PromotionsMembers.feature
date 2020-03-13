Feature: Verify All Promotions in the MetaData for Active Members with Double Order Lines

  #mvn test -Denv=stage -Dcucumber.options="--tags @Primaryactiveregression"
  Scenario Outline: QuickSilver Promos for Regular Mix and Match Double Order Lines for Promo Items with ACTIVE <type> <membership> <Tier> Member
    Given DataPower with a <membership>, <type>, <Tier>, and <Channel> with <ClubId> for InstantSavings and <ClubId2> for QuickSilver with Code <ChannelCode> and Price <RetailPrice> and Single OrderLine <OrderLines>, Second Order Line <SecondOrderLine> in <Applied_Dates> to be Utilised to Get Offer
    Given DataPower with Second Item and <ClubId> for InstantSavings, <ClubId2> for QuickSilver with Price <RetailPrice> and Second OrderLine <SecondOrderLine> in <Applied_Dates> to be Utilised to Get Offer

    Examples: 
      | membership | type                | Tier | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | Applied_Dates | ClubId2 |
      | business   | primary             | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | complimentary       | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | addon               | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | addon complimentary | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | primary             | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | complimentary       | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | addon               | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | addon complimentary | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | primary             | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | complimentary       | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | addon               | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | addon complimentary | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | primary             | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | complimentary       | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | addon               | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | savings    | addon complimentary | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |
      | business   | primary             | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | complimentary       | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | addon               | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | addon complimentary | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | primary             | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | complimentary       | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | addon               | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | addon complimentary | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | primary             | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | complimentary       | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | addon               | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | addon complimentary | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | primary             | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | complimentary       | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | addon               | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | savings    | addon complimentary | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |
      | business   | primary             | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | business   | complimentary       | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | business   | addon               | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | business   | addon complimentary | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | primary             | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | complimentary       | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | addon               | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | addon complimentary | Club |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | business   | primary             | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | business   | complimentary       | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | business   | addon               | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | business   | addon complimentary | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | primary             | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | complimentary       | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | addon               | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
      | savings    | addon complimentary | Plus |           2 |        3000 |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |
