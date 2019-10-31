package is.hi.hbv501g.workoutcreator.WorkoutCreator.Repositories;


import is.hi.hbv501g.workoutcreator.WorkoutCreator.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
    List<Exercise> findAll();
    List<Exercise> findByName(String name);
    Optional<Exercise> findById(long id);
    //@Query("SELECT * FROM tafla")
    //fallið hér fyrir neðan
}
