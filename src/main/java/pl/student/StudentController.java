package pl.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.other.ListHolder;

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

    @RequestMapping(value = "/showStudents")
    public String getStudents(Model theModel) {
        List<Student> theStudents = studentDAO.getStudents();
        theModel.addAttribute("student", theStudents);
        return "studentsList";
    }

    @RequestMapping(value = "processStudent")
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
            theStudent = studentDAO.saveStudent(firstName, lastName, email, theStudent, theModel);
            theModel.addAttribute("student", theStudent);
            return "student/student-confirmation";
        }
    }

    @GetMapping(value = "showUpdateForm")
    public String updateStudent(@RequestParam("studentId") int theId, Model theModel){
        Student theStudent = studentDAO.getStudent(theId);
        theModel.addAttribute("student", theStudent);
        return "student/student-form";
    }

    @GetMapping(value = "delete")
    public String deleteStudent(@RequestParam("studentId") int theId){
        studentDAO.deleteStudent(theId);
        return "redirect:/showStudents";
    }

    @RequestMapping(value = "showBulkAddForm")
    public String showBulkAddForm() {
        return "student/bulkLoadStudents";
    }

    @RequestMapping(value = "bulkAddStudents", method = RequestMethod.POST)
    public String bulkAddStudents(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        ListHolder<Student, String> listHolder = studentDAO.bulkStudentAdd(file);
        modelMap.addAttribute("correctEntries", listHolder.getListOfCorrectEntries());
        modelMap.addAttribute("incorrectEntries", listHolder.getListOfIncorrectEntries());
        return "student/bulkLoadConfirmation";
    }

    @RequestMapping(value = "bulkStudentsDelete", method = RequestMethod.POST)
    public String bulkStudentsDelete(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        ListHolder<Integer, String> listHolder = studentDAO.bulkStudentsDelete(file);
        modelMap.addAttribute("correctEntries", listHolder.getListOfCorrectEntries());
        modelMap.addAttribute("incorrectEntries", listHolder.getListOfIncorrectEntries());
        return "student/bulkDeleteConfirmation";
    }

    @RequestMapping(value = "truncateStudentTable")
    public String truncateStudentTable() {
        studentDAO.truncateTable();
        return "redirect:/showStudents";
    }
}
