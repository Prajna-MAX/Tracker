package org.zeta;

@FunctionalInterface
interface ArrayIncrement {
    void increment(int[] array);
}

@FunctionalInterface
interface CustomIncrement {
    void increment(int[] array, int inc);
}

public class Lamda {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5,6};

        // Increment all elements by 2
        ArrayIncrement addAll = arr -> {
            System.out.println("Increment all numbers:");
            for (int n : arr) {
                System.out.println(n + 2);
            }
        };

        // Increment only even elements by 2
        ArrayIncrement addEven = arr -> {
            System.out.println("Increment even numbers:");
            for (int n : arr) {
                if (n % 2 == 0)
                    System.out.println(n + 2);
                else
                    System.out.println(n);
            }
        };

        // Increment all elements by given number
        CustomIncrement addByNum = (arr, num) -> {
            System.out.println("Increment by " + num + ":");
            for (int n : arr) {
                System.out.println(n + num);
            }
        };

        ArrayIncrement skipThree=(arr)->{
            System.out.println("Sum of digits of every third number");
            int sum=0;
            for(int i=2;i< arr.length;i+=3){
                System.out.println(arr[i]);
                sum+=arr[i];
            }
            System.out.println("Final:"+sum);
        };

        addAll.increment(array);
        addEven.increment(array);
        addByNum.increment(array, 5);
        skipThree.increment(array);
    }
}
