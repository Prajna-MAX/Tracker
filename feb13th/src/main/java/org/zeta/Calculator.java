package org.zeta;

public class Calculator {
    public static int addInteger(int a, int b){
        if(a==10) {System.out.println("its 10");}
        return a+b;
    }
    public static int divideInteger(int a, int b){
        if(b==0){
            System.out.println("cannot be zero");
        }
        return a/b;
    }

}
