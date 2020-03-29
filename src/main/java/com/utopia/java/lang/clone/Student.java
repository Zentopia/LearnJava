package com.utopia.java.lang.clone;

/**
 * @author utopia on 2020/3/29
 */
public class Student implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
