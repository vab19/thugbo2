package is.hi.hbv501g.workoutmaker.WorkoutMaker.Services;

import is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities.User;

public interface AuthenticationService {
    //AuthToken authenticate(User user, String password);
    boolean isAuthenticated(User user);
}
