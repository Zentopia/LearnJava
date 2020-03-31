package com.utopia.java.lang.classes;

/**
 * @author utopia on 2020/3/31
 */
public class OuterClass {

    private String outerName;

    private String getOuterName(){
        return outerName;
    }

    public class InnerClass {

        private String getrName(){
            return outerName;
        }

        private String accessMethod(){
            return getOuterName();
        }
    }

    public static class nestedClass{

    }

    public static InnerClass createInnerClass(){

        OuterClass outerObj = new OuterClass();
        InnerClass innerClass = outerObj.new InnerClass();
        return innerClass;
    }

}
