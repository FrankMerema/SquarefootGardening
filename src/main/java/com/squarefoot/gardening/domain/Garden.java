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

    // @ValueRangeProvider(id = "plantRange")
    // @ProblemFactCollectionProperty
    // private List<Plant> plantList;

    @PlanningEntityCollectionProperty
    private List<PlantLocation> plantLocationList;

    @PlanningScore
    private HardSoftScore score;

    private Garden() {
        System.out.println("squareList BLAAT");
    }

    public Garden(List<Integer> weekList, List<Square> squareList,
            // List<Plant> plantList,
            List<PlantLocation> plantLocationList
            ) {
        System.out.println("squareList BLAAT2");

        this.weekList = weekList;
        this.squareList = squareList;
        // this.plantList = plantList;
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

    // public List<Plant> getPlantList() {
    // return plantList;
    // }

    public List<PlantLocation> getPlantLocationList() {
        return plantLocationList;
    }

    public HardSoftScore getScore() {
        return score;
    }

}
