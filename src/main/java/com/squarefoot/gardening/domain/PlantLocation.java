package com.squarefoot.gardening.domain;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class PlantLocation {

    private Long id;

    private Plant plant;

    @PlanningVariable(valueRangeProviderRefs = "weekRange")
    private List<Week> weeks;

    @PlanningVariable(valueRangeProviderRefs = "squareRange")
    private Square square;

    private PlantLocation() {
    }

    public PlantLocation(Long id, Plant plant) {
        this.id = id;
        this.plant = plant;
    }

    @Override
    public String toString() {
        return plant.toString() + "(" + id + ")";
    }

    // ********************************
    // Getters and setters
    // ********************************

    public Long getId() {
        return id;
    }

    public Plant getPlant() {
        return plant;
    }

    public Square getSquare() {
        return square;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }

    public Week getStartWeek() {
        return this.weeks.get(0);
    }

    public Week getLastWeek() {
        return this.weeks.get(this.weeks.size() - 1);
    }

}
