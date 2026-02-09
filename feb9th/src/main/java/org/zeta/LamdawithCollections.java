package org.zeta;

import java.util.ArrayList;
import java.util.List;

public class LamdawithCollections {
    public static void showWithArrayList(){
        List<Account>accounts=new ArrayList<>();
        for(int i=0;i<10;i++){
            accounts.add(new Account(i+1));
        }
        accounts.forEach(account -> System.out.println(account));
        accounts.sort((Account a,Account b)->{
            return a.getId()-b.getId();
        });
        accounts.removeIf(account -> {
            return account.getBalance() % 2 == 0;
        });
        accounts.forEach(account -> account.getBalance());
    }
    public static void main(String[] args){
        showWithArrayList();
    }
}
