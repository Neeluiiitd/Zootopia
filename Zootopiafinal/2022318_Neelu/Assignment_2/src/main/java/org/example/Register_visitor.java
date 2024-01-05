package org.example;

import static org.example.zoo.dictionary_members;

public class Register_visitor {
    String visitor_name;
    private int age;
    private int number;
    private double balance;
    private String email;
    private String password;



    public Register_visitor(String visitor_name,int age,int number,int balance,String email,String password) {
        this.visitor_name = visitor_name;
        this.age=age;
        this.number=number;
        this.balance=balance;
        this.email=email;
        this.password=password;
    }

    public int getAge() {
        return age;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
    static void register_member(int num, Register_visitor v1){
        dictionary_members.put(num,v1);



    }


    public void setBalance(double remaining_balance) {
        this.balance=remaining_balance;

    }
}
