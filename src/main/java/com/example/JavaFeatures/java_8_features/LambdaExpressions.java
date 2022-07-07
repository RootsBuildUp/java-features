package com.example.JavaFeatures.java_8_features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.*;
import java.util.stream.Stream;

/**
 *
 *<p>Why use Lambda Expression? </p>
 * <ul>
 * <li> To provide the implementation of Functional interface.</li>
 * <li> Less coding.</li>
 * </ul>
 *
 * <p>Syntax: - (argument-list) -> {body}</p>
 * <ul>
 * <li>argument-list:- It can be empty or non-empty as well</li>
 * <li>Arrow-token:- It is used to link arguments-list and body of expression</li>
 * <li>Body:- It contains expressions and statements for lambda expression</li>
 * </ul>
 *
 * <p>No Parameter / One Parameter / Tow Parameter Syntax</p>
 * <p>()->{body}  / (p1)->{body}  / (p1,p2)->{body}</p>
 *
 * @author Rashedul Islam
 * @since 15-06-2022
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        LambdaExpressions lambda = new LambdaExpressions();
            lambda.noParameterLambdaExp();
            lambda.singleParameterLambdaExp();
            lambda.multipleParameterLambdaExpression();
            lambda.forEachLoopLambdaExpression();
            lambda.multipleStatements();
            lambda.CreateThreadLambdaExpression();
            lambda.comparatorLambdaExpression();
    }

    @FunctionalInterface
    interface SayAble {
        String say();
    }

    @FunctionalInterface
    interface SayAble1 {
        String say(String name);
    }

    interface Drawable extends SayAble {
        void draw();
    }

    /**
     * <p>No Parameter Lambda Expression</p>
     */
    public void noParameterLambdaExp() {
        int width = 10;
        /** without lambda, FunctionalInterface, NON FunctionalInterface Accepted able */
        Drawable d = new Drawable() {
            @Override
            public String say() {
                return "I have nothing to say";
            }

            @Override
            public void draw() {
                System.out.println("without Drawing " + width);
            }
        };
        d.say();
        d.draw();

        /** Lambda, NON FunctionalInterface not Accepted able, FunctionalInterface Accepted able */
        SayAble say = () -> "FunctionalInterface Accepted able";
        System.out.println(say.say());
    }


    /**
     * <p>Single Parameter Lambda Expression</p>
     */

    public void singleParameterLambdaExp() {

        SayAble1 say = (name) -> {
            return "My name is " + name;
        };
        System.out.println(say.say("Rashedul Islam"));

        //You can omit function parentheses
        SayAble1 say1 = name -> {
            return "My name is " + name;
        };
        SayAble1 say2 = name -> "My name is " + name;
        System.out.println(say1.say("Tahiyan"));
        System.out.println(say2.say("Mujahina"));
        System.out.println(say2.say("Farhan"));
    }

    /**
     * <p>Java Lambda Expression Example: Multiple Parameters</p>
     */

    @FunctionalInterface
    interface Addable {
        int add(int a, int b);
    }

    private void multipleParameterLambdaExpression() {

        // Multiple parameters in lambda expression
        Addable ad = (a, b) -> (a + b);
        System.out.println(ad.add(10, 20));

        // Multiple parameters with data type in lambda expression
        Addable ad2 = (int a, int b) -> (a + b);
        System.out.println(ad2.add(100, 200));
    }

    /**
     * <p>Java Lambda Expression Example: Foreach Loop</p>
     */
    private void forEachLoopLambdaExpression() {
        new ArrayList<>(Arrays.asList("Rashed", "Tahiyan", "Farhan", "Mujahina")).forEach(ob -> System.out.println(ob));
    }

    /**
     * <p>Java Lambda Expression Example: Multiple Statements</p>
     */
    private void multipleStatements() {

        // You can pass multiple statements in lambda expression
        SayAble1 person = message -> {
            String str = "I would like to say, ";
            return str + message;
        };
        System.out.println(person.say("time is precious."));
    }

    /**
     * <p>Java Lambda Expression Example: Creating Thread</p>
     * <p>You can use lambda expression to run thread.In the following example,
     * we are implementing run method by using lambda expression.</p>
     */
    private void CreateThreadLambdaExpression() {
        //Thread Example without lambda
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Thread1 is running...");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        //Thread Example with lambda
        new Thread(() -> {
            System.out.println("Thread2 is running...");
        }).start();
    }

    /**
     * <p>Java Lambda Expression Example: Comparator</p>
     */

    @Data // call to getter, setter, toString
    @AllArgsConstructor // call all argument constructor
    @Accessors(chain = true) // new Product().setId(1).setName("Hp Laptop").setPrice(10023f);
    class Product{
        int id;
        String name;
        float price;
    }
    private void comparatorLambdaExpression(){
        List<Product> list=new ArrayList<>();

        //Adding Products
        list.add(new Product(1,"HP Laptop",25000f));
        list.add(new Product(3,"Keyboard",300f));
        list.add(new Product(2,"Dell Mouse",150f));

        System.out.println("Sorting on the basis of name...");
        // implementing lambda expression
        Collections.sort(list, Comparator.comparing(p -> p.name));
        list.forEach(p -> System.out.println(p.id+" "+p.name+" "+p.price));

        // using lambda to filter data and iterate through collection
        list.stream().filter(p -> p.price > 20000).forEach(product -> System.out.println(product.name+": "+product.price));
    }

}
