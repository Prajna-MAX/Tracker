package org.zeta;

public interface ICreditCard {
    boolean transaction(float amt);
    boolean withdraw(float amt);
}
