package org.zeta;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Task extends RecursiveTask<Integer> {
    int[]data;
    int start,end;
    Task(int[]data,int start,int end){
        this.data=data;
        this.start=start;
        this.end=end;
    }
    protected Integer compute(){
        int sum=0;
        if(end-start<3){
            for(int i=start;i<end;i++){
                sum+=data[i];
            }
            return sum;
        }
        else{
            int mid=(start+end)/2;
            Task left=new Task(data,start,mid);
            Task right=new Task(data,mid,end);
            right.fork();
            int leftResult=left.compute();
            int rightResult=right.join();
            return leftResult+rightResult;
        }
    }

}
public class ForkJoin {
    public static void main(String[] args) {
        int[]data={1,2,3,4,5};

        ForkJoinPool fork=new ForkJoinPool();
        Task task=new Task(data,0,data.length);
        System.out.println(fork.invoke(task));

    }
}