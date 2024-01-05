package org.example;
import java.util.Map;

import static org.example.zoo.dictionary_members;

public interface Membership {
    int price();
    void purchase_membership(int id,double aa);

}
class Baisc_membership implements Membership{

    @Override
    public int price() {
        return 20;


    }

    @Override
    public void purchase_membership(int id,double aa) {
        for (Map.Entry<Integer, Register_visitor> entry : dictionary_members.entrySet()) {
            int mem_id = entry.getKey();
            if (mem_id == id) {
                Register_visitor visitor = entry.getValue();
                double remaining_balance = visitor.getBalance() - 20+((aa/100 )*visitor.getBalance());
                visitor.setBalance(remaining_balance); // Update the visitor's balance
                System.out.println("Remaining balance: " + remaining_balance);
                return;
            }
        }

    }

}
class Premium_Membership implements Membership{
    @Override
    public int price(){
        return 50;
    }

    @Override
    public void purchase_membership(int id,double aa) {
        for (Map.Entry<Integer, Register_visitor> entry : dictionary_members.entrySet()) {
            int mem_id = entry.getKey();
            if (mem_id == id) {
                Register_visitor visitor = entry.getValue();
                double remaining_balance = (visitor.getBalance()- 50+((aa/100 )*visitor.getBalance()));
                visitor.setBalance(remaining_balance);
                System.out.println("Remaining balance: " + remaining_balance);
                return; // If the ID is found, there's no need to continue the loop
            }
        }

    }

}
