package org.zeta;


import java.util.function.Function;

public class Loans {
    int amt;
    static int tenure;
    Loans(int amt,int tenure){
        this.amt=amt;
        this.tenure=tenure;
}


    static  Function<Integer, Double> callLoan = amt -> {
        validateAmount.v.val(amt);       // validate the amount
        return amt * (12.2 / 100) * tenure; // calculate interest
    };
}
