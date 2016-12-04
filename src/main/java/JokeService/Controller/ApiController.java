package JokeService.Controller;

import JokeService.Client.ApiService;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/4/16.
 */
public class ApiController {

    public static String getCatFact() throws IOException, JSONException, URISyntaxException {
        return ApiService.getJoke();
    }

}
