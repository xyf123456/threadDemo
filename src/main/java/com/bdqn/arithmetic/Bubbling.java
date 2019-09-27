package com.bdqn.arithmetic;

/**
 * ClassName: Bubbling
 * create by:  xyf
 * description: TODO 冒泡排序 N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次
 * 要排序数组:[10,1,35,61,89,36,55]
 * (1)第一趟排序：
 * <p>
 * 　　　　　　第一次排序：10和1比较，10大于1，交换位置 　　 　  [1,10,35,61,89,36,55]
 * <p>
 * 　　　　　　第二趟排序：10和35比较，10小于35，不交换位置　　[1,10,35,61,89,36,55]
 * <p>
 * 　　　　　　第三趟排序：35和61比较，35小于61，不交换位置　　[1,10,35,61,89,36,55]
 * <p>
 * 　　　　　　第四趟排序：61和89比较，61小于89，不交换位置　　[1,10,35,61,89,36,55]
 * <p>
 * 　　　　　  第五趟排序：89和36比较，89大于36，交换位置　　　[1,10,35,61,36,89,55]
 * <p>
 * 　　　　　　第六趟排序：89和55比较，89大于55，交换位置　　　[1,10,35,61,36,55,89]
 * <p>
 * 　　　　　　第一趟总共进行了六次比较，排序结果：[1,10,35,61,36,55,89]
 * <p>
 * 　(2)第二趟排序：
 * <p>
 * 　　　　　　第一次排序：1和10比较，1小于10，不交换位置　　1,10,35,61,36,55,89
 * <p>
 * 　　　　　　第二次排序：10和35比较，10小于35，不交换位置    1,10,35,61,36,55,89
 * <p>
 * 　　　　　　第三次排序：35和61比较，35小于61，不交换位置     1,10,35,61,36,55,89
 * <p>
 * 　　　　　　第四次排序：61和36比较，61大于36，交换位置　　　1,10,35,36,61,55,89
 * <p>
 * 　　　　　　第五次排序：61和55比较，61大于55，交换位置　　　1,10,35,36,55,61,89
 * <p>
 * 　　　　　　第二趟总共进行了5次比较，排序结果：1,10,35,36,55,61,89
 * (3)第三趟排序：
 * <p>
 * 　　　　　　1和10比较，1小于10，不交换位置　　1,10,35,36,55,61,89
 * <p>
 * 　　　　　　第二次排序：10和35比较，10小于35，不交换位置    1,10,35,36,55,61,89
 * <p>
 * 　　　　　　第三次排序：35和36比较，35小于36，不交换位置     1,10,35,36,55,61,89
 * <p>
 * 　　　　　　第四次排序：36和61比较，36小于61，不交换位置　　　1,10,35,36,55,61,89
 * <p>
 * 　　　　　　第三趟总共进行了4次比较，排序结果：1,10,35,36,55,61,89
 * create time: 2019/9/26 22:10
 */
public class Bubbling {

    /**
     * description: TODO 排序的写法
     * create time: 2019/9/26 22:15
     * [arr]
     *
     * @return void
     */
    public static void bubbleSort(int[] arr) {

        //一定要记住判断边界条件，很多人不注意这些细节，面试官看到你的代码的时候都懒得往下看，你的代码哪个项目敢往里面加
        if (arr == null || arr.length < 2) {
            return;
        }
        //需要进行arr.length趟比较
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;//每一趟交换元素的标识
            //第i趟比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag==0){//如果没有交换过元素，则已经有序，则跳出for循环
                break;
            }

        }
        System.out.println("最终得出的数组为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 35, 61, 89, 36, 55};
        int[] arr1 = {1, 10, 35, 36, 55, 61, 89};
        Bubbling.bubbleSort(arr);
    }
}


