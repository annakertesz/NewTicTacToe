package MainApplication.Clients;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/4/16.
 */
public class GameApiService {

    private static GameApiService INSTANCE;

    public static GameApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameApiService();
        }
        return INSTANCE;
    }

    public static String getState(String place) throws IOException, URISyntaxException, JSONException {
        System.out.println("COMMENT - " + place);
        URI uri = new URIBuilder("http://localhost:60000/api/state?place=" + place).build();
        JSONObject jObject = new JSONObject(execute(uri));
        return jObject.getString("recommendation");
    }

    private static String execute(URI uri) throws IOException, URISyntaxException {
        return Request.Get(uri).execute().returnContent().asString();
    }

}