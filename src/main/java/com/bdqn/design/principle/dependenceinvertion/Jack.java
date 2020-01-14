package com.bdqn.design.principle.dependenceinvertion;

/**
 * ClassName: Jack
 * create by:  xyf
 * description: 依赖倒置原则的测试实体
 * create time: 2020/1/14 11:57
 */
public class Jack {

    private ICourse iCourse;

    /*public void studyJava(){
        System.out.println("学习JAVA");
    }
    public void studyPhp(){
        System.out.println("学习PHP");
    }
    public void studyPython(){
        System.out.println("学习Python");
    }*/


    //    构造注入
    /*public Jack(ICourse iCourse) {
        this.iCourse = iCourse;
    }*/


//    设值注入
    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    /* //    v1
        public void studyCourse(ICourse iCourse){
            iCourse.studyCourse();
        }*/


    //    v2
    public void studyCourse(){
        iCourse.studyCourse();
    }
}
