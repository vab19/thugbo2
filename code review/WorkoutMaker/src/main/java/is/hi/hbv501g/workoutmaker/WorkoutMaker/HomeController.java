package is.hi.hbv501g.workoutmaker.WorkoutMaker;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    private WorkoutService workoutService;
    @Autowired
    public HomeController(WorkoutService workoutService){this.workoutService = workoutService;}

    @RequestMapping("/")
    public String Home(Model model){
        model.addAttribute("workouts", workoutService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value = "/add-workout", method = RequestMethod.POST)
    public String addWorkout(@Valid Workout workout, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "add-workout";
        }
        workoutService.save(workout);
        model.addAttribute("workouts", workoutService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value="/add-workout", method = RequestMethod.GET)
    public String addWorkoutForm(Model model){
        return "add-workout";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") long id, Model model){
        Workout workout = workoutService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid workout ID"));
        workoutService.delete(workout);
        model.addAttribute("workout", workoutService.findAll());
        return "Velkominn";
    }

    @RequestMapping("login")
    public String LoginPage(){
        return "LoginPage";
    }
}
