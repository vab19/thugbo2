package is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.Implementations;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories.WorkoutRepository;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//(högni freyr gunnarson, þorsteinn oskarsson, sunneva þorsteinsdóttir, helga þöll guðjónsdóttir)22 reviewar okkur og við reviewum 30
//30 = (sigursteinn pálsson, anton h. heimdal, tómas tryggvason, una rúnarsdóttirí )
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutServiceImplementations implements WorkoutService {

    WorkoutRepository workoutRepository;
    WorkoutLineItemRepository workoutLineItemRepository;

    @Autowired
    public WorkoutServiceImplementations(WorkoutRepository workoutRepository, WorkoutLineItemRepository wliRepository){
        this.workoutRepository = workoutRepository;
        this.workoutLineItemRepository = wliRepository;
    }

    @Override
    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public void delete(Workout workout) {
        workoutRepository.delete(workout);
    }

    @Override
    public void deleteAll() {workoutRepository.deleteAll();}

    @Override
    public void addToWorkout(long workoutId, WorkoutLineItem wli) {
        Workout workout = workoutRepository.findById(workoutId).get();
        List<WorkoutLineItem> workoutList = workout.getExercises();
        workoutList.add(wli);
        workout.setExercises(workoutList);
    }

    @Override
    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    @Override
    public List<Workout> findByWorkoutName(String workoutName) {
        return workoutRepository.findByWorkoutName(workoutName);
    }

    @Override
    public Optional<Workout> findById(long id) {
        return workoutRepository.findById(id);
    }
}
