package pl.other;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloUserController {

    @RequestMapping(value = "/showForm")
    public String showForm(){
        return "hellouser-form";
    }

    @RequestMapping(value = "/processUserForm")
    public String processUserForm(){
        return "helloUser";
    }

    @RequestMapping(value = "/processUserFormUpperCase")
    public String processUserFormUpperCase(HttpServletRequest request, Model model){
        String theName = request.getParameter("userName");
        theName = theName.toUpperCase();
        String result = "Hi ".concat(theName).concat("!");
        model.addAttribute("message", result);
        return "showMessage";
    }

    @RequestMapping(value = "/showDayName")
    public String showWeekdayName(
            @RequestParam("weekNumber") Integer weekNumber,
            Model model){
        String dayName;
        switch (weekNumber){
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            case 4: dayName = "Thursday"; break;
            case 5: dayName = "Friday"; break;
            case 6: dayName = "Saturday"; break;
            case 7: dayName = "Sunday"; break;
            default: dayName = "Incorrect day number.";
        }
        model.addAttribute("message", dayName);
        return "showMessage";
    }

}
