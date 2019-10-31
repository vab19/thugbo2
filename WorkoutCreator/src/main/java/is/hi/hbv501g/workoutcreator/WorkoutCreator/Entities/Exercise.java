package is.hi.hbv501g.workoutcreator.WorkoutCreator.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //búa til entity: hafa þetta @entity og svo tvo constructora, einn tómann og einn með gildum
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private int bodypart;

    public Exercise() { //þarf alltaf að vera tómur smiður fyrir entity
    }
    //alt+(fn)+insert = til fá upp Generate


    public Exercise(String name, String description, int bodypart) {
        this.name = name;
        this.description = description;
        this.bodypart = bodypart;
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

    public int getBodypart() {
        return bodypart;
    }

    public void setBodypart(int bodypart) {
        this.bodypart = bodypart;
    }
}
