package com.example.JavaFeatures.java_8_features;

import lombok.NoArgsConstructor;

import java.util.function.BiFunction;

/**
 * <p>Java Method References
 * Java provides a new feature called method reference in Java 8. Method reference is used to refer method of functional interface</p>
 *
 * <p>Types of Method References</p>
 * <ul>
 *     <li>Reference to a static method.</li>
 *     <li>Reference to an instance method.</li>
 *     <li>Reference to a constructor.</li>
 * </ul>
 *
 * @author Rashed
 * @since 02-07-2022
 */
@NoArgsConstructor
public class MethodReferences {

    public static void main(String[] args) {

        //Example 1
        MethodReferences.referStaticMethodEx1();

        MethodReferences.referNoNStaticMethodEx1();

        /**
         * Example 2
         * In the following example, we are using predefined functional interface Runnable to refer static method.
         */
        new Thread(MethodReferences::threadCall).start();

        //reference to a constructor
        Messageable messageable = MethodReferences::new;
        messageable.getMessage("This is a reference to a constructor");

    }
    MethodReferences(String msg){
        System.out.println(msg);
    }

    @FunctionalInterface
    interface Sayable{
        void say(String ref);
        default void defaultMethod1(){
            System.out.println("My name is default method 1");
        }
        default void defaultMethod2(){
            System.out.println("My name is default method 2");
        }
    }

    /**
     *
     *<p> 1) Reference to a Static Method</p>
     * <p>You can refer to static method defined in the class. Following is the syntax and example which describe the process of referring static method in Java.</p>
     *
     * <p>Syntax</p>
     * <p>ContainingClass::staticMethodName</p>
     * Example 1
     * In the following example, we have defined a functional interface and referring a static method to it's functional method say().
     */
    private static void referStaticMethodEx1(){
        // Referring static method
        Sayable sayable = MethodReferences::referStaticMethod;
        // Calling interface method
        sayable.say("Ex 1");
        sayable.defaultMethod1();
        sayable.defaultMethod2();
    }
    //static method
    private static void referStaticMethod(String ref){
        System.out.println("Hello, this is static method for "+ ref);
    }

    private static void referNoNStaticMethodEx1(){
        // Referring NON static method
        Sayable sayable = new MethodReferences()::referNoNStaticMethod;
        // Calling interface method
        sayable.say("Ex 1");
        sayable.defaultMethod1();
        sayable.defaultMethod2();
    }
    //non-static method
    private void referNoNStaticMethod(String ref){
        System.out.println("Hello, this is NON static method for "+ ref);
    }

    private static void threadCall(){
        System.out.println("Hello, this is NON static method for Thread");
    }

/**    Example 3
*   You can also use predefined functional interface to refer methods. In the following example, we are using BiFunction interface and using it's apply() method.
*/
    static class Arithmetic{
        public static int add(int a, int b){
            return a+b;
        }
    }
    public static class MethodReference3 {
        public static void main(String[] args) {
            BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
            int result = adder.apply(10, 20);
            System.out.println(result);
        }
    }

    /**
     * 3) Reference to a Constructor
     * You can refer a constructor by using the new keyword. Here, we are referring constructor with the help of functional interface.
     *
     * Syntax
     *
     * ClassName::new
     * Example
     */

    interface Messageable{
        MethodReferences getMessage(String msg);
    }
}
