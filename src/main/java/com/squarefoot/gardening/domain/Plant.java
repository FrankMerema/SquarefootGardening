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

    public Plant(Long id, String name, List<Integer> sowWeeks, int daysUntilHarvest, List<Long> preferredNeighbours, List<Long> badNeighbours) {
        this.id = id;
        this.name = name;
        this.sowWeeks = sowWeeks;
        this.daysUntilHarvest = daysUntilHarvest;
        this.preferredNeighbours = preferredNeighbours;
        this.badNeighbours = badNeighbours;
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

    public List<Integer> getSowWeeks() {
        return sowWeeks;
    }

    public int getDaysUntilHarvest() {
        return daysUntilHarvest;
    }

    public List<Long> getPreferredNeighbours() {
        return preferredNeighbours;
    }

    public List<Long> getBadNeighbours() {
        return badNeighbours;
    }
}
