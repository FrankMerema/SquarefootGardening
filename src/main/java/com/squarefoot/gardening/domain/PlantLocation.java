package com.squarefoot.gardening.domain;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class PlantLocation {

    private Long id;

    private String plantName;

    @PlanningVariable(valueRangeProviderRefs = "weekRange")
    private List<Week> weeks;

    @PlanningVariable(valueRangeProviderRefs = "roomRange")
    private Square square;

    private PlantLocation() {
    }

    public PlantLocation(Long id, String plantName) {
        this.id = id;
        this.plantName = plantName;
    }

    @Override
    public String toString() {
        return plantName + "(" + id + ")";
    }

    // ********************************
    // Getters and setters
    // ********************************

    public Long getId() {
        return id;
    }

    public String getName() {
        return plantName;
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

}
