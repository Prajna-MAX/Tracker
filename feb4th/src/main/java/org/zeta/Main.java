package org.zeta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank b=new Bank();
        b.issueEmeraldCards("abc");
        b.issueInfinienCard("qwerty");
        System.out.println(b.cards);
    }
}