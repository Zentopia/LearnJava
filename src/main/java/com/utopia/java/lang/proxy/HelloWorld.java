package com.utopia.java.lang.proxy;

/**
 * @author utopia on 2020/5/1
 */
public class HelloWorld implements Hello{
    @Override
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }
}
