package JokeService;

import JokeService.Controller.ApiController;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by annakertesz on 12/4/16.
 */
public class JokeServer {

    public static void main(String[] args) {
        setup(args);

        get("/api/random", (request, response) -> {
            return ApiController.getCatFact();
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
