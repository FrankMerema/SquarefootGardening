package com.squarefoot.gardening.rest;

import com.squarefoot.gardening.domain.Garden;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/planner")
public class PlannerController {

    @Autowired
    private SolverManager<Garden, UUID> solverManager;

    @PostMapping("/solve")
    public Garden solve(@RequestBody Garden problem) {
        UUID problemId = UUID.randomUUID();
        // Submit the problem to start solving

        SolverJob<Garden, UUID> solverJob = solverManager.solve(problemId, problem);
        Garden solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }

    // private Garden map(GardenProblem problem) {
    //     var garden = new Garden();
    // }
}
