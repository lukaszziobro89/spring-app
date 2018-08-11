package pl.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Student> getStudents() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Student> theQuery =
                currentSession.createQuery("from Student", Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return the results
        return students;
    }

    @Transactional
    public Student getStudent(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student theStudent = currentSession.get(Student.class, theId);
        return theStudent;
    }

    @Transactional
    public Student saveStudent(
            String firstName,
            String lastName,
            String email,
            Student theStudent,
            Model theModel){

            // retrieve current session
            Session currentSession = sessionFactory.getCurrentSession();

            // convert data to upper case names
            firstName = firstName.toUpperCase();
            lastName = lastName.toUpperCase();
            email = email.toLowerCase();

            // add attributes to the model
            theModel.addAttribute("firstName", firstName);
            theModel.addAttribute("lastName", lastName);
            theModel.addAttribute("email", email);

            currentSession.saveOrUpdate(theStudent);

            return theStudent;
    }

    @Transactional
    public void deleteStudent(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
        theQuery.setParameter("studentId", theId);
        theQuery.executeUpdate();
    }

//    @Transactional
    public List<Student> bulkStudentAdd(MultipartFile file) {
        BufferedReader br;
        List<String> result = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<String> invalidEntries = new ArrayList<>();
        String invalidStudent;
        String[] student;
        Student theStudent;
        boolean isValidName = false;
        boolean isValidSurname = false;
        boolean isValidEmail = false;
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
        Matcher m;

        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
                student = line.split(",");

                String name = student[0];
                String surname = student[1];
                String email = student[2];

                isValidName = name.chars().allMatch(Character::isLetter);
                isValidSurname = surname.chars().allMatch(Character::isLetter);

                m = p.matcher(email);
                if (m.find()){
                    isValidEmail = true;
                }
                    if (isValidName && name.length()>2 && isValidSurname && surname.length()>2 && isValidEmail){
                        theStudent = new Student(student[0], student[1], student[2]);
                        students.add(theStudent);
                    } else {
                       invalidStudent = name + " - " + surname + " - " + email;
                       invalidEntries.add(invalidStudent);
                    }
            }

            for (String invalidEntry : invalidEntries) {
                System.out.println(invalidEntry);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }
}
