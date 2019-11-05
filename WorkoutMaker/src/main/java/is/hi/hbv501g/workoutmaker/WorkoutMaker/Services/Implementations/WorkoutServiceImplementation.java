package is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.Implementations;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutType;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories.WorkoutLineItemRepository;
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
public class WorkoutServiceImplementation implements WorkoutService {

    WorkoutRepository workoutRepository;
    WorkoutLineItemRepository workoutLineItemRepository;

    @Autowired
    public WorkoutServiceImplementation(WorkoutRepository workoutRepository, WorkoutLineItemRepository wliRepository){
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
        List<WorkoutLineItem> exerciseList = workout.getExercises();
        exerciseList.add(wli);
        workout.setExercises(exerciseList);
    }

    @Override
    public void rmFromWorkout(long workoutId, int lineNumber) {
        Workout workout = workoutRepository.findById(workoutId).get();
        List<WorkoutLineItem> exerciseList = workout.getExercises();
        exerciseList.remove(lineNumber);
    }

    @Override
    public void setExerciseReps(Workout workout, int lineNumber, int reps) {
        List<WorkoutLineItem> exerciseList = workout.getExercises();
        WorkoutLineItem wli = exerciseList.get(lineNumber);
        wli.setReps(reps);
    }

    @Override
    public void setExerciseSets(Workout workout, int lineNumber, int sets) {
        List<WorkoutLineItem> exerciseList = workout.getExercises();
        WorkoutLineItem wli = exerciseList.get(lineNumber);
        wli.setSets(sets);
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

    @Override
    public List<Workout> findByWorkoutType(WorkoutType workoutType) {
        return workoutRepository.findByWorkoutType(workoutType);
    }
}
