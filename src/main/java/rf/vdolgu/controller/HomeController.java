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
@RequestMapping("/home")
public class HomeController {

    public HomeController(){
        System.out.println("HomeController");
    }

    UserDAO userDAO = new UserDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getData() {
        return userDAO.getAllUsers();
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public String getUser(@PathVariable("user") String user) {
        System.out.println(user);
        return "index";
    }
}