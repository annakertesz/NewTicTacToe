package MainApplication;

import MainApplication.Controller.TemplateEngineController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;
import static spark.Spark.get;

/**
 * Created by annakertesz on 12/4/16.
 */
public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private static final int PORT = 9000;

    public static void main(String[] args) {
        logger.debug("Starting server...");

        // --- EXCEPTION HANDLING ---
        exception(Exception.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("Unexpected error occurred: %s", exception.getMessage()));
            logger.error("Error while processing request", exception);
        });

        staticFileLocation("/public");
        port(PORT);

//        get("/", (request, response) -> {
//            return MainController.TellJoke();
//        });

        get("/", TemplateEngineController::templateSelector, new ThymeleafTemplateEngine());
        get("/game-place", TemplateEngineController::templateSelector, new ThymeleafTemplateEngine());

    }
}
