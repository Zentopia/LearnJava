package com.utopia.java.lang.refect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.List;

public class LearnMethodHandle {

    public static void main(String[] args) throws Throwable {

        //creating lookup
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();

        //creating method type
        MethodType mtList = MethodType.methodType(List.class, Object[].class);
        MethodType mtInt = MethodType.methodType(int.class, Object.class);

        MethodType mt = MethodType.methodType(String.class, String.class);

        MethodHandle concatMH = publicLookup.findVirtual(String.class, "concat", mt);
        String res = (String) concatMH.invoke("a", "b");
        System.out.println(res);
    }
}
