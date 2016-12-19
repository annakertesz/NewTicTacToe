package MainApplication.Controller;

import org.json.JSONException;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
        char message = (char) state.get(0);
        switch (message) {
            case StateController.USERWIN:
                return renderWon(req);
            case StateController.COMPUTERWIN:
                return renderLoose(req);
            case StateController.DRAW:
                return renderDraw(req);
            default:
                return renderGame(state, req);
        }
    }

    private static ModelAndView renderDraw(Request req) throws IOException, JSONException, URISyntaxException {
        Map params = new HashMap<>();
        params.put("gratulation", controller.getCatUrl());
        params.put("avatar_url", controller.getAvatarUrl(req.session().id()));
        return new ModelAndView(params, "/pages/draw");
    }

    private static ModelAndView renderLoose(Request req) throws IOException, JSONException, URISyntaxException {
        Map params = new HashMap<>();
        params.put("gratulation", controller.getCatUrl());
        params.put("avatar_url", controller.getAvatarUrl(req.session().id()));
        return new ModelAndView(params, "/pages/looser");
    }

    public static ModelAndView renderWelcome(Request req, Response res) throws IOException, JSONException, URISyntaxException {
        Map params = new HashMap<>();
        params.put("greeting", controller.getGreeting());
        params.put("avatar_url", controller.getAvatarUrl(req.session().id()));
        return new ModelAndView(params, "/pages/welcome");
    }

    public static ModelAndView renderWon(Request req) throws IOException, JSONException, URISyntaxException {
        Map params = new HashMap<>();
        params.put("gratulation", controller.getCatUrl());
        params.put("avatar_url", controller.getAvatarUrl(req.session().id()));
        return new ModelAndView(params, "/pages/congrat");
    }

    public static ModelAndView renderGame(ArrayList state, Request req) throws JSONException, IOException, URISyntaxException {

        Map params = new HashMap<>();
        params.put("avatar_url", "http://thecatapi.com/api/images/get?format=src&type=gif");
        params.put("cat_fact", controller.tellJoke());
        params.put("state", state);
        params.put("avatar_url", controller.getAvatarUrl(req.session().id()));
        return new ModelAndView(params, "/pages/game");
    }

}
