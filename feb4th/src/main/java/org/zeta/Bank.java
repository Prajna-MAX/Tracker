package org.zeta;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<ICreditCard> cards=new ArrayList<>();


    void issueEmeraldCards(String name){

        ICreditCard c1=new EmeraldCreditCard(name);
        cards.add(c1);
        System.out.println(c1.toString());
    }
    void issueInfinienCard(String name){
        ICreditCard c2=new InfinienCard(name);
        cards.add(c2);
        System.out.println(c2.toString());
    }
}
