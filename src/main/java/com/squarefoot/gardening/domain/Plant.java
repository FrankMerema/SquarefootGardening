package com.squarefoot.gardening.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

}
