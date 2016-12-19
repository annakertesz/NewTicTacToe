package GreetingGeneratorService.Client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 * Created by annakertesz on 12/18/16.
 */
public class ApiService {

    private static ApiService INSTANCE;

    public ApiService() {
    }


    public static ApiService getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new ApiService();
            }
            return INSTANCE;
        }


    public String random() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://yoda.p.mashape.com/yoda?sentence=You+will+learn+how+to+speak+like+me+someday.++Oh+wait.")
                .header("X-Mashape-Key", "eEd3qMRPXzmshWfwtfBvEHFU5phSp12jR2BjsnQfYUSgqbZceO")
                .header("Accept", "text/plain")
                .asString();
        JSONObject myObject = new JSONObject(response);
        return String.valueOf(myObject);

    }

}
