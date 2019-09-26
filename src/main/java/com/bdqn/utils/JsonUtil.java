package com.bdqn.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * ClassName: {@link JsonUtil}
 * Description: TODO Json相关的工具类
 * Author: xyf
 * Date 2019/9/16 9:26
 */
public class JsonUtil {
    private static Logger logger = Logger.getLogger(JsonUtil.class);

    /**
     * description: TODO  JSON 字符串转换成对象
     * create time: 2019/9/14 0014下午 9:30
     *
     * @ param [pojo, tClass]
     * @ return T
     */
    public static <T> T getObject(String pojo, Class<T> tClass) {
        try {
            return JSONObject.parseObject(pojo, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tClass + "转JSON失败");
        }
        return null;
    }

    /**
     * description: TODO  将对象转换成JSON字符串
     * create time: 2019/9/14 0014下午 9:33
     *
     * @ param [t]
     * @ return java.lang.String
     */
    public static <T> String getJson(T t) {
        return JSONObject.toJSONString(t);
    }

    /**
     * description: TODO  List集合转换成JSON字符串
     * create time: 2019/9/14 0014下午 9:35
     *
     * @ param [ts]
     * @ return java.lang.String
     */
    public static <T> String listToJson(List<T> ts) {
        return JSON.toJSONString(ts);
    }

    /**
     * description: TODO  将json字符串转换成List集合
     * create time: 2019/9/14 0014下午 9:45
     * 泛型方法，是在调用方法的时候指明泛型的具体类型 。
     * public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * <T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * <T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * @ param [jsonString, clazz]
     * @ return java.util.List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        return JSONArray.parseArray(jsonString, clazz);
    }
}
