package com.utopia.java.lang.collection;

import java.util.TreeSet;

/**
 * @author utopia on 2020/3/30
 */
public class Set {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(1);

        treeSet.forEach(System.out::println);
    }
}
