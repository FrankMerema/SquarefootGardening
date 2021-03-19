package com.squarefoot.gardening.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class PlantLocation {

    private Long id;

    private Plant plant;

    @PlanningVariable(valueRangeProviderRefs = "weekRange")
    private Integer sowWeek;

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

    public Integer getWeeks() {
        return sowWeek;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public void setWeeks(Integer sowWeek) {
        this.sowWeek = sowWeek;
    }

    public Integer getStartWeek() {
        return this.sowWeek;
    }

    public Integer getEndWeek() {
        return this.sowWeek + this.plant.getDaysUntilHarvest() / 7; // 8/7 = 1
    }

}
