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
public class GratulationApiService {

        private static GratulationApiService INSTANCE;

        private GratulationApiService() {
        }

        public static GratulationApiService getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new GratulationApiService();
            }
            return INSTANCE;
        }

        public String getCatUrl() throws URISyntaxException, JSONException, IOException {
            URI uri = new URIBuilder("http://localhost:60004/api/gratulation").build();
            JSONObject jObject = new JSONObject(execute(uri));
            return jObject.getString("cat_url");
        }

        private String execute(URI uri) throws IOException {
            return Request.Get(uri).execute().returnContent().asString();
        }

}
