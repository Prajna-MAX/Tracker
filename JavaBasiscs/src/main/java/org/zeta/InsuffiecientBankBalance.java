package org.zeta;

public class InsuffiecientBankBalance extends RuntimeException {
    public InsuffiecientBankBalance(String msg) {
        super(msg);
    }
}