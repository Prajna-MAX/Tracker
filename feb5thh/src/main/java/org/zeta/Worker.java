package org.zeta;

public class Worker extends Thread {
    private int data;

    private boolean available = false;


    synchronized void produce(int value) throws InterruptedException {

        while (available) wait();
        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify();

    }


    synchronized void consume() throws InterruptedException {

        while (!available) wait();
        available = false;
        System.out.println("Consumed: " + data);
        notify();

    }
}