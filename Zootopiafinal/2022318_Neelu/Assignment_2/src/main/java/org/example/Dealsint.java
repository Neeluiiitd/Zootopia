package org.example;

import java.util.Map;

import static org.example.zoo.dictionary_specialdeals;

public interface Dealsint {
    void add(int n,Deals d);
    void remove(int id);
}
class Deals implements Dealsint{
    private int tickets_no;
    private Double percent_off;

    public Deals(int tickets_no,Double percent_off) {
        this.tickets_no = tickets_no;
        this.percent_off=percent_off;
    }

    public int getTickets_no() {
        return tickets_no;
    }

    public Double getPercent_off() {
        return percent_off;
    }

    @Override
    public  void add(int sd, Deals d1){
        dictionary_specialdeals.put(sd++,d1);

    }

    @Override
    public void remove(int id) {
        dictionary_specialdeals.remove(id);

    }

    public static void showSpecialDeals() {
        for (Map.Entry<Integer, Deals> entry : dictionary_specialdeals.entrySet()) {
            int dealId = entry.getKey();
            Deals deal = entry.getValue();
            System.out.println("Deal ID: " + dealId + ", Deal Details: " + deal.toString());
        }
    }


}

