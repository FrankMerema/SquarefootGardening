package com.squarefoot.gardening.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@PlanningSolution
public class Garden {

    @JsonProperty(access = Access.WRITE_ONLY)
    @ValueRangeProvider(id = "weekRange")
    @ProblemFactCollectionProperty
    private final List<Integer> weekList;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ValueRangeProvider(id = "squareRange")
    @ProblemFactCollectionProperty
    private List<Square> squareList;

    @PlanningEntityCollectionProperty
    private List<PlantLocation> plantLocationList;

    @PlanningScore
    private HardSoftScore score;

    private Garden() {
        this.weekList = IntStream.rangeClosed(1, 52)
                .boxed().collect(Collectors.toList());
    }

    public Garden(List<Square> squareList,
                  List<PlantLocation> plantLocationList) {
        this.weekList = IntStream.rangeClosed(1, 52)
                .boxed().collect(Collectors.toList());
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
