package is.hi.hbv501g.workoutmaker.WorkoutMaker.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @MapsId
    private WorkoutLineItem wli;

    public String name;
    public String description;

    @ElementCollection(targetClass = Category.class)
    @Column(name="category", nullable = false)
    @CollectionTable(name="exercise_categories", joinColumns = {@JoinColumn(name = "exercise_id")})
    public Set<Category> categories;

    public Exercise() {
    }

    public Exercise(String name, WorkoutLineItem wli, String description, HashSet<Category> categories) {
        this.name = name;
        this.wli = wli;
        this.description = description;
        this.categories = categories;
    }

    public WorkoutLineItem getWli() {
        return wli;
    }

    public void setWli(WorkoutLineItem wli) {
        this.wli = wli;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
