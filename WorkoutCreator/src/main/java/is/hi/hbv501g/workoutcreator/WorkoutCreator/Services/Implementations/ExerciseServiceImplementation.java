package is.hi.hbv501g.workoutcreator.WorkoutCreator.Services.Implementations;

import is.hi.hbv501g.workoutcreator.WorkoutCreator.Entities.Exercise;
import is.hi.hbv501g.workoutcreator.WorkoutCreator.Repositories.ExerciseRepository;
import is.hi.hbv501g.workoutcreator.WorkoutCreator.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
//business lógíkin er í services
//þegar við skrifuðum implements þá kom rauð ljósapera sem leyfði okkur að velja implements og bjó til öll föllin
public class ExerciseServiceImplementation implements ExerciseService {

    ExerciseRepository repository;

    @Autowired
    public ExerciseServiceImplementation(ExerciseRepository exerciseRepository){this.repository = exerciseRepository;}

    @Override
    public Exercise save(Exercise exercise) {
        //getum hér átt við exercise áður en það er save-að í gagnagrunninn
        return repository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        repository.delete(exercise);
    }

    @Override
    public List<Exercise> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Exercise> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Exercise> findByName(String name) {
        return repository.findByName(name);
    }
}
