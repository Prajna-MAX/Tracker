package org.zeta;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class myKey{

}
public class Main {
    public static void main(String[] args) {
        Map<String,String> testmap=new HashMap<>();
        Map<myKey,Integer> map=new HashMap<>();
        myKey key1=new myKey();
        map.put(key1,1);

        for(Map.Entry<myKey,Integer>entry:map.entrySet()){
            System.out.println(entry.getValue());
        }


    }
}