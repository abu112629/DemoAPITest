Feature: Verify All Clubs , ACTIVE PRIMARY Member , MPQ - 2, Unlimited Redemption  - 1$ Off each Off each for Emulator InstantSavings: Buy X get $Y off on X
	
  Scenario Outline: Emulator QuickSilver Promos for Regular Mix and Match Single Order Lines for Promo Item 622780 with ACTIVE PRIMARY Member
    Given Minimum <Quantity> required for Emulator with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for Primary Member
    When Post request to the Emulator Endpoint for Primary Member
    When Request posted to the Emulator and get the required discount for Primary Member
    Then Assert required to the Emulator and get the attributes for Primary Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | Quantity | ItemId | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Offer Description           | GS1Code | Offer Id | Gtin   | Discount | Applied_Dates |
     #|        1 | 622780 |           2 |        3000 |   4969 |          1 | POS     | IS-BV-PROMO-MMB-TEST_192020       | 1111    |   192020 | 119202 |      100 | FIRST_DATE    |
      |        2 | 622780 |           2 |        3500 |   4702 |          1 | POS     | IS-BV-PROMO-MMB-TEST_192020 |    1111 |   192020 | 119202 |      100 | LAST_DATE     |
      |        3 | 622780 |           2 |        4000 |   4702 |          1 | POS     | IS-BV-PROMO-MMB-TEST_192020 |    1111 |   192020 | 119202 |      100 | MIDDLE_DATE   |
      |        4 | 622780 |           2 |        4000 |   4702 |          1 | POS     | IS-BV-PROMO-MMB-TEST_192020 |    1111 |   192020 | 119202 |      200 | FIRST_DATE    |
  
  Scenario Outline: Emulator QuickSilver Promos for Regular Mix and Match Double Order Lines for Promo Item 622780 and 655780 with ACTIVE PRIMARY Member
    Given Minimum <Quantity> required for Emulator with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for Primary Member
    Given Minimum <Quantity2> required for Emulator with Second <ItemId2> and <ClubId> with <RetailPrice> and Second OrderLine <SecondOrderLine> to be Utilised to Get Offer for Primary Member
    When Post request to the Emulator Endpoint for Primary Member
    When Request posted to the Emulator and get the required discount for Primary Member
    Then Assert required to the Emulator and get the attributes for Primary Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | Quantity | ItemId | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | ItemId2 | Quantity2 | Offer Description           | GS1Code | Offer Id | Gtin   | Discount | Applied_Dates |
      #|        1 | 622780 |           2 |        3000 |   4969 |          1 | POS     |               2 |  655780 |         1 | IS-BV-PROMO-MMB-TEST_192020       | 1111|   192020 | 119202 |      200 | FIRST_DATE    |
      |        2 | 622780 |           2 |        3500 |   4702 |          1 | POS     |               2 |  655780 |         2 | IS-BV-PROMO-MMB-TEST_192020 |    1111 |   192020 | 119202 |      200 | LAST_DATE     |
      |        3 | 622780 |           2 |        4000 |   4702 |          1 | POS     |               2 |  655780 |         3 | IS-BV-PROMO-MMB-TEST_192020 |    1111 |   192020 | 119202 |      300 | MIDDLE_DATE   |
      |        4 | 622780 |           2 |        4000 |   4702 |          1 | POS     |               2 |  655780 |         4 | IS-BV-PROMO-MMB-TEST_192020 |    1111 |   192020 | 119202 |      400 | MIDDLE_DATE   |
     