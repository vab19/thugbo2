package is.hi.hbv501g.workoutcreator.WorkoutCreator;

import is.hi.hbv501g.workoutcreator.WorkoutCreator.Entities.Exercise;
import is.hi.hbv501g.workoutcreator.WorkoutCreator.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    private ExerciseService exerciseService;
    @Autowired
    public HomeController(ExerciseService exerciseService){this.exerciseService = exerciseService;}

    @RequestMapping("/")
    public String Home(Model model) {
        model.addAttribute("exercises", exerciseService.findAll()); //sendum gögn svona inn í HTML
        return "Velkominn"; //html skjal sem heitir Velkominn
    }

    @RequestMapping(value="/addexercise", method = RequestMethod.POST)
    public String addExercise(@Valid Exercise exercise, BindingResult result, Model model) {
        if(result.hasErrors()) {
            //model.addAttribute("error"); einhver villu skilaboð
            return "add-exercise";
        }
        exerciseService.save(exercise);
        model.addAttribute("exercises", exerciseService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value="/addexercise", method = RequestMethod.GET)
    public String addExerciseForm(Model model) {
        return "add-exercise"; //ef einhver fer inn á add exercise linkinn á er skilað þessu HTML skjali, eitthvað form
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteExercise(@PathVariable("id") long id, Model model) {
        Exercise exercise = exerciseService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid exercise ID"));
        exerciseService.delete(exercise);
        model.addAttribute("exercises", exerciseService.findAll());
        return "Velkominn";
    }

    @RequestMapping("login")
    public String LoginPage(){
        return "loginPage";
    }
}
