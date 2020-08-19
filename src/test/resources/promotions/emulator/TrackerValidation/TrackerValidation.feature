Feature: Verify Tracker Data

  Scenario Outline: Verify Member Tracker Values
    Given Validate Member Tracker Data with <MemberShipNumber>,<CardHolderNum>,<Promotion> and <Redemption Left>

    Examples: 
      | MemberShipNumber | CardHolderNum | Promotion | Redemption Left |
      |               41 |             0 |     88965 |               2 |
     