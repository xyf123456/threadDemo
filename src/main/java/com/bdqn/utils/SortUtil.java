package com.bdqn.utils;

import com.bdqn.pojo.CharacterType;
import com.bdqn.pojo.User;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: {@link SortUtil}
 * create by:  xyf
 * description: 排序工具类
 * create time: 2019/10/28 11:20
 */
public class SortUtil {

    private static final Log Logger = LogFactory.getLog(SortUtil.class);
    public static void sortByWhat(List<User> list){
        try{
            CharacterType[] characters = {CharacterType.UNKNOWN,CharacterType.IN ,CharacterType.OUT,CharacterType.BOTH};
            Comparator comparator = new FixedOrderComparator(characters);

            ComparatorChain moInfoComparator = new ComparatorChain();

            moInfoComparator.addComparator(new BeanComparator("character",comparator));
            moInfoComparator.addComparator(new BeanComparator("age"),true);
            moInfoComparator.addComparator(new BeanComparator("name"));
            list.sort(moInfoComparator);
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
    }
}
