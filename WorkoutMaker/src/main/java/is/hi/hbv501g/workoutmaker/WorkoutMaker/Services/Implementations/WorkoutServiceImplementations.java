package is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.Implementations;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Repositories.WorkoutRepository;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutServiceImplementations implements WorkoutService {

    WorkoutRepository repository;

    @Autowired
    public WorkoutServiceImplementations(WorkoutRepository workoutRepository){this.repository = workoutRepository;}

    @Override
    public Workout save(Workout workout) {
        return repository.save(workout);
    }

    @Override
    public void delete(Workout workout) {
        repository.delete(workout);
    }

    @Override
    public List<Workout> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Workout> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Optional<Workout> findById(long id) {
        return repository.findById(id);
    }
}
