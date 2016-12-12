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
    protected static final char ERROR = 'E';
    public static final char USERWIN = 'U';
    protected static final char COMPUTERWIN = 'C';
    protected static final char DRAW = 'D';

    private final GameApiService apiService;

    private ArrayList state = new ArrayList<>(Arrays.asList('.', '.','.', '.' , '.', '.', '.', '.','.'));

    public StateController(GameApiService apiService) {
        this.apiService = apiService;
    }

    public ArrayList step(String place) throws IOException, JSONException, URISyntaxException {
        int userIndex = Integer.parseInt(place);
        state.set(userIndex, USER);
        int computerIndex = getRecommendation(place);
        return messageCoder(computerIndex);
    }

    private int getRecommendation(String place) throws JSONException, IOException, URISyntaxException {
        return apiService.getState(place);
    }

    private ArrayList messageCoder(int code){
        switch (code){
            case 10: return send(DRAW);
            case 11: return send(USERWIN);
            case 12: return send(COMPUTERWIN);
            case 13: return send(ERROR);
            default: state.set(code, COMPUTER);
                return state;
        }
    }

    private ArrayList send(char message){
        state = new ArrayList<>(Arrays.asList('.', '.','.', '.' , '.', '.', '.', '.','.'));
        return new ArrayList<>(Arrays.asList(message));
    }

}
