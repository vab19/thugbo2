package is.hi.hbv501g.workoutmaker.WorkoutMaker.Services;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutType;

import java.util.List;
import java.util.Optional;

public interface WorkoutService {
    Workout save(Workout workout);
    void delete(Workout workout);
    void deleteAll();
    void addToWorkout(long workoutId, WorkoutLineItem workoutLineItem);
    void rmFromWorkout(Workout workout, int lineNumber);
    void setExerciseReps(Workout workout, WorkoutLineItem workoutLineItem, int reps);
    void setExerciseSets(Workout workout, WorkoutLineItem workoutLineItem, int sets);
    List<Workout> findAll();
    List<Workout> findByWorkoutName(String workoutName);
    Optional<Workout> findById(long id);
    List<Workout> findByWorkoutType(WorkoutType workoutType);
}
