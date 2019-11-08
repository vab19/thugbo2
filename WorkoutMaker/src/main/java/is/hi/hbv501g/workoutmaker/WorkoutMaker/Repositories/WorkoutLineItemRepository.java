package is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutLineItemRepository extends JpaRepository<WorkoutLineItem, Long> {
    WorkoutLineItem saveWLI(WorkoutLineItem wli);
    void deleteWLI(WorkoutLineItem wli);
    void deleteAll();
}
