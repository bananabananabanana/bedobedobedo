package rf.vdolgu.controller;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequestMapping("/")
public class MainController implements Serializable {

    private final String USER_AGENT = "Mozilla/5.0";

    public MainController(){
        System.out.println("MainController");
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
                System.out.println(ResponseCode);

                //insert JSON serialaized (нада спросить)
                //
                // JSONParser parser = new JSONParser();

                //Object obj = parser.parse(ResponseCode);
                //JSONObject jsonObj = (JSONObject) obj;
                //System.out.println(jsonObj.get("paramsStr"));
                //System.out.println(obj);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "index";
    }

    // HTTP GET request
    private String sendGet(String code) throws Exception {
        String url = "https://oauth.vk.com/access_token?" +
                "client_id=4877168&" +
                "client_secret=MFA0tWhWgY5SnvO1hSBm&" +
                "code=" + code + "&" +
                "redirect_uri=http://vdolgu.mil3.bget.ru";

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
        System.out.println(response.toString());
        return response.toString();
    }

}