package org.zeta;

public class EmeraldCreditCard extends CreditCardBase implements ICreditCard{

    EmeraldCreditCard(String name) {
        super(name);
    }

    @Override
    public boolean transaction(float amt) {
        return false;
    }

    @Override
    public boolean withdraw(float amt) {
        return false;
    }
}
