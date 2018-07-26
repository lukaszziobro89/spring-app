package pl.student;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();
    String processStudent(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email,
                          @Valid
                          @ModelAttribute("student") Student theStudent,
                          BindingResult theBindingResult,
                          Model theModel);
}
