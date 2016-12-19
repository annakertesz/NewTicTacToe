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
public class JokeApiService  {

    private static JokeApiService INSTANCE;

    private JokeApiService() {
    }

    public static JokeApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JokeApiService();
        }
        return INSTANCE;
    }

    public String getJoke() throws URISyntaxException, JSONException, IOException {
        URI uri = new URIBuilder("http://localhost:60001/api/random").build();
        JSONObject jObject = new JSONObject(execute(uri));
        String joke = jObject.getString("facts");
        return joke.substring(2, joke.length()-2);
    }

    private String execute(URI uri) throws IOException {
        return Request.Get(uri).execute().returnContent().asString();
    }

}
