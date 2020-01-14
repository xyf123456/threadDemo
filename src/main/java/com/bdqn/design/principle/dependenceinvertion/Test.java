package com.bdqn.design.principle.dependenceinvertion;

/**
 * ClassName: Test
 * create by:  xyf
 * description: 依赖倒置原则的测试类
 * create time: 2020/1/14 11:58
 */
public class Test {
   /* v1
    public static void main(String[] args) {
        Jack jack = new Jack();
        jack.studyJava();
        jack.studyPhp();
        jack.studyPython();
    }*/

/*//   v2
    public static void main(String[] args) {
       Jack jack = new Jack();
       jack.studyCourse(new JavaCourse());
       jack.studyCourse(new PhpCourse());
    }*/

    /*//    v3
        public static void main(String[] args) {
            Jack jack = new Jack(new JavaCourse());
            jack.studyCourse();
            jack = new Jack(new PhpCourse());
            jack.studyCourse();
            jack = new Jack(new PythonCourse());
            jack.studyCourse();
        }*/
    //    v4
    public static void main(String[] args) {
        Jack jack = new Jack();
        jack.setiCourse(new JavaCourse());
        jack.studyCourse();

        jack.setiCourse(new PythonCourse());
        jack.studyCourse();

        jack.setiCourse(new PhpCourse());
        jack.studyCourse();
    }
}
