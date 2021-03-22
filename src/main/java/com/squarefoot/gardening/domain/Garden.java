package com.squarefoot.gardening.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class Garden {

    @ValueRangeProvider(id = "weekRange")
    @ProblemFactCollectionProperty
    private List<Integer> weekList;

    @ValueRangeProvider(id = "squareRange")
    @ProblemFactCollectionProperty
    private List<Square> squareList;

    @PlanningEntityCollectionProperty
    private List<PlantLocation> plantLocationList;

    @PlanningScore
    private HardSoftScore score;

    private Garden() {
    }

    public Garden(List<Integer> weekList, List<Square> squareList,
                  List<PlantLocation> plantLocationList) {
        this.weekList = weekList;
        this.squareList = squareList;
        this.plantLocationList = plantLocationList;
    }

    // ********************************
    // Getters and setters
    // ********************************

    public List<Integer> getWeekList() {
        return weekList;
    }

    public List<Square> getSquareList() {
        return squareList;
    }

    public List<PlantLocation> getPlantLocationList() {
        return plantLocationList;
    }

    public HardSoftScore getScore() {
        return score;
    }

}
