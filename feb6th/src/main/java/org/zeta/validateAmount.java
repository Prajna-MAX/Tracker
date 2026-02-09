package org.zeta;

interface validate{
    void val(int amt);
}
public class validateAmount {
    static validate v = (amt) -> {
        try {
            if (amt <= 0) throw new Exception("Less amt");
        } catch (Exception e) {
            System.out.println("negative amount");
        }
    };
};


