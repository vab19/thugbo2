package is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkoutLineItemRepository extends JpaRepository<WorkoutLineItem, Long> {
    WorkoutLineItem save(WorkoutLineItem wli);
    void delete(WorkoutLineItem wli);
    void deleteAll();
    Optional<WorkoutLineItem> findById(long id);
}
