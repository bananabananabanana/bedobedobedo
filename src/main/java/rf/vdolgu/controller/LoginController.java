package rf.vdolgu.controller;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rf.vdolgu.model.Token;
import rf.vdolgu.model.User;
import rf.vdolgu.service.TokenService;
import rf.vdolgu.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created by Vano on 17.05.2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private final String USER_AGENT = "Mozilla/5.0";

    @Autowired
    UserService userService;


    @Autowired
    TokenService tokenService;

    public LoginController(){
        System.out.println("LoginController");
    }


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, params="code")
    public String getCode(@RequestParam("code") String code) throws Exception {

        Integer idUser = null;

        System.out.println(code);
        if (code != null) {
            try {

                String ResponseCode;
                JSONObject jsonObj;

                ResponseCode = getAccessToken(code);
                jsonObj = serialaized(ResponseCode);

                String access_token = jsonObj.get("access_token").toString();
                String user_id = jsonObj.get("user_id").toString();

                ResponseCode = getUserVk(Integer.parseInt(user_id));
                jsonObj = serialaized(ResponseCode);


                String response = jsonObj.get("response").toString();

                response = response.substring(1, response.length()-1);

                System.out.println("==="+response);


                jsonObj = serialaized(response);

                String first_name = (String) jsonObj.get("first_name");
                String last_name = (String) jsonObj.get("last_name");
                String photo_50 = (String) jsonObj.get("photo_50");
                //String patranomic = jsonObj.get("patranomic").toString();

                //System.out.println(first_name+" = "+last_name);

                //New User for insert into DB
                User user = new User();
                user.setFirstName(first_name);
                user.setLastName(last_name);
                user.setPatranomic("patranomic");
                user.setDateCreate(new Date());
                user.setIdVk(Integer.parseInt(user_id));
                user.setImage(photo_50);
                user.setRating(1.5);

                System.out.println(user);
                idUser = userService.insertUser(user);

                System.err.println("id user=" + idUser);

                System.out.println(user.getFirstName() + " user is create");


                //New Token for insert into DB
                Token token = new Token();
                token.setIdUser(idUser);
                token.setToken(access_token);
                token.setDateCreate(new Date());
                token.setUserAgent("ggg");


                tokenService.insertToken(token);

                System.out.println(token.getToken() + " token is create");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "index";
    }

    // serialaized JSON
    public JSONObject serialaized(String ResponseCode) throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(ResponseCode);
        return (JSONObject) obj;
    }


    // getAccessToken
    private String getAccessToken(String code) throws Exception {

        String url = "https://oauth.vk.com/access_token?" +
                "client_id=4859620&" +
                "client_secret=7XNY4yQYAfVatUse3ejy&" +
                "code=" + code + "&" +
                "redirect_uri=http://xn--b1acc2ao6a.xn--p1ai";

        return send(url);

    }

    //getUserVk
    private String getUserVk(Integer idVk) throws Exception {

        String url = "https://api.vk.com/method/users.get?" +
                "user_ids=" + idVk + "&" +
                "fields=photo_50";

        return send(url);

    }

    //send
    private String send(String url) throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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
