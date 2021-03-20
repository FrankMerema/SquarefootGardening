package com.squarefoot.gardening.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Plant {

    private Long id;

    private String name;

    private List<Integer> sowWeeks;

    private int daysUntilHarvest;

    private List<Long> preferredNeighbours;

    private List<Long> badNeighbours;

    private Plant() {
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public List<Long> getDetestedNeighbour() {
        return badNeighbours;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public void setDetestedNeighbour(List<Long> detestedNeighbour) {
        this.badNeighbours = detestedNeighbour;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public List<Long> getPreferredNeighbour() {
        return preferredNeighbours;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public void setPreferredNeighbour(List<Long> preferredNeighbour) {
        this.preferredNeighbours = preferredNeighbour;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public int getDaysToHarvest() {
        return daysUntilHarvest;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public void setDaysToHarvest(int daysToHarvest) {
        this.daysUntilHarvest = daysToHarvest;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public List<Integer> getSowWeeks() {
        return sowWeeks;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
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

    @JsonProperty(access = Access.WRITE_ONLY)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public int getDaysUntilHarvest() {
        return daysUntilHarvest;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public List<Long> getDetestedNeighbours() {
        return badNeighbours;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public List<Long> getPreferredNeighbours() {
        return preferredNeighbours;
    }

}
