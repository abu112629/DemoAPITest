Feature: Verify All Clubs , ACTIVE PRIMARY Member , MPQ - 1, Unlimited Redemption 2$ Off each for DataPower InstantSavings: Buy X get $Y off on X

  Scenario Outline: DataPower QuickSilver Promos for Regular Mix and Match Single Order Lines for Promo Item 622943 with ACTIVE PRIMARY Member
    Given <membership>, <type>, <Tier> member and Quantity <Quantity> for DataPower with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for Primary Member
    When Post request to the DataPower Endpoint for Primary Member
    When Post request to the Emulator Endpoint for Primary Member
    When Request posted to the DataPower and get the required discount for Primary Member
    When Request posted to the Emulator and get the required discount for Primary Member
    Then Assert required to the DataPower and get the attributes for Primary Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | membership | type    | Tier | Quantity | ItemId    | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Offer Description | GS1Code       | Offer Id | Gtin   | Discount | Applied_Dates |
      | business   | primary | Club |        1 | 980143632 |           2 |        3000 |   4969 |          1 | POS     | IS Item$Dis       | 0000000001111 |    84179 | 779240 |      200 | FIRST_DATE    |

  Scenario Outline: DataPower QuickSilver Promos for Regular Mix and Match Double Order Lines for Promo Item 622943 and 984102 with ACTIVE PRIMARY Member
    Given <membership>, <type>, <Tier> member and Quantity <Quantity> for DataPower with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for Primary Member
    Given Minimum <Quantity2> required for DataPower with Second <ItemId2> and <ClubId> with <RetailPrice> and Second OrderLine <SecondOrderLine> to be Utilised to Get Offer for Primary Member
    When Post request to the DataPower Endpoint for Primary Member
    When Post request to the Emulator Endpoint for Primary Member
    When Request posted to the DataPower and get the required discount for Primary Member
    When Request posted to the Emulator and get the required discount for Primary Member
    Then Assert required to the DataPower and get the attributes for Primary Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | membership | type    | Tier | Quantity | ItemId    | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | ItemId2   | Quantity2 | Offer Description | GS1Code       | Offer Id | Gtin   | Discount | Applied_Dates |  
      | business   | primary | Club |        1 | 980143632 |           2 |        3000 |   4969 |          1 | POS     |               2 | 980071770 |         1 | IS Item$Dis       | 0000000001111 |    84179 | 779240 |      400 | FIRST_DATE    |
