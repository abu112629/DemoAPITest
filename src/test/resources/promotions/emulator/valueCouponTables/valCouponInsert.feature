Feature: Update Value Coupon , Value Coupon Store and Value Coupon Items Table in DB2

  Scenario Outline: Update Tables
    Given Values to Update value coupon Table
      | VALUE_COUPON_NBR   | BASE_DIV_NBR   | START_DATE   | END_DATE   | START_TIME   | END_TIME   | ACTIVE_IND   | COUPON_ITEM_NBR   | COUPON_UPC_NBR   | VALUE_AMT   | VALUE_PCT   | PACKAGE_CODE   | INVESTMENT_AMT   | INVESTMENT_CNT   | DURATION_CODE   | VENDOR_FUNDED_IND   | SHARED_VALUE_IND   | PRVDR_COUPON_NBR   | MANUAL_LOAD_IND   | VAL_OFFER_TYP_CODE   | MAX_RDMPT_CNT   | MIN_BASKET_AMT   | VAL_ASSIGN_TYPE_CD   | LAST_CHANGE_DATE   | LAST_CHG_PGM_ID   | CAMPAIGN_NBR   | PURCH_FREQUENCY_PCT   | FUNDING_TYPE_CD   | SUMMARY_DESC   | DETAIL_DESC   | RETAIL_AFTER_DISC_IND   | MAX_PURCHASE_AMT   | MAX_PURCHASE_QTY   | MAX_DISC_AMT   | MIN_CORE_PURCH_QTY   | MIN_SEED_PURCH_QTY   | MIN_REWARD_PURCH_QTY   | OFFER_AVAIL_DELAY_DAY_CNT   | OFFER_DUR_DELAY_DAY_CNT   | ASSGN_INVST_CNT   | REDEMPTION_INVST_CNT   |
      | <VALUE_COUPON_NBR> | <BASE_DIV_NBR> | <START_DATE> | <END_DATE> | <START_TIME> | <END_TIME> | <ACTIVE_IND> | <COUPON_ITEM_NBR> | <COUPON_UPC_NBR> | <VALUE_AMT> | <VALUE_PCT> | <PACKAGE_CODE> | <INVESTMENT_AMT> | <INVESTMENT_CNT> | <DURATION_CODE> | <VENDOR_FUNDED_IND> | <SHARED_VALUE_IND> | <PRVDR_COUPON_NBR> | <MANUAL_LOAD_IND> | <VAL_OFFER_TYP_CODE> | <MAX_RDMPT_CNT> | <MIN_BASKET_AMT> | <VAL_ASSIGN_TYPE_CD> | <LAST_CHANGE_DATE> | <LAST_CHG_PGM_ID> | <CAMPAIGN_NBR> | <PURCH_FREQUENCY_PCT> | <FUNDING_TYPE_CD> | <SUMMARY_DESC> | <DETAIL_DESC> | <RETAIL_AFTER_DISC_IND> | <MAX_PURCHASE_AMT> | <MAX_PURCHASE_QTY> | <MAX_DISC_AMT> | <MIN_CORE_PURCH_QTY> | <MIN_SEED_PURCH_QTY> | <MIN_REWARD_PURCH_QTY> | <OFFER_AVAIL_DELAY_DAY_CNT> | <OFFER_DUR_DELAY_DAY_CNT> | <ASSGN_INVST_CNT> | <REDEMPTION_INVST_CNT> |
    Then Values to Update value coupon Items
      | VALUE_COUPON_NBR   | ITEM_NBR   | VAL_ITEM_TYPE_CODE   | DEPT_NBR   | SUBCLASS_NBR   | VENDOR_NBR   | MIN_ITEM_PURCH_QTY   |
      | <VALUE_COUPON_NBR> | <ITEM_NBR> | <VAL_ITEM_TYPE_CODE> | <DEPT_NBR> | <SUBCLASS_NBR> | <VENDOR_NBR> | <MIN_ITEM_PURCH_QTY> |
    Then Values to Update value coupon Store
      | VALUE_COUPON_NBR   | STORE_NBR   | START_DATE   | END_DATE   | START_TIME   | END_TIME   |
      | <VALUE_COUPON_NBR> | <STORE_NBR> | <START_DATE> | <END_DATE> | <START_TIME> | <END_TIME> |

    Examples: 
      | VALUE_COUPON_NBR | BASE_DIV_NBR | START_DATE | END_DATE   | START_TIME | END_TIME | ACTIVE_IND | COUPON_ITEM_NBR | COUPON_UPC_NBR | VALUE_AMT | VALUE_PCT | PACKAGE_CODE | INVESTMENT_AMT | INVESTMENT_CNT | DURATION_CODE | VENDOR_FUNDED_IND | SHARED_VALUE_IND | PRVDR_COUPON_NBR | MANUAL_LOAD_IND | VAL_OFFER_TYP_CODE | MAX_RDMPT_CNT | MIN_BASKET_AMT | VAL_ASSIGN_TYPE_CD | LAST_CHANGE_DATE | LAST_CHG_PGM_ID | CAMPAIGN_NBR | PURCH_FREQUENCY_PCT | FUNDING_TYPE_CD | SUMMARY_DESC | DETAIL_DESC              | RETAIL_AFTER_DISC_IND | MAX_PURCHASE_AMT | MAX_PURCHASE_QTY | MAX_DISC_AMT | MIN_CORE_PURCH_QTY | MIN_SEED_PURCH_QTY | MIN_REWARD_PURCH_QTY | OFFER_AVAIL_DELAY_DAY_CNT | OFFER_DUR_DELAY_DAY_CNT | ASSGN_INVST_CNT | REDEMPTION_INVST_CNT | ITEM_NBR  | VAL_ITEM_TYPE_CODE | DEPT_NBR | SUBCLASS_NBR | VENDOR_NBR | MIN_ITEM_PURCH_QTY | STORE_NBR |
      |            87031 |           18 | 2020-02-03 | 2020-03-28 | 00:00:00   | 23:59:00 | A          |       980256551 |    40980256551 |      2.98 |         0 |           96 |              0 |              0 |             0 | N                 | Y                |                0 | Y               |                 22 |          9999 |              0 |                  4 | 2019-01-25       | RVSYNC          |         3556 |                   0 |               1 | IS M&M $Dis  | IS $ SQUISITO PIZZA & PA |                     0 |                0 |                0 |            0 |                  9 |                  0 |                    0 |                         0 |                       0 |               0 |                    0 | 980013824 |                  1 |        0 |            0 |          0 |                  1 |      4969 |
