package org.zeta;

public class Worker extends Thread{
        Worker(String name){
            super(name);
        }
        public void run(){
            for(int i=0;i<3;i++) {
                System.out.println(Thread.currentThread());
            }
        }
    }
