package org.zeta;

public class Loans {
    int amt;
    int tenure;
    Loans(int amt,int tenure){
        this.amt=amt;
        this.tenure=tenure;
}

    double callLoan(int amt){
        validateAmount.validate(amt);
        return amt*(12.2/100)*tenure;
    }
}
