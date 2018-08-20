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
    default void deleteStudent(int theID){};

    /** Adds students in bulk */
    ListHolder<Integer, String> bulkStudentsDelete(MultipartFile file);

    /** Remove students in bulk using IDs */
    ListHolder<Student, String> bulkStudentAdd(MultipartFile file);

    /** Truncates/removes all rows from Student table */
    void truncateTable();

    /** Search student by name/surname **/
    List<Student> searchStudent(String searchString);

}
