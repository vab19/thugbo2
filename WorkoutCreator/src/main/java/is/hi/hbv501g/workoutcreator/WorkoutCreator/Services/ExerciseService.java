package is.hi.hbv501g.workoutcreator.WorkoutCreator.Services;

import is.hi.hbv501g.workoutcreator.WorkoutCreator.Entities.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
    List<Exercise> findAll();
    Optional<Exercise> findById(long id);
    List<Exercise> findByName(String name);
}
