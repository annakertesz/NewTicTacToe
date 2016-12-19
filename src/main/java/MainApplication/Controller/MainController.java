package MainApplication.Controller;

import MainApplication.Clients.*;
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
    GratulationApiService gratulationApiService = GratulationApiService.getInstance();
    AvatarApiService avatarApiService = AvatarApiService.getInstance();

    public String tellJoke() throws URISyntaxException, IOException, JSONException {
        return jokeApiService.getJoke();
    }

    public ArrayList getState(String place) throws IOException, URISyntaxException, JSONException{
        return stateController.step(place);
    }

    public String getGreeting() throws JSONException, IOException, URISyntaxException {
        return greetingApiService.getGreeting();
    }

    public String getCatUrl() throws JSONException, IOException, URISyntaxException {
        return gratulationApiService.getCatUrl();
    }

    public String getAvatarUrl(String id) throws IOException, JSONException, URISyntaxException {
        return avatarApiService.getAvatarUrl(id);
    }


}
