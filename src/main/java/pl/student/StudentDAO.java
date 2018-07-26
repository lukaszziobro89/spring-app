package pl.student;

import org.springframework.ui.Model;
import java.util.List;

public interface StudentDAO {
    /** Return list of students  */
    List<Student> getStudents();

    /** Add new student to database */
    Student saveStudent(String firstName,
                        String lastName,
                        String email,
                        Student theStudent,
                        Model theModel);
}
