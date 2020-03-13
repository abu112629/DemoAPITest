Feature: Verify Promo Creation

  @Sanity
  Scenario Outline: Verify Response is displayed in json
    Given Utilize URL and post data
      | Condition String   | eligibility Condition   | PromoName   | AwardValue   | Discount limit   | Promotion ItemNumber   |
      | <Condition String> | <eligibility Condition> | <PromoName> | <AwardValue> | <Discount limit> | <Promotion ItemNumber> |
    When POST the provided request
    Then Response code

    Examples: 
      | Condition String                            | eligibility Condition    | PromoName            | AwardValue | Discount limit | Promotion ItemNumber |
      | mCount(itemNumber in ("788978"), ">=", "2") | itemNumber in ("788978") | IS-BV-PROMO-MMB-TEST |          5 |              2 |               119202 |
     