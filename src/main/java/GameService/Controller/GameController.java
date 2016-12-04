package GameService.Controller;

import GameService.Client.ApiService;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/4/16.
 */
public class GameController {

    private String state = "---------";
    private final ApiService apiService;

    public GameController(ApiService apiService) {
        this.apiService = apiService;
    }

//    public GameController() {
//        this.state = state;
//    }



    public String getState(int place) throws IOException, JSONException, URISyntaxException {
        step(place, 'X');
        String response = apiService.getResponse(state);
        System.out.println("COMMENT - response = " + response);
        JSONObject jObject = new JSONObject(response);
        int recommendation = Integer.parseInt(jObject.getString("recommendation"));
        System.out.println("COMMENT - recommendation = " + recommendation);
        step(recommendation, 'O');
        return response;
    }

    private void step(int place, char player){
        String newState = state.substring(0,place)+player+state.substring(place+1);
        state = newState;
    }





}
