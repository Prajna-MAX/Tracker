package org.zeta;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class AccTask extends RecursiveTask<Integer> {

    List<Account> data;
    int start, end;

    AccTask(List<Account> data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        int sum = 0;
        if (end - start < 3) {
            for (int i = start; i < end; i++) {
                sum += data.get(i).balance;
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            AccTask left = new AccTask(data, start, mid);
            AccTask right = new AccTask(data, mid, end);
            right.fork();
            int leftResult = left.compute();
            int rightResult = right.join();
            return leftResult + rightResult;
        }
    }

}

public class ForkJoinAcc {
    public static void main(String[] args) {
        List<Account> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Account acc = new Account(Math.random() * 100);
            System.out.println("i  " + i + "  bal " + acc.balance);
            data.add(acc);
        }


        ForkJoinPool fork = new ForkJoinPool();
        AccTask task=new AccTask(data,0,data.size());
        long start= System.currentTimeMillis();
        System.out.println(fork.invoke(task));
        System.out.println(System.currentTimeMillis()-start);

    }
}