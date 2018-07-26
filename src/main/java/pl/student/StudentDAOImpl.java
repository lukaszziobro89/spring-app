package pl.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Student processStudent(
            String firstName,
            String lastName,
            String email,
            Student theStudent,
            Model theModel){

            Session currentSession = sessionFactory.getCurrentSession();

            firstName = firstName.toUpperCase();
            lastName = lastName.toUpperCase();
            email = email.toLowerCase();

            theModel.addAttribute("firstName", firstName);
            theModel.addAttribute("lastName", lastName);
            theModel.addAttribute("email", email);

            Student student = new Student(firstName, lastName,email);
            currentSession.beginTransaction();
            currentSession.save(student);
            currentSession.getTransaction().commit();

            return student;

    }

//    @Transactional
//    @RequestMapping(value = "/processStudent")
//    public String processStudent(
//            @RequestParam("firstName") String firstName,
//            @RequestParam("lastName") String lastName,
//            @RequestParam("email") String email,
//            @Valid
//            @ModelAttribute("student") Student theStudent,
//            BindingResult theBindingResult,
//            Model theModel){
//        if (theBindingResult.hasErrors()) {
//            return "student/student-form";
//        } else {
//
//            // get the current hibernate session
//            Session currentSession = sessionFactory.getCurrentSession();
//
//            firstName = firstName.toUpperCase();
//            lastName = lastName.toUpperCase();
//            email = email.toLowerCase();
//
//            theModel.addAttribute("firstName", firstName);
//            theModel.addAttribute("lastName", lastName);
//            theModel.addAttribute("email", email);
//
//            Student student = new Student(firstName, lastName,email);
//            currentSession.beginTransaction();
//            currentSession.save(student);
//            currentSession.getTransaction().commit();
//
//            return "student/student-confirmation";
//        }
//
//    }
}
