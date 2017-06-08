package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * For sending requests to appropriate URL and wait for response
 */
public class HttpRequest {
    public static final String USER_AGENT = "Mozilla/5.0";


    /**
     * Send GET request
     *
     * @param url - URL
     * @return {String} response
     * @throws Exception - if server response without HTTP code "OK" 200
     */

    public static String sendGet(String url) throws Exception {
        URL urlObj = new URL(url);



        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();



        //set header and method
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);



        //if server response not OK
        if (con.getResponseCode() != 200) throw new Exception("Server response isn't OK!");



        //read response
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        return response.toString();
    }
}
