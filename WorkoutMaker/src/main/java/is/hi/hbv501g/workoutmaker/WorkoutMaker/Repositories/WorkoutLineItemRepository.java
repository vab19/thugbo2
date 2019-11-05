package is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutLineItemRepository extends JpaRepository<WorkoutLineItem, Long> {
    WorkoutLineItem save(WorkoutLineItem wli);
    void delete(WorkoutLineItem wli);
    void deleteAll();
}
