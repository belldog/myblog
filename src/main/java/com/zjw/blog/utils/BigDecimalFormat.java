
package com.zjw.blog.utils;

import java.math.BigDecimal;

/**
 * @author zhangjinwei
 *         BigDecimal.setScale()方法用于格式化小数点
 *         setScale(1)表示保留一位小数，默认用四舍五入方式
 *         setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3
 *         setScale(1,BigDecimal.ROUND_UP)进位处理，2.35变成2.4
 *         setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
 *         setScaler(1,BigDecimal.ROUND_HALF_DOWN)四舍五入，2.35变成2.3，如果是5则向下舍
 */
public final class BigDecimalFormat {
    /**
     * 保留两位小数，直接删除后面的位数，例如2.356，会变成2.35
     *
     * @param money
     * @return
     */
    public static BigDecimal money(BigDecimal money) {
        return money.setScale(2, BigDecimal.ROUND_DOWN);
    }
}
