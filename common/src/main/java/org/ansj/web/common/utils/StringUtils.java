package org.ansj.web.common.utils;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static String trimToEmpty(Object obj) {
        if (null == obj) {
            return "";
        }
        return trimToEmpty(obj.toString());
    }
}
