package org.zeta;


import java.util.function.BiFunction;
import java.util.function.Function;

public class Loans {
    int amt;
    static int tenure;
    Loans(int amt,int tenure){
        this.amt=amt;
        this.tenure=tenure;
}


    static BiFunction<Integer,Integer, Double> callLoan = (amt,tenure) -> {
        validateAmount.v.val(amt);       // validate the amount
        Double interest=amt * (12.2 / 100) * tenure;
        return interest;
    };
}
