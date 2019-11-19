package is.hi.hbv501g.workoutmaker.WorkoutMaker.Controllers;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.User;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.ExerciseService;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class WorkoutController {
    private ExerciseService exerciseService;
    private WorkoutService workoutService;

    @Autowired
    public WorkoutController(ExerciseService exerciseService, WorkoutService workoutService){
        this.exerciseService = exerciseService;
        this.workoutService = workoutService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String workoutGET(HttpSession session, Model model){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser  != null){
            model.addAttribute("workouts", workoutService.findByUser(sessionUser));
            return "profile";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/addworkout", method = RequestMethod.POST)
    public String addWorkout(@Valid Workout workout, BindingResult result, Model model) {
        if(result.hasErrors()) { return "add-workout"; }
        //workout.setUser(sessionuser); tjékka fyrst hvort user loggaður
        workoutService.saveWorkout(workout);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/addworkout", method = RequestMethod.GET)
    public String addWorkoutForm(Workout workout){ return "add-workout"; }

}
