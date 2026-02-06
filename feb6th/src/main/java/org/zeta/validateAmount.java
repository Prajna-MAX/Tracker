package org.zeta;

public class validateAmount{
    static void validate(int amt) {
        try {
            if (amt <= 0) throw new Exception("Less amt");
        } catch (Exception e) {
            System.out.println("negative amount");
        }
    }
}
