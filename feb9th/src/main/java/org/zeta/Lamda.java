package org.zeta;

import java.util.function.Consumer;
import java.util.function.Predicate;

interface arrayIncrement{
    void increment(int[] array);
}

interface customIncrement{
    void increment(int[]array,int inc);
}

public class Lamda {
    public static void main(String args[]) {
        arrayIncrement addAll=(array)->{
            System.out.println("Increment all numbers");
            int[] newArray=new int[array.length];
           for(int i=0;i<array.length;i++){
               newArray[i]=array[i]+2;
               System.out.println(newArray[i]);
           }
        };
        arrayIncrement addEven=(array)->{
            System.out.println("Increment all even numbers");
            int[] newArray2=new int[array.length];

            for(int i=0;i<array.length;i++){
                if(array[i]%2==0)
                    newArray2[i]=array[i]+2;
                System.out.println(newArray2[i]);
            }
        };

        customIncrement add=(array,num)->{
            System.out.println("Increment according to num");
            int[] newArray3=new int[array.length];
            for(int i=0;i<array.length;i++){
                newArray3[i]=array[i]+num;
                System.out.println(newArray3[i]);
            }
        };

        int[] array ={1,2,3,4,5};
        addAll.increment(array);
        addEven.increment(array);
        add.increment(array,5);

    }
}