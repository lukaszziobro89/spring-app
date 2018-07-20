package pl.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@Controller
public class StudentController {

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

    @RequestMapping(value = "/processStudent")
    public String processStudent(
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

            firstName = firstName.toUpperCase();
            lastName = lastName.toUpperCase();
            email = email.toLowerCase();

            theModel.addAttribute("firstName", firstName);
            theModel.addAttribute("lastName", lastName);
            theModel.addAttribute("email", email);

            SessionFactory factory;
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);
            Session session = factory.getCurrentSession();

            // connection details
            String jdbcURL = "jdbc:mysql://sql.lukaszziobro.nazwa.pl:3306/lukaszziobro_javaspring?useSSL=false";
            String user = "lukaszziobro_javaspring";
            String pass = "London.11";

            try{
                System.out.println("Connecting...");
                Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
                System.out.println("connected");

            } catch (Exception ex){
                ex.printStackTrace();
            }
//
            try {
                System.out.println("Creating new student...");
                Student student = new Student(firstName, lastName,email);
                session.beginTransaction();
                System.out.println("Saving student...");
                session.save(student);
                session.getTransaction().commit();
                System.out.println("Done!");
            }catch (Exception exc){
                exc.printStackTrace();
            }finally {
                factory.close();
            }

            return "student/student-confirmation";
        }

    }

    @RequestMapping(value = "/showStudents", method = RequestMethod.GET)
    public String showTable(Model theModel){

        SessionFactory factory;
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.getCurrentSession();

        String jdbcURL = "jdbc:mysql://sql.lukaszziobro.nazwa.pl:3306/lukaszziobro_javaspring?useSSL=false";
        String user = "lukaszziobro_javaspring";
        String pass = "London.11";

        try{
            System.out.println("Connecting...");
            Connection connection = DriverManager.getConnection(jdbcURL, user, pass);

            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student").list();
            session.getTransaction().commit();

            theModel.addAttribute("studentsLists",theStudents);

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            factory.close();
        }

        return "table";
    }


}
