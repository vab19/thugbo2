package is.hi.hbv501g.workoutmaker.WorkoutMaker.Services;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;

import java.util.List;
import java.util.Optional;

public interface WorkoutService {

    Workout save(Workout workout);
    void delete(Workout workour);
    List<Workout> findAll();
    List<Workout> findByTitle(String title);
    Optional<Workout> findById(long id);
}
