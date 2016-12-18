package JokeService.Controller;

import JokeService.Client.ApiService;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/4/16.
 */
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public String getCatFact() throws IOException, JSONException, URISyntaxException {
        return ApiService.getJoke();
    }

}
