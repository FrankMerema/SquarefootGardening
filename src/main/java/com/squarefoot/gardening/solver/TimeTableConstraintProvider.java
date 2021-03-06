package com.squarefoot.gardening.solver;

import com.squarefoot.gardening.domain.PlantLocation;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import static org.optaplanner.core.api.score.stream.Joiners.equal;
import static org.optaplanner.core.api.score.stream.Joiners.overlapping;
import static org.optaplanner.core.api.score.stream.Joiners.lessThan;

public class TimeTableConstraintProvider implements ConstraintProvider {

        @Override
        public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
                return new Constraint[] {
                                // Hard constraints
                                squareWeekConflict(constraintFactory) };
        }

        private Constraint squareWeekConflict(ConstraintFactory factory) {
                // A square can accommodate at most one plantLocation at the same time.

                // Select a PlantLocation pair
                return factory.fromUniquePair(PlantLocation.class,
                                // ... in the same square ...
                                equal(PlantLocation::getSerializedSquare),
                                // ... overlapping in the square ...
                                overlapping(t -> t.getSowWeek(), t -> t.getEndWeek()),
                                // ... and the pair is unique (different id, no reverse pairs)
                                lessThan(PlantLocation::getId))
                                // then penalize each pair with a hard weight.
                                .penalize("Square conflict", HardSoftScore.ONE_HARD);
        }
}
