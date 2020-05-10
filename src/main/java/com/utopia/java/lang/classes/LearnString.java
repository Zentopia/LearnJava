package com.utopia.java.lang.classes;

/**
 * @author utopia on 2020/5/9
 */
public class LearnString {

    public static void main(String[] args) {
        String a = new String("a");
        String ia = a.intern();
        System.out.println(a == ia);

        String b = "b";
        String ib = b.intern();
        System.out.println(b == ib);
    }
}
