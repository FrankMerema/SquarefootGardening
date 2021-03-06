package com.squarefoot.gardening.domain;

import org.eclipse.collections.impl.list.Interval;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@PlanningSolution
public class Garden {

    @JsonProperty(access = Access.WRITE_ONLY)
    @ValueRangeProvider(id = "weekRange")
    @ProblemFactCollectionProperty
    private List<Integer> weekList;

    @JsonProperty(access = Access.WRITE_ONLY)
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
        this.weekList = Interval.oneTo(52).toList();
    }

    public Garden(List<Square> squareList,
            // List<Plant> plantList,
            List<PlantLocation> plantLocationList) {
        this.weekList = Interval.oneTo(52).toList();
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
