Feature: End to End Promotion Test for All Services

  Scenario: Validate Promo Creation and Migration for all Services and also Redemption of the same promotions
    Given Validate Promo document for ISPROMO number in Cosmos
    Given Validate values are updated for Promo Id in DB
    When Compare values for both DBs
    When Send a request to Instant Savings Cert and InstantSavings Legacy
    Then Compare both the responses
    Then Validate Reserve DB in Cosmos for Instant Savings Cert
    Then Validate CPN_TXN Table for Instant Savings Cert and InstantSavings Legacy
