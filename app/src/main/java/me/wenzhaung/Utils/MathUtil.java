package me.wenzhaung.Utils;

import java.math.BigDecimal;

/**
 * Created by JohnVenn on 2016/2/20.
 */
public class MathUtil {
    public static double round(double f){
        BigDecimal b   =   new   BigDecimal(f);
        double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
}
