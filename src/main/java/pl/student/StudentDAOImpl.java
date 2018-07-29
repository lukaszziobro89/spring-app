package pl.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import java.util.List;

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
    public Student getSingleStudent(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Student> theQuery =
                currentSession.createQuery("from Student s where s.id = :theId", Student.class);

        // execute query and get result list
        Student theStudent = theQuery.setParameter(theId, "id").getSingleResult();

        // return the results
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

            // save student to database
            Student student = new Student(firstName, lastName,email);
            currentSession.save(student);

            return student;
    }
}
