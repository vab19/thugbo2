package is.hi.hbv501g.workoutmaker.WorkoutMaker.Controllers;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.AuthenticationService;
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

    //private WorkoutService workoutService;
    private AuthenticationService authenticationService;

    @Autowired
    public HomeController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(Model model){
        //model.addAttribute("workouts", workoutService.findAll());
        return "Velkominn";
    }
    /* á ekki við hjá okkur, homepage-ið okkar verður eiginlega bara tóm síða með link á log-in page
    @RequestMapping(value = "/addworkout", method = RequestMethod.POST)
    public String addWorkout(@Valid Workout workout, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "add-workout";
        }
        Workout savedWorkout = workoutService.saveWorkout(workout);
        model.addAttribute("workouts", workoutService.findAll());
        return "Velkominn";
    }

    //til að fá formið
    @RequestMapping(value="/addworkout", method = RequestMethod.GET)
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
    */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String LoginPage(){
        return "LoginPage";
    }
}
