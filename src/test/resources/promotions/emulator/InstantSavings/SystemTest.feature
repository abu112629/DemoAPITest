Feature: Verify Forward Sync and Reverse Sync Validations End to End

  @smoke
  Scenario Outline: Verify Database Validations for Legacy and Azure Systems
    Given Request Sent for the ClubId with <Request>
    When POST the provided request to InstantSavings
    Then Create Input parameters for Database Validations
    Then Validate VALUE_CPN_TXN_TEMP and Cosmos DB
    Then Assert and compare the values of both Database

    Examples: 
      | Request                            |
      | BroadReach Dollar Off Request Type |
      | BroadReach Seed and Reward         |
      | Package Coupon Dollar off          |
      | Package Coupon Percentage Off      |
      | Package and BroadReach             |
