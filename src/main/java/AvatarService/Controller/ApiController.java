package AvatarService.Controller;

import AvatarService.Client.ApiService;
import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/18/16.
 */
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public String getAvatarUrl(Request req, Response res) throws IOException, JSONException, URISyntaxException {
        JSONObject obj = new JSONObject();
        String id = req.queryParams("id");
        try {
            obj.put("avatar_url",  apiService.getAvatarUrl(id));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }
}
