package com.utopia.java.lang.clone;


/**
 * @author utopia on 2020/3/29
 */
public class ObjectClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setName("Bob");
        Student cloneStudent = student.clone();
        System.out.println(cloneStudent.getName());
    }
}
