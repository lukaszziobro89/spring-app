package pl.student;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();
    Student processStudent(String firstName,
                          String lastName,
                          String email,
                          Student theStudent,
                          Model theModel);
}
