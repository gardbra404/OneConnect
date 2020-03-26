package com.oneconnect.OneConnect;

<<<<<<< HEAD
=======
import com.oneconnect.OneConnect.Course.CourseService;
>>>>>>> 4e83656bd26f6ba62a1633e772987386b405f2ca
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelpController {
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getHelp(@RequestParam String role) {
<<<<<<< HEAD

        System.out.println("sending a help page");

=======
>>>>>>> 4e83656bd26f6ba62a1633e772987386b405f2ca
        ModelAndView modelAndView = new ModelAndView();
        switch (role) {
            case ("parent"):
                modelAndView.setViewName("helpParent");
                break;
            case ("admin"):
                modelAndView.setViewName("helpAdmin");
                break;
            case ("student"):
                modelAndView.setViewName("helpStudent");
                break;
            case ("teacher"):
                modelAndView.setViewName("helpTeacher");
                break;
            default:
                modelAndView.setViewName("forbidden");
                break;
        }

        return modelAndView;
    }
}
