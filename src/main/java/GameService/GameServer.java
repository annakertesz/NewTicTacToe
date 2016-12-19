package GameService;

import GameService.Client.ApiService;
import GameService.Controller.GameController;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by annakertesz on 12/4/16.
 */
public class GameServer {

    private GameController controller;



    public static void main(String[] args) {
        setup(args);

        GameServer application = new GameServer();
        application.controller = new GameController(ApiService.getInstance());


        get("/api/state", (request, response) -> {
            int place = Integer.parseInt(request.queryParams("place"));
            String answerInJSON = application.controller.getAnswerInJSON(place);
            return answerInJSON;
        });
    }

    private static void setup(String[] args){
        if(args == null || args.length == 0){
            System.exit(-1);
        }

        try {
            port(Integer.parseInt(args[0]));
        } catch (NumberFormatException e){
            System.exit(-1);
        }
    }
}
