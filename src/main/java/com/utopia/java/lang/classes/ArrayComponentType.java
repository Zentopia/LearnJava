package com.utopia.java.lang.classes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArrayComponentType {

    public static void main(String[] args) {
        int [][] a = {{1, 2}};
        System.out.println(a.getClass().getComponentType());
        return;
    }

}
