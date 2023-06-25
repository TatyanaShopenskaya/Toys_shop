package org.example;
import java.util.Objects;

public class Toys implements Comparable<Toys> {
    private int id;
    private String name;
    private int frequency;   //частота

    public Toys(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getInfo() {
        return String.format("выиграл: " + id +" "+ name);
    }

    @Override
    public int compareTo(Toys o) {
        return Integer.compare(o.frequency, this.frequency);
    }
}