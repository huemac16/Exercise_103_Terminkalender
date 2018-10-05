
import java.awt.Color;
import java.time.LocalDate;

public class Student {

    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private Color hairColor;

    public Student(String firstName, String lastName, LocalDate birthday, Color hairColor) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.birthday = birthday;
        this.hairColor = hairColor;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Color getHairColor() {
        return hairColor;
    }

}
