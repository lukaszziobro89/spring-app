package pl.student;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import pl.other.ListHolder;

import java.util.List;

public interface StudentDAO {

    /** Return single student */
    Student getStudent(int id);

    /** Return list of students  */
    List<Student> getStudents();

    /** Add new student to database */
    Student saveStudent(String firstName,
                        String lastName,
                        String email,
                        Student theStudent,
                        Model theModel);

    /** Add new student to database */
    void deleteStudent(int theId);

    /** Adds students in bulk */
    ListHolder<Student, String> bulkStudentAdd(MultipartFile file);
}
