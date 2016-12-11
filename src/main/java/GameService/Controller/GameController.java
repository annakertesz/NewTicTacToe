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

    private String state;
    private final ApiService apiService;

    public GameController(ApiService apiService) {
        this.apiService = apiService;
        this.state = "---------";
    }

    public String getAnswerInJSON(int place){
        JSONObject obj = new JSONObject();
        try {
            obj.put("recommendation",  getState(place));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }

    private int getState(int place){
        String response;
        int recommendation = 13;

        step(place, 'X');
        if (isWon('X')) return 11;

        try {
            response = apiService.getResponse(state);
            System.out.println("COMMENT - response = " + response);
            JSONObject jObject = null;
            jObject = new JSONObject(response);
            recommendation = 0;
            recommendation = Integer.parseInt(jObject.getString("recommendation"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("COMMENT - recommendation = " + recommendation);
        step(recommendation, 'O');
        if (isWon('O')) return 12;
        return recommendation;
    }

    private void step(int place, char player){
        String newState = state.substring(0,place)+player+state.substring(place+1);
        state = newState;
        if (isWon(player)) newGame();
    }

    private boolean isWon(char player) {
        return horizontal(player) || vertical(player) || diagonal(player);
    }

    private boolean horizontal(char player){
        return isFull(0, 3, player) || isFull(1, 3, player) || isFull(2, 3, player);
    }

    private boolean vertical(char player){
        return isFull(0, 1, player) || isFull(3, 1, player) || isFull(6, 1, player);
    }

    private boolean diagonal(char player){
        return isFull(0, 4, player) || isFull(2, 2, player);
    }

    private boolean isFull(int i, int dif, char player){
        return state.charAt(i) == player && state.charAt(i+dif) == player && state.charAt(i+2*dif) == player;
    }

    public void newGame(){
        state = "---------";
    }
}
