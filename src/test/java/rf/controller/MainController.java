package rf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*import rf.dao.UserDAO;
import rf.dao.UserDAOImpl;*/

@Controller
@RequestMapping("/main")
public class MainController {
/*
    public MainController(){
        System.out.println("MainController");
    }

    UserDAO userDAO = new UserDAOImpl();

    @RequestMapping(value = {"/", "/friend**"}, method = RequestMethod.GET)
    public String friend() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model.getViewName();
        //return "index";
    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getData() {
        return userDAO.getAllUsers();
    }*/

/*    @RequestMapping(value = "/getData", method = RequestMethod.POST)
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

/*    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public String getUser(@PathVariable("user") String user) {
        System.out.println(user);
        return "index";
    }*/
}