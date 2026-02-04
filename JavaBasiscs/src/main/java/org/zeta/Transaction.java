package org.zeta;

import java.util.logging.Logger;

public class Transaction {

    public void transact(Account a1,Account a2,int amt){

        Logger logger=Logger.getLogger(Transaction.class.getName());

        try {
            a1.withdraw (amt);
        } catch (InsuffiecientBankBalance InsufficientBankBalance) {
            logger.severe(InsufficientBankBalance.getMessage());
        }
        catch (IllegalArgumentException illegalArgumentException){
            logger.severe(illegalArgumentException.getMessage());
        }
        a2.deposit(amt);
    }


}
