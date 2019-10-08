package com.bdqn.algorithm;

/**
 * ClassName: {@link ClassicJavaAlgorithm}
 * Description: TODO 经典算法
 * Author: xyf
 * Date 2019/10/8 12:11
 */
public class ClassicJavaAlgorithm {

    /**
     * Description: TODO 递归算法
     * 问法：斐波那契数或者费氏数列（Fibonacci数列）
     * 问法二、有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
     * 问每个月的兔子总数为多少？
     * 1  1  2  3  5  8  13 ......
     * param: [n]
     * return: java.lang.Long
     * Date: 2019/10/8 12:12
     */
    public static Long getNumber(int n) {
        if (n < 0) {
            return -1L;
        } else if (n == 0) {
            return 0L;
        } else if (n == 1 || n == 2) {
            return 1L;
        } else {
            return getNumber(n - 1) + getNumber(n - 2);
        }
    }

    public static Long getFib(int n) {
        return n <= 0 ? -1L : n == 1 || n == 2 ? 1L : getFib(n - 1) + getFib(n - 2);
    }

    /**
     * 测试递归算法与传统循环效率相比
     */
    public static final int MONTH = 40;

    public static void fib_test() {
        Long start = System.currentTimeMillis();
        System.out.println(getFib(MONTH));
        System.out.println("递归耗时：" + (System.currentTimeMillis() - start));
        Long start1 = System.currentTimeMillis();
        long f1 = 1L, f2 = 1L;
        long f;
        for (int i = 3; i <= MONTH; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            //System.out.print("第" + i +"个月的兔子对数: ");
            //System.out.println(" " + f2);
        }
        System.out.println(f2);
        System.out.println("非递归耗时：" + (System.currentTimeMillis() - start1));
    }

    public static void main(String[] args) {
        ClassicJavaAlgorithm.fib_test();
    }
}
