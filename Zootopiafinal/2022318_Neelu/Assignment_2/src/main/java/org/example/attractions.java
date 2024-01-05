package org.example;

import java.util.HashMap;
import java.util.Map;

import static org.example.zoo.dictionary_arractions;


public class attractions {

    private String Attraction_name;
    private String Attraction_discription;

    private Double price;
    private boolean isOn;


    public attractions(String name, String dis,double price) {
        this.Attraction_name = name;
        this.Attraction_discription = dis;
        this.price=price;



    }
    static void add_attractions(int num, attractions a1){
        dictionary_arractions.put(num,a1);

    }
    static void remove_attractions(int num) {
        dictionary_arractions.remove(num);
    }
    static void buy_attactions(){

    }

    public String getAttraction_name() {
        return Attraction_name;
    }

    public String getAttraction_discription() {
        return Attraction_discription;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isOn() {
        return isOn;
    }
    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }
}
