Feature: Verify Refund

  Scenario Outline: Refund lookup
    Given Refund LookUp Request with <OrderId>,<code>,<Channel>,<BasketId>,<BusinessUnit>,<terminalID>,<lineNumber>

    # add negative tests for membership length of 16,17
    Examples: 
      | OrderId                      | code | Channel | BasketId | BusinessUnit | terminalID | lineNumber |
      | 1020428044889154035627920247 |    2 | POS     |      123 |          788 |      32432 |          2 |
