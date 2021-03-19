package com.squarefoot.gardening.domain;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Plant {

    private Long id;

    private String name;
    private List<Week> sowWeeks;
    private int daysUntilHarvest;
    private List<Plant> preferredNeighbours;
    private List<Plant> detestedNeighbours;

    private Plant() {
    }

    public List<Plant> getDetestedNeighbour() {
        return detestedNeighbours;
    }

    public void setDetestedNeighbour(List<Plant> detestedNeighbour) {
        this.detestedNeighbours = detestedNeighbour;
    }

    public List<Plant> getPreferredNeighbour() {
        return preferredNeighbours;
    }

    public void setPreferredNeighbour(List<Plant> preferredNeighbour) {
        this.preferredNeighbours = preferredNeighbour;
    }

    public int getDaysToHarvest() {
        return daysUntilHarvest;
    }

    public void setDaysToHarvest(int daysToHarvest) {
        this.daysUntilHarvest = daysToHarvest;
    }

    public List<Week> getSowWeeks() {
        return sowWeeks;
    }

    public void setSowWeeks(List<Week> sowWeeks) {
        this.sowWeeks = sowWeeks;
    }

    public Plant(long id, String name, List<Week> sowWeeks, int daysToHarvest, List<Plant> preferredNeighbour,
            List<Plant> detestedNeighbour) {
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

}
