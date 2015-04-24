package rf.vdolgu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rf.vdolgu.dao.UserDAO;
import rf.vdolgu.dao.UserDAOImpl;
import rf.vdolgu.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    public MainController(){
        System.out.println("MainController");
    }

    UserDAO userDAO = new UserDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/friend", method = RequestMethod.GET)
    public String friend() {
        return "index";
    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ResponseBody
    public String getData() {
        //return userDAO.getAllUsers();
        return "[{" +
                "                \"id\": 1,\n" +
                "                \"image\": \"http://placehold.it/40x40\",\n" +
                "                \"fullname\": \"Друг 1\",\n" +
                "                \"rating\": 123,\n" +
                "                \"vkid\": 1639840" +
                "}]";
    }

/*    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public String getUser(@PathVariable("user") String user) {
        System.out.println(user);
        return "index";
    }*/
}