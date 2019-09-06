package com.tieshan.api.util.toolUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Thousand {

    /**元转万元且保留两位小数并四舍五入*/
     public static String getNumberWanTwo(BigDecimal bigDecimal) {
         // 转换为万元（除以10000）
         BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000")).setScale(2,BigDecimal.ROUND_HALF_UP);
         String money=decimal.toString();
         return money;
    }
}
