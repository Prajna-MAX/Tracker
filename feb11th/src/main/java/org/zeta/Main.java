package org.zeta;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("M");



        for(String str:list){
            if (str.equals("A")) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }
}
