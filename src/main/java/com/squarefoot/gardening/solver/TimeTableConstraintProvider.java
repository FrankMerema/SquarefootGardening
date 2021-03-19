package com.squarefoot.gardening.solver;

import com.squarefoot.gardening.domain.Plant;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                // Hard constraints
                roomConflict(constraintFactory),
                teacherConflict(constraintFactory),
                studentGroupConflict(constraintFactory),
                // Soft constraints are only implemented in the "complete" implementation
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one lesson at the same time.

        // Select a lesson ...
        return constraintFactory.from(Plant.class)
                // ... and pair it with another lesson ...
                .join(Plant.class,
                        // ... in the same timeslot ...
                        Joiners.equal(Plant::getTimeslot),
                        // ... in the same room ...
                        Joiners.equal(Plant::getRoom),
                        // ... and the pair is unique (different id, no reverse pairs)
                        Joiners.lessThan(Plant::getId))
                // then penalize each pair with a hard weight.
                .penalize("Room conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint teacherConflict(ConstraintFactory constraintFactory) {
        // A teacher can teach at most one lesson at the same time.
        return constraintFactory.from(Plant.class)
                .join(Plant.class,
                        Joiners.equal(Plant::getTimeslot),
                        Joiners.equal(Plant::getTeacher),
                        Joiners.lessThan(Plant::getId))
                .penalize("Teacher conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint studentGroupConflict(ConstraintFactory constraintFactory) {
        // A student can attend at most one lesson at the same time.
        return constraintFactory.from(Plant.class)
                .join(Plant.class,
                        Joiners.equal(Plant::getTimeslot),
                        Joiners.equal(Plant::getStudentGroup),
                        Joiners.lessThan(Plant::getId))
                .penalize("Student group conflict", HardSoftScore.ONE_HARD);
    }

}
