Feature: Verify Verify All Clubs , ACTIVE ADD_ON Member , MPQ - 1, Unlimited Redemption,2$ Off each for Emulator Mercury: Buy X get $Y off on X

  Scenario Outline: Emulator QuickSilver Promos for Regular Mix and Match Single Order Lines for Promo Item 622943 with ACTIVE ADD_ON Member
    Given Minimum <Quantity> required for Emulator with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for AddOn Member
    When Post request to Emulator Endpoint for AddOn Member
    When Request posted to Emulator and get the required discount for AddOn Member
    Then Assert required to Emulator and get attributes for AddOn Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | Quantity | ItemId | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Offer Description                         | GS1Code | Offer Id | Gtin   | Discount | Applied_Dates |
      |        1 | 622943 |           1 |        3000 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           1 |        3500 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           1 |        4000 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           2 |        3000 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           2 |        3500 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           2 |        4000 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           3 |        3000 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           3 |        3500 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           3 |        4000 |   4702 |          1 | POS     | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           1 |        3000 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           1 |        3500 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           1 |        4000 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           2 |        3000 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           2 |        3500 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           2 |        4000 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           3 |        3000 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           3 |        3500 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           3 |        4000 |   4702 |          1 | MWEB    | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           1 |        3000 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           1 |        3500 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           1 |        4000 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           2 |        3000 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           2 |        3500 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           2 |        4000 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |
      |        1 | 622943 |           3 |        3000 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      200 | FIRST_DATE    |
      |        2 | 622943 |           3 |        3500 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | LAST_DATE     |
      |        3 | 622943 |           3 |        4000 |   4702 |          1 | DOTCOM  | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      600 | MIDDLE_DATE   |

  Scenario Outline: Emulator QuickSilver Promos for Regular Mix and Match Double Order Lines for Promo Item 622943 and 984102  with ACTIVE ADD_ON Member
    Given Minimum <Quantity> required for Emulator with <Channel>,<ItemId>,<ClubId> and <ChannelCode> with <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> to be Utilised to Get Offer <Offer Id> for AddOn Member
    Given Minimum <Quantity2> required for Emulator with Second <ItemId2> and <ClubId> with <RetailPrice> and Second OrderLine <SecondOrderLine> to be Utilised to Get Offer for AddOn Member
    When Post request to Emulator Endpoint for AddOn Member
    When Request posted to Emulator and get the required discount for AddOn Member
    Then Assert required to Emulator and get attributes for AddOn Member
      | Offer Description   | GS1Code   | Offer Id   | Gtin   | Discount   |
      | <Offer Description> | <GS1Code> | <Offer Id> | <Gtin> | <Discount> |

    Examples: 
      | Quantity | ItemId | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | ItemId2 | Quantity2 | Offer Description                         | GS1Code | Offer Id | Gtin   | Discount | Applied_Dates |
      |        1 | 622943 |           1 |        3000 |   4702 |          1 | POS     |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           1 |        3500 |   4702 |          1 | POS     |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           1 |        4000 |   4702 |          1 | POS     |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           2 |        3000 |   4702 |          1 | POS     |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           2 |        3500 |   4702 |          1 | POS     |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           2 |        4000 |   4702 |          1 | POS     |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           3 |        3000 |   4702 |          1 | POS     |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           3 |        3500 |   4702 |          1 | POS     |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           3 |        4000 |   4702 |          1 | POS     |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           1 |        3000 |   4702 |          1 | MWEB    |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           1 |        3500 |   4702 |          1 | MWEB    |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           1 |        4000 |   4702 |          1 | MWEB    |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           2 |        3000 |   4702 |          1 | MWEB    |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           2 |        3500 |   4702 |          1 | MWEB    |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           2 |        4000 |   4702 |          1 | MWEB    |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           3 |        3000 |   4702 |          1 | MWEB    |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           3 |        3500 |   4702 |          1 | MWEB    |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           3 |        4000 |   4702 |          1 | MWEB    |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           1 |        3000 |   4702 |          1 | DOTCOM  |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           1 |        3500 |   4702 |          1 | DOTCOM  |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           1 |        4000 |   4702 |          1 | DOTCOM  |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           2 |        3000 |   4702 |          1 | DOTCOM  |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           2 |        3500 |   4702 |          1 | DOTCOM  |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           2 |        4000 |   4702 |          1 | DOTCOM  |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
      |        1 | 622943 |           3 |        3000 |   4702 |          1 | DOTCOM  |               2 |  984102 |         1 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      400 | FIRST_DATE    |
      |        2 | 622943 |           3 |        3500 |   4702 |          1 | DOTCOM  |               2 |  984102 |         2 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |      800 | LAST_DATE     |
      |        3 | 622943 |           3 |        4000 |   4702 |          1 | DOTCOM  |               2 |  984102 |         3 | BR_Promo_ALl_Club_All_Members_Test1_26293 |    1111 |    26293 | 779240 |     1200 | MIDDLE_DATE   |
