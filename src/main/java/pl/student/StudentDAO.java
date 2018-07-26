package pl.student;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();
    String processStudent(String firstName,
                          String lastName,
                          String email,
                          Student theStudent,
//                          BindingResult theBindingResult,
                          Model theModel);
}
