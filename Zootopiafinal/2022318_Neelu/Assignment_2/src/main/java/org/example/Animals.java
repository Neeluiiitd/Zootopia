package org.example;
import java.util.Map;

public interface Animals {
    String getName();
    String getType();
    String getNoise();
    String getHistory();

    void setName(String name);
    void setType(String type);
    void setNoise(String noise);
    void SetHistory(String his);



}

class Mammals implements Animals {
    private String name;
    private String type;
    private String noise;
    private String history;



    public Mammals(String name,String type,String noise,String history) {
        this.name = name;
        this.type = type;
        this.noise=noise;
        this.history=history;


    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }





    @Override
    public void SetHistory(String his) {

    }

    public void setType(String type) {
        this.type = type;
    }



    public void setNoise(String noise) {
        this.noise = noise;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public String getNoise() {
        return noise;
    }

    @Override
    public String toString() {
        return "Mammals{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", noise='" + noise + '\'' +
                ", history='" + history + '\'' +
                '}';
    }
}

class Amphibians implements Animals {
    private String name;
    private String type;
    private String noise;
    private String history;

    public Amphibians(String name, String type,String noise,String history) {
        this.name = name;
        this.type = type;
        this.noise=noise;
        this.history=history;


    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    @Override
    public void SetHistory(String his) {

    }

    public String getHistory() {
        return history;
    }

    public String getNoise() {
        return noise;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Amphibians{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", noise='" + noise + '\'' +
                ", history='" + history + '\'' +
                '}';
    }
}

class Reptiles implements Animals {
    private String name;
    private String type;
    private String noise;
    private String history;

    @Override
    public void SetHistory(String his) {

    }

    public Reptiles(String name, String type, String noise, String history) {
        this.name = name;
        this.type = type;
        this.noise=noise;
        this.history=history;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Reptiles{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", noise='" + noise + '\'' +
                ", history='" + history + '\'' +
                '}';
    }

    public String getNoise() {
        return noise;
    }

    public String getHistory() {
        return history;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
