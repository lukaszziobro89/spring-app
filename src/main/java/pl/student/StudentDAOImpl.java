package pl.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import pl.other.ListHolder;

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
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Student> theQuery =
                currentSession.createQuery("from Student", Student.class);
        List<Student> students = theQuery.getResultList();
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

    @Override
    @Transactional
    public void deleteStudent(int theID) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
        theQuery.setParameter("studentId", theID);
        theQuery.executeUpdate();
    }

    @Transactional
    public ListHolder<Student, String> bulkStudentAdd(MultipartFile file) {
        BufferedReader br;
        List<String> result = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        List<String> invalidEntries = new ArrayList<>();

        ListHolder listHolder = new ListHolder<>(students, invalidEntries);

        String invalidStudent;
        String[] student;
        Student theStudent;
        String name;
        String surname;
        String email;
        boolean isValidName;
        boolean isValidSurname;
        boolean isValidEmail;
        String nameSurnameRegex = "^[A-Za-z ']*$";
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern nameSurnamePattern = Pattern.compile(nameSurnameRegex);
        Matcher matcher;

        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
                student = line.split(",");

                isValidName = false;
                isValidSurname = false;
                isValidEmail = false;
                name = student[0];
                surname = student[1];
                email = student[2];

                    matcher = nameSurnamePattern.matcher(name);
                    if (matcher.matches()){
                        isValidName = true;
                    }

                    matcher = nameSurnamePattern.matcher(surname);
                    if (matcher.matches()){
                        isValidSurname = true;
                    }

                    matcher = emailPattern.matcher(email);
                    if (matcher.matches()){
                        isValidEmail = true;
                    }

                if (isValidName && name.length() >= 2 && isValidSurname && surname.length() >= 2 && isValidEmail){
                        theStudent = new Student(student[0], student[1], student[2]);
                        students.add(theStudent);
                    } else {
                       invalidStudent = name + " - " + surname + " - " + email;
                       invalidEntries.add(invalidStudent);
                }
            }

            if (!students.isEmpty()){
                Session currentSession = sessionFactory.getCurrentSession();
                    for (Student tempStudent : students){
                        Student temp = new Student(tempStudent.getFirstName(), tempStudent.getLastName(), tempStudent.getEmail());
                        currentSession.save(temp);
                    }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return listHolder;
    }

    @Transactional
    public ListHolder<Integer, String> bulkStudentsDelete(MultipartFile file) {
        BufferedReader br;
        List<Integer> idList = new ArrayList<>();
        List<String> incorrectIds = new ArrayList<>();
        ListHolder<Integer, String> listHolder = new ListHolder<>(idList, incorrectIds);
        Integer singleId;
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                try {
                    singleId = Integer.parseInt(line.trim());
                    idList.add(singleId);
                } catch (Exception e) {
                    incorrectIds.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        if (!idList.isEmpty()){
            StudentDAO studentDAO = new StudentDAOImpl(sessionFactory);
            for (Integer id : idList){
                studentDAO.deleteStudent(id);
            }
        }
        return listHolder;
    }

    @Override
    @Transactional
    public void truncateTable() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createNativeQuery("truncate table student");
        theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public List<Student> searchStudent(String theSearchString) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;
        if (theSearchString != null && theSearchString.trim().length() > 0) {
            theQuery =currentSession.createQuery(
                    "from Student where lower(firstName) like :theName or lower(lastName) like :theName", Student.class);
            theQuery.setParameter("theName", "%" + theSearchString.toLowerCase() + "%");
        } else {
            theQuery =currentSession.createQuery("from Student ", Student.class);
        }
        List<Student> students = theQuery.getResultList();
        return students;
    }
}
