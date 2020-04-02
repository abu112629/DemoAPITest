Feature: Verify Analytic Promotions in the MetaData for Active Members with Single and Double Order Lines

  #mvn test -Denv=stage -Dcucumber.options="--tags @Primaryactiveregression"
  @regressionAnalytic
  Scenario Outline: QuickSilver Promos for Analytic Regular Mix and Match Double Order Lines for Promo Items with ACTIVE <type> <membership> <Tier> Member
    Given DataPower with a <membership>, <type>, <Tier>, and <Channel> with <ClubId> for InstantSavings and <ClubId2> for QuickSilver with Code <ChannelCode> and Price <RetailPrice> and Single OrderLine <OrderLines>, Second Order Line <SecondOrderLine> in <Applied_Dates> with Registration Number <RegistrationNumber> and TransactionId <TransactionId> to be Utilised to Get Analytic Offer

    # add negative tests for membership length of 16,17
    Examples: 
     	| membership | type                | Tier | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | SecondOrderLine | Applied_Dates | ClubId2 | RegistrationNumber | TransactionId |
      | business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     |               2 | LAST_DATE     |    4702 |               4273 |           131 |
 
  @regressionAnalytic
  Scenario Outline: QuickSilver Promos for Analytic Regular Mix and Match Single Order Lines for Promo Items with ACTIVE <type> <membership> <Tier> Member
    Given DataPower with a <membership>,<type>,<Tier>, and <Channel> with <ClubId> for InstantSavings and <ClubId2> for QuickSilver with code <ChannelCode> and Price <RetailPrice> and Single OrderLine <OrderLines> in <Applied_Dates> with Registration Number <RegistrationNumber> and TransactionId <TransactionId> to be Utilised to Get Analytic Offer

    Examples: 
      | membership | type                | Tier | ChannelCode | RetailPrice | ClubId | OrderLines | Channel | Applied_Dates | ClubId2 | RegistrationNumber | TransactionId |
     	| business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           1 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           2 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           3 | SAME_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           1 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           2 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           3 | MORE_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           1 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           2 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |
      | business   | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4226 |            83 |
      | business   | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4227 |            84 |
      | business   | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4228 |            85 |
      | business   | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4229 |            86 |
      | business   | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4230 |            87 |
      | business   | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4231 |            88 |
      | business   | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4232 |            89 |
      | business   | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4233 |            90 |
      | business   | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4234 |            91 |
      | business   | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4235 |            92 |
      | business   | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4236 |            93 |
      | business   | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4237 |            94 |
      | business   | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4238 |            95 |
      | business   | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4239 |            96 |
      | business   | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4240 |            97 |
      | business   | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4241 |            98 |
      | business   | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4242 |            99 |
      | business   | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4243 |           101 |
      | business   | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4244 |           102 |
      | business   | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4245 |           103 |
      | business   | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4246 |           104 |
      | business   | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4247 |           105 |
      | business   | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4248 |           106 |
      | business   | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4249 |           107 |
      | savings    | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4250 |           108 |
      | savings    | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4251 |           109 |
      | savings    | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4252 |           110 |
      | savings    | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4253 |           111 |
      | savings    | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4254 |           112 |
      | savings    | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4255 |           113 |
      | savings    | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4256 |           114 |
      | savings    | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | FIRST_DATE    |    4702 |               4257 |           115 |
      | savings    | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4258 |           116 |
      | savings    | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4259 |           117 |
      | savings    | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4260 |           118 |
      | savings    | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4261 |           119 |
      | savings    | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4262 |           120 |
      | savings    | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4263 |           121 |
      | savings    | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4264 |           122 |
      | savings    | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | MIDDLE_DATE   |    4702 |               4265 |           123 |
      | savings    | primary             | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4266 |           124 |
      | savings    | complimentary       | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4267 |           125 |
      | savings    | addon               | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4268 |           126 |
      | savings    | addon complimentary | Club |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4269 |           127 |
      | savings    | primary             | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4270 |           128 |
      | savings    | complimentary       | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4271 |           129 |
      | savings    | addon               | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4272 |           130 |
      | savings    | addon complimentary | Plus |           3 | LESS_PRICE  |   4969 |          1 | POS     | LAST_DATE     |    4702 |               4273 |           131 |