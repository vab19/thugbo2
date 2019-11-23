package is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.*;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String workoutName;
    private String description;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;

    @ElementCollection(targetClass = WorkoutType.class)
    @Column(name="workoutType", nullable = false)
    @CollectionTable(name="workout_types", joinColumns = {@JoinColumn(name = "workout_id")})
    public Set<WorkoutType> workoutTypes;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "workout")
    private List<WorkoutLineItem> exercises = new ArrayList<>();

    public Workout() {
    }

    public Workout(User user, String workoutName, String description, Date date, HashSet<WorkoutType> workoutTypes) {
        this.user = user;
        this.workoutName = workoutName;
        this.description = description;
        this.date = date;
        this.workoutTypes = workoutTypes;
    }

    //alt + insert fyrir getter and setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public void setExercises(List<WorkoutLineItem> exercises) {
        this.exercises = exercises;
    }

    public List<WorkoutLineItem> getExercises() {
        return this.exercises;
    }

    @Override
    public String toString() {
        return this.workoutName;
    }
}
