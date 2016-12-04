package JokeService.Client;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/4/16.
 */
public class ApiService {

    public static String getJoke() throws URISyntaxException, JSONException, IOException {
        URI uri = new URIBuilder("http://catfacts-api.appspot.com/api/facts").build();
//        JSONObject jObject = new JSONObject(execute(uri));
        return execute(uri);
    }

    private static String execute(URI uri) throws IOException {
        return Request.Get(uri).execute().returnContent().asString();
    }
}
