package org.zeta.exception;

public class BankingException extends RuntimeException {
    public BankingException(String message) {
        super(message);
    }
}