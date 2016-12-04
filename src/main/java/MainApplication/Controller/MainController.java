package MainApplication.Controller;

import MainApplication.Clients.GameApiService;
import MainApplication.Clients.JokeApiService;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by annakertesz on 12/4/16.
 */
public class MainController {

    StateController stateController = new StateController(GameApiService.getInstance());

    public String tellJoke() throws URISyntaxException, IOException, JSONException {

        return JokeApiService.getJoke();

    }

    public ArrayList getState(String place) throws IOException, URISyntaxException, JSONException {
        return stateController.step(place);
    }
}
