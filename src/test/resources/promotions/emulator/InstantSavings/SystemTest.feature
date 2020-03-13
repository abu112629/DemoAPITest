Feature: Verify System Integration End to End Test for All Services for Emulator and DataPower

  Scenario: Verify Response is displayed for ClubID4969
    Given Request Sent for the ClubId 4969
    When POST the provided request to InstantSavings
    Then Validate with DB2 VAL_CPN_ITEM table for ISPromo
    Then Validate with VALUE_CPN_TXN_TMP DB2 tables if row inserted for CheckOutResponse 4969
    Then Assert and compare the values for ClubId 4969
      | Expected          | Values        |
      | Offer Description | IS M&M $Dis   |
      | GS1Code           | 0040980129920 |
      | Offer Id          |         77080 |
      | Gtin              |     980129920 |

  Scenario: Verify Response is displayed for ClubID4702
    Given Request Sent for the ClubId 4702
    When POST the provided request for Emulator
    Then Validate with DB2 VAL_CPN_ITEM table for UUID
    Then Validate with CosmosDB with the generated OrderID
    Then Validate with VALUE_CPN_TXN_TMP DB2 tables if row inserted for CheckOutResponse 4702
    Then Assert and compare the values for ClubId 4702
     	#| Expected          | Values                        |
      #| Offer Description | test2020xxxnewItemNumberPromo |
      #| GS1Code           |                          1111 |
      #| Offer Id          |                         77080 |
      #| Gtin              |                             0 |
    Then POST Redeem Request after reserve
     
