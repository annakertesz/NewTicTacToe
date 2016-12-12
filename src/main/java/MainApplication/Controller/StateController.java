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

    //    set players character here
    private final char USER = 'X';
    private final char COMPUTER = 'O';

    //    game massages stored in character
    protected final int ERROR = 'E';
    protected final int USERWIN = 'U';
    protected final int COMPUTERWIN = 'C';
    protected final int DRAW = 'D';

    private final GameApiService apiService;

    private ArrayList state = new ArrayList<>(Arrays.asList('.', '.','.', '.' , '.', '.', '.', '.','.'));

    public StateController(GameApiService apiService) {
        this.apiService = apiService;
    }

    public ArrayList step(String place) throws IOException, JSONException, URISyntaxException {
        int userIndex = Integer.parseInt(place);
        state.set(userIndex, USER);
        int computerIndex = getRecommendation(place);
        if (computerIndex>9) return new ArrayList<>(Arrays.asList(USERWIN));
        state.set(computerIndex, COMPUTER);
        return state;
    }

    private int getRecommendation(String place) throws JSONException, IOException, URISyntaxException {
        return apiService.getState(place);
    }

}
