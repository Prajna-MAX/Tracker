package org.zeta;

public class InfinienCard extends CreditCardBase implements ICreditCard{

    InfinienCard(String name) {
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
