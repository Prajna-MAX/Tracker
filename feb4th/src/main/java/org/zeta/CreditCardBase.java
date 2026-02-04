package org.zeta;

public abstract class CreditCardBase  {
     private float dueAmount;
    private float id;
    private String name;

    CreditCardBase(String name){
        this.name=name;
    }
}
