package com.squarefoot.gardening.domain;

import java.util.List;


public class Plant {

    private Long id;

    private String name;
    private List<Integer> sowWeeks;
    private int daysUntilHarvest;
    private List<Long> preferredNeighbours;
    private List<Long> badNeighbours;

    private Plant() {
    }

    public List<Long> getDetestedNeighbour() {
        return badNeighbours;
    }

    public void setDetestedNeighbour(List<Long> detestedNeighbour) {
        this.badNeighbours = detestedNeighbour;
    }

    public List<Long> getPreferredNeighbour() {
        return preferredNeighbours;
    }

    public void setPreferredNeighbour(List<Long> preferredNeighbour) {
        this.preferredNeighbours = preferredNeighbour;
    }

    public int getDaysToHarvest() {
        return daysUntilHarvest;
    }

    public void setDaysToHarvest(int daysToHarvest) {
        this.daysUntilHarvest = daysToHarvest;
    }

    public List<Integer> getSowWeeks() {
        return sowWeeks;
    }

    public void setSowWeeks(List<Integer> sowWeeks) {
        this.sowWeeks = sowWeeks;
    }

    public Plant(long id, String name, List<Integer> sowWeeks, int daysToHarvest, List<Long> preferredNeighbour,
            List<Long> detestedNeighbour) {
        this.id = id;
        this.name = name;
        this.setSowWeeks(sowWeeks);
        this.setDaysToHarvest(daysToHarvest);
        this.setPreferredNeighbour(preferredNeighbour);
        this.setDetestedNeighbour(detestedNeighbour);
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }

    // ********************************
    // Getters and setters
    // ********************************

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDaysUntilHarvest() {
        return daysUntilHarvest;
    }

    public List<Long> getDetestedNeighbours() {
        return badNeighbours;
    }

    public List<Long> getPreferredNeighbours() {
        return preferredNeighbours;
    }

}
