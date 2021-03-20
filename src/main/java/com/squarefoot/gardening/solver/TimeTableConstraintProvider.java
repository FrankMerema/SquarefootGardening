package com.squarefoot.gardening.solver;

import com.squarefoot.gardening.domain.PlantLocation;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class TimeTableConstraintProvider implements ConstraintProvider {

        @Override
        public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
                return new Constraint[] {
                                // Hard constraints
                                square(constraintFactory),
                                // teacherConflict(constraintFactory),
                                // studentGroupConflict(constraintFactory),
                                // Soft constraints are only implemented in the "complete" implementation
                };
        }

        private Constraint square(ConstraintFactory constraintFactory) {
                // A square can accommodate at most one plantLocation at the same time.

                // Select a lesson ...
                return constraintFactory.from(PlantLocation.class)
                                // ... and pair it with another lesson ...
                                .join(PlantLocation.class,
                                                // ... in the same timeslot ...
                                                Joiners.equal(PlantLocation::getStartWeek),
                                                // ... in the same room ...
                                                Joiners.equal(PlantLocation::getSerializedSquare),
                                                // ... and the pair is unique (different id, no reverse pairs)
                                                Joiners.lessThan(PlantLocation::getId))
                                // then penalize each pair with a hard weight.
                                .penalize("Square conflict", HardSoftScore.ONE_HARD);
        }

        // private Constraint teacherConflict(ConstraintFactory constraintFactory) {
        // // A teacher can teach at most one lesson at the same time.
        // return constraintFactory.from(Plant.class)
        // .join(Plant.class, Joiners.equal(Plant::getTimeslot),
        // Joiners.equal(Plant::getTeacher),
        // Joiners.lessThan(Plant::getId))
        // .penalize("Teacher conflict", HardSoftScore.ONE_HARD);
        // }

        // private Constraint studentGroupConflict(ConstraintFactory constraintFactory)
        // {
        // // A student can attend at most one lesson at the same time.
        // return constraintFactory.from(Plant.class)
        // .join(Plant.class, Joiners.equal(Plant::getTimeslot),
        // Joiners.equal(Plant::getStudentGroup), Joiners.lessThan(Plant::getId))
        // .penalize("Student group conflict", HardSoftScore.ONE_HARD);
        // }

}
