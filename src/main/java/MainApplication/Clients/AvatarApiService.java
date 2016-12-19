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
public class AvatarApiService{

    private static AvatarApiService INSTANCE;

    private AvatarApiService() {
    }

    public static AvatarApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AvatarApiService();
        }
        return INSTANCE;
    }


    public String getAvatarUrl(String id) throws URISyntaxException, JSONException, IOException {
        URI uri = new URIBuilder("http://localhost:60005/api/avatar/" + id).build();
        JSONObject jObject = new JSONObject(execute(uri));
        return jObject.getString("avatar_url");
    }

    private String execute(URI uri) throws IOException, URISyntaxException {
        return Request.Get(uri).execute().returnContent().asString();
    }

}
