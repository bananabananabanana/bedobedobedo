package rf.vdolgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import rf.vdolgu.dao.UserDao;
import rf.vdolgu.model.User;

import java.util.List;

/**
 * Created by Vano on 17.05.2015.
 */

@Controller
@RequestMapping("/main")
public class MainController {

    public MainController(){
        System.out.println("MainController");
    }

    @Autowired
    UserDao userDao;


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value =  "/friend**", method = RequestMethod.GET)
    public String friend() {
        return "index";
    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getData() {
        return userDao.getAllUsers();
    }

 /*   @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ResponseBody
    public String getData() {
        return "[{" +
                "                \"id\": 1,\n" +
                "                \"image\": \"http://placehold.it/40x40\",\n" +
                "                \"fullname\": \"Друг 1\",\n" +
                "                \"rating\": 123,\n" +
                "                \"vkid\": 1639840" +
                "}]";
    }*/




}
