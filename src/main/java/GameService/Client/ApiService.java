package GameService.Client;

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

    private static ApiService INSTANCE;


    public static ApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiService();
        }
        return INSTANCE;
    }


    public String getResponse(String state) throws URISyntaxException, JSONException, IOException {
        URI uri = new URIBuilder("http://tttapi.herokuapp.com/api/v1/" + state + "/O").build();
        return (execute(uri));
    }

    private String execute(URI uri) throws IOException {
        return Request.Get(uri).execute().returnContent().asString();
    }
}
