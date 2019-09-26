package com.bdqn.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * ClassName: StringUtil
 * create by:  xyf
 * description: TODO 字符串工具类
 * create time: 2019/9/13 0013 下午 8:47
 */
public class StringUtil {

    /**
     * description: TODO 比较两个字符串内容
     * create time: 2019/9/13 0013下午 8:51
     *
     * @ param [str1, str2]
     * @ return boolean
     */
    public static boolean equalsStr(String str1, String str2) {
        if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)) {
            return true;
        }
        if (!StringUtils.isEmpty(str1) && str1.equals(str2)) {
            return true;
        }
        return false;
    }
}
