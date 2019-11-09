package is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories;


import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Workout save(Workout workout);
    void delete(Workout workout);
    void deleteAll();
    List<Workout> findAll();
    List<Workout> findByWorkoutName(String workoutName);
    Optional<Workout> findById(long id);
    //List<Workout> findByWorkoutType(WorkoutType workoutType);
    boolean existsById (long id);
    boolean existsByWorkoutName (String workoutName);

}
