package pl.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    /**
     *  Init binder makes sure that not white spaces are submitted in form.
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/addStudent")
    public String addStudent(Model theModel){
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "student/student-form";
    }

    @RequestMapping(value = "/showStudents", method = RequestMethod.GET)
    public String getStudents(Model theModel) {

        List<Student> theStudents = studentDAO.getStudents();
        theModel.addAttribute("student", theStudents);
        return "studentsList";
    }

    @RequestMapping(value = "/processStudent", method = RequestMethod.POST)
    public String saveStudent(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @Valid
            @ModelAttribute("student") Student theStudent,
            BindingResult theBindingResult,
            Model theModel){
        if (theBindingResult.hasErrors()) {
            return "student/student-form";
        } else {

            Student student = studentDAO.saveStudent(firstName, lastName, email, theStudent, theModel);
            theModel.addAttribute("student", student);

            return "student/student-confirmation";
        }
    }
}
