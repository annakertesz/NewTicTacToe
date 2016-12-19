package AvatarService.Client;

import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/18/16.
 */
public class ApiService {

    private static ApiService INSTANCE;

    public ApiService() {
    }


    public static ApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiService();
        }
        return INSTANCE;
    }


    public static String getAvatarUrl(String id) throws URISyntaxException, JSONException, IOException {
        return "https://robohash.org/" + id;
    }

}
