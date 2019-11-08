package is.hi.hbv501g.workoutmaker.WorkoutMaker.Services;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutType;

import java.util.List;
import java.util.Optional;

public interface WorkoutService {
    Workout saveWorkout(Workout workout);
    WorkoutLineItem saveWLI(WorkoutLineItem wli);
    void deleteWorkout(Workout workout);
    void deleteWLI(WorkoutLineItem wli);
    void deleteAllWorkouts();
    void deleteAllWLI();
    Workout addToWorkout(long workoutId, WorkoutLineItem workoutLineItem);
    Workout rmFromWorkout(long workoutId, int lineNumber);
    WorkoutLineItem setExerciseReps(WorkoutLineItem wli, int reps);
    WorkoutLineItem setExerciseSets(WorkoutLineItem wli, int sets);
    List<Workout> findAll();
    List<Workout> findByWorkoutName(String workoutName);
    Optional<Workout> findById(long id);
    List<Workout> findByWorkoutType(WorkoutType workoutType);
}
