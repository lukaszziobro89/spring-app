package pl.student;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "student")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @Valid
    @NotBlank(message = "Field cannot be blank.")
    @Size(min = 2, message = "At least 2 characters required.")
    private String firstName;

    @Column(name = "last_name")
    @Valid
    @NotBlank(message = "Field cannot be blank.")
    @Size(min = 2, message = "At least 2 characters required.")
    private String lastName;

    @Column(name = "email")
    @Valid
    @NotBlank(message = "Field cannot be blank.")
    @Email(message = "Valid email address required.")
    @Size(min = 2, message = "At least 2 characters required.")
    private String email;

    public Student(){}

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
