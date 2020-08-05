Feature: Verify Forward Sync and Reverse Sync Validations End to End
@smoke
  Scenario: Verify Database Validations for Legacy and Azure Systems
  
    Given Request Sent for the ClubId
    When POST the provided request to InstantSavings
    Then Create Input parameters for Database Validations
    Then Validate VALUE_CPN_TXN_TEMP and Cosmos DB
    Then Assert and compare the values of both Database
  

     
