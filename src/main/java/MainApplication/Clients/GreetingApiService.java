package MainApplication.Clients;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/18/16.
 */
public class GreetingApiService {

    private static GreetingApiService INSTANCE;



    private GreetingApiService() {
    }

    public static GreetingApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GreetingApiService();
        }
        return INSTANCE;
    }

    public String getGreeting() throws IOException, URISyntaxException, JSONException {
        URI uri = new URIBuilder("http://localhost:60003/api/greeting").build();
        JSONObject jObject = new JSONObject(execute(uri));
        return jObject.getString("body");
    }

    private String execute(URI uri) throws IOException, URISyntaxException {
        return Request.Get(uri).execute().returnContent().asString();
    }

}



