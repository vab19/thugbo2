package is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories;


import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout save(Workout workout);
    void delete(Workout workour);
    List<Workout> findAll();
    List<Workout> findByTitle(String title);
    Optional<Workout> findById(long id);
}
