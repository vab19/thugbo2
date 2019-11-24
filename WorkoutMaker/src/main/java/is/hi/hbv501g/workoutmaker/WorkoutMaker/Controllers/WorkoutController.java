package is.hi.hbv501g.workoutmaker.WorkoutMaker.Controllers;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Exercise;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.User;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.Workout;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.WorkoutLineItem;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.ExerciseService;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.UserService;
import is.hi.hbv501g.workoutmaker.WorkoutMaker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
public class WorkoutController {
    private ExerciseService exerciseService;
    private WorkoutService workoutService;
    private UserService userService;

    @Autowired
    public WorkoutController(ExerciseService exerciseService, WorkoutService workoutService, UserService userService){
        this.exerciseService = exerciseService;
        this.workoutService = workoutService;
        this.userService = userService;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String workoutDelete(@PathVariable long id, HttpSession session, Model model) {
        workoutService.deleteWorkout(workoutService.findWorkoutById(id).get());
        return "redirect:/";
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

    @RequestMapping(value = "/add-workout", method = RequestMethod.POST)
    public String addWorkout(@Valid Workout workout, HttpSession session, BindingResult result, Model model) {
        if(result.hasErrors()) { return "add-workout"; }
        String sessionUsername = ((User) session.getAttribute("LoggedInUser")).getUsername();
        User sessionUser = userService.findByUsername(sessionUsername);
        //ef user loggaður inn þá save-a workoutið
        if(sessionUser  != null){
            ArrayList<WorkoutLineItem> wlis = new ArrayList<>(workout.getExercises());
//            ListIterator itr = wlis.listIterator();
//            while (itr.hasNext()) {
  //              WorkoutLineItem wli1 = (WorkoutLineItem) itr.next();
    //            wli1.setWorkout(workout);
      //          itr.set(wli1);
        //        workoutService.saveAndFlushWLI(wli1);
          //  }
            for (WorkoutLineItem l: wlis) {
                Exercise ex = exerciseService.findById(l.getExId()).get();
                l.setExercise(ex);
                l.setWorkout(workout);
            }

            workout.setUser(sessionUser);
            workoutService.saveWorkout(workout);
            return "redirect:/profile";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/add-workout", method = RequestMethod.GET)
    public String addWorkoutForm(Workout workout, Model model){
        List<WorkoutLineItem> exercises = workout.getExercises();
        for (int i = 1; i <= 3; i++) {
            WorkoutLineItem wli = new WorkoutLineItem();
            wli.setWorkout(workout);
            exercises.add(wli);
        }
        workout.setExercises(exercises);
        model.addAttribute("workout", workout);
        return "add-workout"; }

}
