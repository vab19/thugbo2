package is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String workoutName;
    private String description;
    private Date date;
    //private ArrayList<WorkoutLineItem>;
    //add private enum Wtype workoutType

    public Workout() {
    }

    public Workout(String workoutName, String description, Date date) {
        this.workoutName = workoutName;
        this.description = description;
        this.date = date;
    }

    //alt + insert fyrir getter and setter
    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
