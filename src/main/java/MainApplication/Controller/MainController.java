package MainApplication.Controller;

import MainApplication.Clients.GameApiService;
import MainApplication.Clients.GreetingApiService;
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
    JokeApiService jokeApiService = JokeApiService.getInstance();
    GreetingApiService greetingApiService = GreetingApiService.getInstance();

    public String tellJoke() throws URISyntaxException, IOException, JSONException {
        return jokeApiService.getJoke();
    }

    public ArrayList getState(String place) throws IOException, URISyntaxException, JSONException {
        return stateController.step(place);
    }

    public String getGreeting() throws JSONException, IOException, URISyntaxException {
        return greetingApiService.getGreeting();
    }


}
