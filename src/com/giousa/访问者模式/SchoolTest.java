package com.giousa.访问者模式;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SchoolTest {

    public interface Visitor {

        void visit(Student student);

        void visit(Teacher teacher);
    }

    public abstract class User {

        /**姓名*/
        public String name;
        /**用户的身份，包括学生和教师*/
        public String identity;
        /**所属班级*/
        public String clazz;

        public User(String name, String identity, String clazz) {
            this.name = name;
            this.identity = identity;
            this.clazz = clazz;
        }

        public abstract void accept(Visitor visitor);
    }


    public class Student extends User{

        public Student(String name, String identity, String clazz) {
            super(name, identity, clazz);
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public int ranking() {
            return (int) (Math.random()*100);
        }
    }
    public class Teacher extends User {

        public Teacher(String name, String identity, String clazz) {
            super(name, identity, clazz);
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
        //升学率
        public double entranceRatio() {
            return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

    }


    public class Parent implements Visitor{

        private Logger logger = LoggerFactory.getLogger(Parent.class);

        @Override
        public void visit(Student student) {
//            logger.info("学生信息 姓名：{} 班级：{} 排名：{}", student.name, student.clazz, student.ranking());
        }

        @Override
        public void visit(Teacher teacher) {
//            logger.info("老师信息 姓名：{} 班级：{}", teacher.name, teacher.clazz);
        }
    }
    public class Principal implements Visitor{

        private Logger logger = LoggerFactory.getLogger(Principal.class);

        @Override
        public void visit(Student student) {
//            logger.info("学生信息 姓名： {} 班级：{}", student.name, student.clazz);
        }

        @Override
        public void visit(Teacher teacher) {
//            logger.info("老师信息 姓名： {} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
        }
    }


    public class DataView {

        List<User> userList = new ArrayList<>();

        public DataView() {
            userList.add(new Student("Ethan", "普通班", "高一1班"));
            userList.add(new Student("Tom", "重点班", "高一2班"));
            userList.add(new Student("Peter", "重点班", "高一3班"));
            userList.add(new Teacher("张三", "普通班", "高一1班"));
            userList.add(new Teacher("李四", "重点班", "高一2班"));
            userList.add(new Teacher("王五", "重点班", "高一3班"));
        }

        public void show(Visitor visitor) {
            for (User user : userList) {
                user.accept(visitor);
            }
        }
    }


    public static void main(String[] args) {
//        DataView dataView = new DataView();
//
//        System.out.println("家长视角访问：");
//        dataView.show(new Parent());
//
//        System.out.println("校长视角访问：");
//        dataView.show(new Principal());
    }
}
