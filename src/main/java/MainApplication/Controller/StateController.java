package MainApplication.Controller;

import MainApplication.Clients.GameApiService;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by annakertesz on 12/4/16.
 */
public class StateController {

    private final GameApiService apiService;

    private ArrayList state = new ArrayList<>(Arrays.asList('.', '.','.', '.' , '.', '.', '.', '.','.'));

    public StateController(GameApiService apiService) {
        this.apiService = apiService;
    }

    public ArrayList step(String place) throws IOException, JSONException, URISyntaxException {
        int userIndex = Integer.parseInt(place);
        state.set(userIndex, 'X');
        if (isWon('X')){
            state = new ArrayList<>(Arrays.asList('.', '.','.', '.' , '.', '.', '.', '.','.'));
            return new ArrayList<>(Arrays.asList('X'));
        }
        int computerIndex = getRecommendation(place);
        state.set(computerIndex, 'O');
        if (isWon('O')){
            state = new ArrayList<>(Arrays.asList('.', '.','.', '.' , '.', '.', '.', '.','.'));
            return new ArrayList<>(Arrays.asList('O'));
        }
        return state;
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
        return state.get(i).equals(player) && state.get(i+dif).equals(player) && state.get(i+2*dif).equals(player);
    }

    private int getRecommendation(String place) throws JSONException, IOException, URISyntaxException {
        return Integer.parseInt(GameApiService.getState(place));
    }

}
