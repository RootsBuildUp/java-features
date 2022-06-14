package com.example.JavaFeatures.java_8_features;

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
    }

    @FunctionalInterface
    interface SayAble{
        public String say();
    }
    @FunctionalInterface
    interface SayAble1{
        public String say(String name);
    }

    interface Drawable extends SayAble{
        public void draw();
    }

    /**
     * <p>No Parameter Lambda Expression</p>
     */
    public void noParameterLambdaExp(){
        int width = 10;
        /** without lambda, FunctionalInterface, NON FunctionalInterface Accepted able */
        Drawable d =new Drawable(){
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

        /** without lambda, NON FunctionalInterface not Accepted able, FunctionalInterface Accepted able */
        SayAble say = () -> "FunctionalInterface Accepted able";
        System.out.println(say.say());
    }


    /**
     * <p>Single Parameter Lambda Expression</p>
     */

    public void singleParameterLambdaExp(){

        SayAble1 say = (name)->{return "My name is "+ name;};
        System.out.println(say.say("Rashedul Islam"));

        //You can omit function parentheses
        SayAble1 say1 = name -> {return "My name is "+ name;};
        SayAble1 say2 = name -> "My name is "+ name;
        System.out.println(say1.say("Tahiyan"));
        System.out.println(say2.say("Farhan"));
    }

}
