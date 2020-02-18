Feature: Verify All Clubs , ACTIVE PRIMARY Member , MPQ - 1, Unlimited Redemption 2$ Off each for DataPower InstantSavings: Buy X get $Y off on X

  Scenario Outline: DataPower QuickSilver Promos for Regular Mix and Match Single Order Lines for Promo Item 622943 with ACTIVE PRIMARY Member
    Given Minimum <Quantity> required for DataPower with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for Primary Member
    When Post request to DataPower Endpoint for Primary Member
    When Request posted to DataPower and get the required discount for Primary Member
    Then Assert required to DataPower and get attributes for Primary Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | Quantity | ItemId | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Offer Description | GS1Code       | Offer Id | Gtin   | Discount | Applied_Dates |
      |        1 | 622943 |           2 |        3000 |   4969 |          1 | POS     | IS Item$Dis       | 0000000001111 |    26293 | 779240 |      200 | FIRST_DATE    |
     

  Scenario Outline: DataPower QuickSilver Promos for Regular Mix and Match Double Order Lines for Promo Item 622943 and 984102 with ACTIVE PRIMARY Member
    Given Minimum <Quantity> required for DataPower with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for Primary Member
    Given Minimum <Quantity2> required for DataPower with Second <ItemId2> and <ClubId> with <RetailPrice> and Second OrderLine <SecondOrderLine> to be Utilised to Get Offer for Primary Member
    When Post request to DataPower Endpoint for Primary Member
    When Request posted to DataPower and get the required discount for Primary Member
    Then Assert required to DataPower and get attributes for Primary Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | Quantity | ItemId | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | ItemId2 | Quantity2 | Offer Description | GS1Code       | Offer Id | Gtin   | Discount | Applied_Dates |
      |        1 | 622943 |           2 |        3000 |   4969 |          1 | POS     |               2 |  984102 |         1 | IS Item$Dis       | 0000000001111 |    26293 | 779240 |      400 | FIRST_DATE    |
     