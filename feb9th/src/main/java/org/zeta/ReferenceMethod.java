package org.zeta;

import java.util.function.Function;

public class ReferenceMethod {
    static int square(int x){
        return x*x;
    }
    static int sum(int x,int y){
        return x+y;
    }
    public static void main(String args[]){
        ReferenceMethod r=new ReferenceMethod();
        Function<Integer,Integer>ref=ReferenceMethod::square;
    }
}
