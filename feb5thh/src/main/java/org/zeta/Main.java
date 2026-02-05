package org.zeta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Worker w1=new Worker("abc");
        w1.start();
        w1.wait();
        Worker w2=new Worker("bcd");
        w2.start();
    }
}