package com.example.JavaFeatures.java_8_features;

/**
 * <p>Java Functional Interfaces</p>
 * <p>An Interface that contains exactly one abstract method is known as functional interface.</p>
 * @author rashedul
 * @since 10-07-2022
 */
public class FunctionalInterfaces {

    public static void main(String[] args) {
        stringValue("Hello, My name is Rashed");
    }

    private static void stringValue(String s) {
        SayAble sayAble = FunctionalInterfaces.interfaceCall(FunctionalInterfaces::StringValueCall);
        System.out.println(sayAble.say(s));
    }

    private static String StringValueCall(String s) {
        return s;
    }

    static SayAble interfaceCall(SayAble sayAble){
        sayAble.doIt();
        return sayAble;
    }

    /**
     * Invalid '@FunctionalInterface' annotation; Doable abstract method is not a functional interface
     */
    @FunctionalInterface
    interface SayAble{
        String say(String msg);
        // It can contain any number of Object class methods.
        int hashCode();
        String toString();
        boolean equals(Object obj);
        default void doIt(){
            System.out.println("Do it now");
            initValue();
        }
        private static void initValue(){
            System.out.println("init value calling");
        }
    }


}
