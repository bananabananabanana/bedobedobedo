package rf.vdolgu.controller;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rf.vdolgu.dao.UserDAO;
import rf.vdolgu.dao.UserDAOImpl;
import rf.vdolgu.model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@Controller
@RequestMapping("/login")
public class LoginController implements Serializable {

    private final String USER_AGENT = "Mozilla/5.0";

    public LoginController(){
        System.out.println("LoginController");
    }


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, params="code")
    public String getCode(@RequestParam("code") String code) throws Exception {
        System.out.println(code);
        if (code != null) {
            try {
                String ResponseCode = sendGet(code);
                System.out.println("print result after sendGet: " + ResponseCode);

                //insert JSON serialaized
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(ResponseCode);
                JSONObject jsonObj = (JSONObject) obj;

                String access_token = jsonObj.get("access_token").toString();
                String user_id = jsonObj.get("user_id").toString();

                System.out.println("print access_token: " + access_token);
                System.out.println("print user_id: " + user_id);

                User user = new User();
                user.setFirstName("banana");
                user.setLastName("banana2");
                user.setPatranomic("banana3");
                user.setDateCreate(new Date());

                UserDAO userDAO = new UserDAOImpl();
                userDAO.insertUser(user);
                System.out.println(user.getFirstName() + "is create");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "index";
    }

    // HTTP GET request
    private String sendGet(String code) throws Exception {

        String url = "https://oauth.vk.com/access_token?" +
                "client_id=4859620&" +
                "client_secret=7XNY4yQYAfVatUse3ejy&" +
                "code=" + code + "&" +
                "redirect_uri=http://xn--b1acc2ao6a.xn--p1ai";

        System.out.println(url);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println("print result: " + response.toString());
        return response.toString();
    }

}