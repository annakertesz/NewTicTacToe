package MainApplication.Controller;

import org.json.JSONException;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by annakertesz on 12/4/16.
 */
public class TemplateEngineController {

    private static MainController controller = new MainController();

    public static ModelAndView templateSelector(Request req, Response res) throws JSONException, IOException, URISyntaxException {
        String place = req.queryParams("place");
        ArrayList state = controller.getState(place);
        if (state.equals(Arrays.asList('X'))){
            return renderWon();
        }
        if (state.equals(Arrays.asList('O'))){
            return renderWon();
        }
        if (state.equals(Arrays.asList('-'))){
            return renderWon();
        }
        else {
            return renderGame(state);
        }
    }

    public static ModelAndView renderWon(){
        Map params = new HashMap<>();
        return new ModelAndView(params, "won");
    }

    public static ModelAndView renderGame(ArrayList state) throws JSONException, IOException, URISyntaxException {

        Map params = new HashMap<>();
//        params.put("avatar_url", "http://thecatapi.com/api/images/get?format=src&type=gif");
        params.put("cat_fact", controller.tellJoke());
        params.put("state", state);
        return new ModelAndView(params, "game");
    }

}
