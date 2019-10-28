package com.bdqn.pojo;

import com.bdqn.utils.SortUtil;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UserTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * description: 第三方比较工具的使用
     * create time: 2019/10/28 10:37
     * $params []
     * $return void
     */
    @Test
    public void testComparatorUtils() {
        User user1 = new User("张三", 23);
        User user2 = new User("李四", 54);
        User user3 = new User("王五", 12);
        User user4 = new User("许六", 33);
        List<User> userList = Arrays.asList(user1, user2, user3, user4);
        System.out.println("未排序前:");
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
        Comparator comparator = ComparableComparator.getInstance();
        comparator = ComparatorUtils.nullLowComparator(comparator);//允许null
        comparator = ComparatorUtils.reversedComparator(comparator);//逆序
        ArrayList<Object> sortFields = new ArrayList<>();
        sortFields.add(new BeanComparator<>("age", comparator));
//        sortFields.add(new BeanComparator<>("name"));
        ComparatorChain comparatorChain = new ComparatorChain(sortFields);
        userList.sort(comparatorChain);
        System.out.println("排序后");
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }

    /**
     * description: 第三方比较工具的使用
     * create time: 2019/10/28 10:37
     * $params []
     * $return void
     */
    @Test
    public void testComparatorUtils1() {
        User user1 = new User("张三", 23,CharacterType.IN);
        User user2 = new User("李四", 54,CharacterType.OUT);
        User user3 = new User("王五", 12,CharacterType.UNKNOWN);
        User user4 = new User("许六", 33,CharacterType.UNKNOWN);
        User user5 = new User("张五", 34,CharacterType.IN);
        List<User> userList = Arrays.asList(user1, user2, user3, user4,user5);
        System.out.println("未排序前:");
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
        SortUtil.sortByWhat(userList);
        System.out.println("排序后:");
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }
}