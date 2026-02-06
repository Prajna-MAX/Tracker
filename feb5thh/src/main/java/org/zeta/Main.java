package org.zeta;

import java.nio.Buffer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Worker b=new Worker();

        Thread producer=new Thread(()->{
            try{
                for(int i=0;i<5;i++){
                    b.produce(i);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer=new Thread(()->{
            try{
                for(int i=0;i<5;i++){
                    b.consume(i);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}