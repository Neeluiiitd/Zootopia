package org.example;

import static org.example.zoo.boughtics;

public class boughttics extends visited {
    private int num;
    private attractions a;

    public boughttics(int num,attractions a) {
        this.num = num;
        this.a=a;
    }

    public  void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public attractions getA() {
        return a;
    }
    static void addin(attractions a){
        boughtics.add(a);
    }

}
