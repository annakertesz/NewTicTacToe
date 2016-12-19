package GratulationService;

import GratulationService.Client.ApiService;
import GratulationService.Controller.ApiController;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by annakertesz on 12/18/16.
 */
public class GratulationServer {

    private ApiController controller;

    public static void main(String[] args) {

        GratulationServer application = new GratulationServer();

        application.controller = new ApiController(ApiService.getInstance());

        setup(args);

        // --- MAPPINGS ---

        get("/api/gratulation", application.controller::getCatUrl);
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
